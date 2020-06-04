package page;

//import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
//import org.testng.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.ElementNotVisibleException;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDeleteContact {
	WebDriver driver;

	public AddDeleteContact(WebDriver driver) {
		this.driver = driver;

	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'CRM')]")
	WebElement CRM_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Contact')]")
	WebElement ADD_CONTACT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='company']")
	WebElement COMPANY_NAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_REGION_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement SUBMIT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Contacts')]")
	WebElement LIST_CONTACTS_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//div[@class='input-group']/input")
	WebElement CONTACT_SEARCH_BOX_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement CONTACT_SEARCH_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement CONTACT_DELETE_MSG_LOCATOR;

	// Click on Add Contact Button
	public void AddContactButton() {
		waitForElement(driver, 2, CRM_BUTTON_LOCATOR);
		CRM_BUTTON_LOCATOR.click();
		waitForElement(driver, 2, ADD_CONTACT_BUTTON_LOCATOR);
		ADD_CONTACT_BUTTON_LOCATOR.click();
		System.out.println("Add New AC Button is Visible");
	}

//creating method to pass values to create new Contact
	public void AddContactName(String contactname) throws InterruptedException {
		Thread.sleep(3000); // because random number takes time sometimes
		FULL_NAME_FIELD_LOCATOR.sendKeys(contactname);
	}

	public void AddCompanyName(String companyname) {
		COMPANY_NAME_FIELD_LOCATOR.sendKeys(companyname);
	}

	public void AddEmail(String email) {
		EMAIL_FIELD_LOCATOR.sendKeys(email);
	}

	public void AddPhone(String phoneno) {
		PHONE_FIELD_LOCATOR.sendKeys(phoneno);
	}

	public void AddAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}

	public void AddCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}

	public void AddState(String state) {
		STATE_REGION_FIELD_LOCATOR.sendKeys(state);
	}

	public void AddZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}

	public void SubmitButton() {
		SUBMIT_BUTTON_LOCATOR.click();
	}

	public void List_Contact_click() {
		waitForElement(driver, 5, LIST_CONTACTS_BUTTON_LOCATOR);
		LIST_CONTACTS_BUTTON_LOCATOR.click();
	}

	public void Contact_Search_name(String fullname) {
		CONTACT_SEARCH_BOX_LOCATOR.sendKeys(fullname);
		System.out.println(fullname);
	}

	public void Contact_Search_Button_Click() throws InterruptedException {
		CONTACT_SEARCH_BUTTON_LOCATOR.click();
		Thread.sleep(3000);
	}

	public void VerifyAddContact(String somename) throws InterruptedException {

		//wait for contact name to be visible after search for it 
		By NAME_VERIFY_FIELD = By.xpath("//a[contains(text(), '" + somename + "')]");
		waitForElementLOCATOR(driver, 5, NAME_VERIFY_FIELD);
		
		// CLicking Deleting button on contact name
		driver.findElement(By
				.xpath("//a[contains(text(), '" + somename + "')]//parent::td//following-sibling::td[4]//child::a[2]"))
				.click();
		
		//clicking ok button to delete
		By DELETE_OK_LOCATOR = By.xpath("//button[contains(text(), 'OK')]");
		waitForElementLOCATOR(driver, 3, DELETE_OK_LOCATOR);
		driver.findElement(DELETE_OK_LOCATOR).click();
		
		//using try catch to verify 'contact was deleted' msg locator
		
		
		try {
			waitForElement(driver, 4, CONTACT_DELETE_MSG_LOCATOR);
			// Thread.sleep(2000);
			System.out.println("Contact DELETED!");
			
			// could not make it work!!
//			 By CHECK_SUCCESS_MSG = By.xpath("//div[@class='alert alert-success fade
//			 in']//i/following-sibling::text()[contains(.,'')]");
//			Thread.sleep(2000);
//			 System.out.println(driver.findElement(CHECK_SUCCESS_MSG).getText());
//
		} catch (ElementNotVisibleException e) {
			System.out.println("Contact was NOT deleted!");
			e.printStackTrace();
		}
	}

	public void scrollingUpDown() throws InterruptedException {

		// scroll up and down
		JavascriptExecutor up_down = (JavascriptExecutor) driver;
		up_down.executeScript("scroll(0, 1800)");
		Thread.sleep(2000);
		up_down.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
	}

	public void waitForElement(WebDriver driver2, int timeInSeconds, WebElement dASHBOARD_PAGE_TITLE_LOCATOR2) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(dASHBOARD_PAGE_TITLE_LOCATOR2));

	}

	public void waitForElementLOCATOR(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
