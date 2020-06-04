package HW;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HW_4_5 {

	WebDriver driver;
	String browser;

	@BeforeTest
	public void readConfig() {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(".\\src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	@BeforeMethod
	public void init() {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\14693\\eclipse-workspace-2\\LaunchBrowser\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize(); // maximing it
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website
	}

	@Test(priority=1)
	public void loginTest() {
		// Element Library
		By USER_NAME_FIELD = By.id("username");
		By PASSWORD_FIELD = By.id("password");
		By SIGNIN_BUTTON = By.name("login");
		By DASHBOARD_PAGE_TITLE = By.xpath("//span[contains(text(), 'Dashboard')]");
		By CRM_BUTTON = By.xpath("//span[contains(text(), 'CRM')]");

		// Login DATA
		String loginId = "techfiosdemo@gmail.com";
		String password = "abc123";

		// Login Action
		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();

		// Validate dashboard page
		WebElement dashboardPageTitle = driver.findElement(DASHBOARD_PAGE_TITLE);
		Assert.assertEquals("Wrong page!!", "Dashboard", dashboardPageTitle.getText());
		waitForElement(driver, 2, CRM_BUTTON);
	}

	@Test(priority=2)
	public void Add_Verify_Delete_Contact() throws InterruptedException {
		// Element Library
		By USER_NAME_FIELD = By.id("username");
		By PASSWORD_FIELD = By.id("password");
		By SIGNIN_BUTTON = By.name("login");
		By CRM_BUTTON = By.xpath("//span[contains(text(), 'CRM')]");
		By ADD_CONTACT_BUTTON = By.xpath("//a[contains(text(), 'Add Contact')]");
		By FULL_NAME_FIELD = By.xpath("//input[@id='account']");
		By COMPANY_NAME_FIELD = By.xpath("//input[@id='company']");
		By EMAIL_FIELD = By.xpath("//input[@id='email']");
		By PHONE_FIELD = By.xpath("//input[@id='phone']");
		By ADDRESS_FIELD = By.xpath("//input[@id='address']");
		By CITY_FIELD = By.xpath("//input[@id='city']");
		By STATE_REGION_FIELD = By.xpath("//input[@id='state']");
		By ZIP_FIELD = By.xpath("//input[@id='zip']");
		By SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-primary']");
		By LIST_CONTACTS_BUTTON = By.xpath("//a[contains(text(),'List Contacts')]");
		By CONTACT_SEARCH_BOX = By.xpath("//div[@class='input-group']/input");
		By CONTACT_SEARCH_BUTTON = By.xpath("//button[@class='btn btn-primary']");

		// Login DATA
		String loginId = "techfiosdemo@gmail.com";
		String password = "abc123";

		// Test Data - regular
		String fullName = "Ronon";
		String companyName = "RonSpaceShip";
		String emailId = "Ron17@gmail.com";
		String phoneNumber = "1234567890";
		String address = "213 Sunny Side Road";
		String city = "Santa Clara";
		String state = "CA";
		String zip = "23145";

		// Logging in
		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();
		
		//waiting for CRM tab to be visible
		waitForElement(driver, 2, CRM_BUTTON);

		// Go to Add Contact
		driver.findElement(CRM_BUTTON).click();
		waitForElement(driver, 2, ADD_CONTACT_BUTTON);
		driver.findElement(ADD_CONTACT_BUTTON).click();
		Thread.sleep(5000);

		// generating random number variable
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);
		Thread.sleep(5000);

		// Fill out add contact form with regular + randomized number
		String name_final = fullName + randomNumber;
		driver.findElement(FULL_NAME_FIELD).sendKeys(name_final);
		Thread.sleep(3000);
		driver.findElement(COMPANY_NAME_FIELD).sendKeys(companyName);
		Thread.sleep(3000);
		driver.findElement(EMAIL_FIELD).sendKeys(emailId);
		Thread.sleep(3000);
		driver.findElement(PHONE_FIELD).sendKeys(phoneNumber);
		Thread.sleep(3000);
		driver.findElement(ADDRESS_FIELD).sendKeys(address);
		driver.findElement(CITY_FIELD).sendKeys(city);
		driver.findElement(STATE_REGION_FIELD).sendKeys(state);
		driver.findElement(ZIP_FIELD).sendKeys(zip);
		driver.findElement(SUBMIT_BUTTON).click();
		Thread.sleep(5000);

		// Validate added contact on list contact
		driver.findElement(LIST_CONTACTS_BUTTON).click();
		Thread.sleep(5000);
		driver.findElement(CONTACT_SEARCH_BOX).sendKeys(name_final);
		Thread.sleep(5000);
		driver.findElement(CONTACT_SEARCH_BUTTON).click();
		Thread.sleep(3000);
		
		By NAME_VERIFY_FIELD = By.xpath("//a[contains(text(), '" + name_final + "')]");
		waitForElement(driver, 5, NAME_VERIFY_FIELD);
		
		System.out.println("Expected Contact Name :" + name_final);
		System.out.println("Added Contact Name :" + driver.findElement(NAME_VERIFY_FIELD).getText());
		Assert.assertEquals("Contact not created!", name_final, driver.findElement(NAME_VERIFY_FIELD).getText());
		Thread.sleep(3000);
				
		//Deleting Contacts
		driver.findElement(By.xpath(
				"//a[contains(text(), '" + name_final + "')]//parent::td//following-sibling::td[4]//child::a[2]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		By CONTACT_DELETE_MSG = By.xpath("//div[@class='alert alert-success fade in']");
		
		
		try{
			waitForElement(driver, 2, CONTACT_DELETE_MSG);
			Thread.sleep(2000);
			System.out.println("Contact DELETED!");
			//By CHECK_SUCCESS_MSG = By.xpath("//div[@class='alert alert-success fade in']//i/following-sibling::text()[contains(.,'')]");
			//Thread.sleep(2000);
			//System.out.println(driver.findElement(CHECK_SUCCESS_MSG).getText());
			
			}catch (ElementNotVisibleException e) {
			System.out.println("Contact was NOT deleted!");
				e.printStackTrace();
			}
		
		//scroll up and down
		Thread.sleep(2000);
		JavascriptExecutor up_down = (JavascriptExecutor) driver;
		up_down.executeScript("scroll(0, 1800)");
		Thread.sleep(2000);
		up_down.executeScript("scroll(0, 0)");
		Thread.sleep(2000);

	}
	
	@Test(priority=3)
	public void AddNew_VerifyAdd_Account() throws InterruptedException {

		// Element Library
		By USER_NAME_FIELD = By.id("username");
		By PASSWORD_FIELD = By.id("password");
		By SIGNIN_BUTTON = By.name("login");
		By BANK_CASH_BUTTON = By.xpath("//span[contains(text(), 'Bank & Cash')]");
		By ADD_NEW_ACCOUNT_BUTTON = By.xpath("//a[contains(text(), 'New Account')]");
		By ACCOUNT_TITLE = By.xpath("//input[@id='account']");
		By DESCRIPTION = By.xpath("//input[@id='description']");
		By BALANCE = By.xpath("//input[@id='balance']");
		By SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-primary']");
		By AC_ADD_SUCCESS_MSG = By.xpath("//div[@class='alert alert-success fade in']");
		

		// Login DATA
		String loginId = "techfiosdemo@gmail.com";
		String password = "abc123";

		// Regular Test Data
		String ACTitle = "Rubyred";
		String description = "Business";
		String balance = "500";

		// Login in
		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();

		//go to BANK and CASH and ADD New AC Button
		waitForElement(driver, 2, BANK_CASH_BUTTON);
		driver.findElement(BANK_CASH_BUTTON).click();
		waitForElement(driver, 10, ADD_NEW_ACCOUNT_BUTTON);
		driver.findElement(ADD_NEW_ACCOUNT_BUTTON).click();
		Thread.sleep(5000);

		// Randomize ACTitle and Balance
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);
		Thread.sleep(3000);

		String name_final = ACTitle + randomNumber;
		String balance_final = balance + randomNumber;
				
		//Filling out form	with regular and randomized values	
		driver.findElement(ACCOUNT_TITLE).sendKeys(name_final);
		Thread.sleep(2000);
		driver.findElement(DESCRIPTION).sendKeys(description);
		Thread.sleep(2000);
		driver.findElement(BALANCE).sendKeys(balance_final);
		Thread.sleep(2000);
		driver.findElement(SUBMIT_BUTTON).click();
		Thread.sleep(5000);
			
		// Validate AC ADD Success Message
		try{
		waitForElement(driver, 2, AC_ADD_SUCCESS_MSG);
		Thread.sleep(2000);
		System.out.println("ACCOUNT was created!");
		
		}catch (ElementNotVisibleException e) {
		System.out.println("Account was NOT created!");
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1200)");
		Thread.sleep(3000);
		js.executeScript("scroll(0,0)");
		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		// driver.quit();
	}

	public void waitForElement(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
