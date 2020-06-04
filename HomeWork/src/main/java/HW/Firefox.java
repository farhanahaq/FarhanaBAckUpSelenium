package HW;

//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox {

	public static void main(String[] args) throws InterruptedException {
		
		//passing location of Firefox driver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\14693\\eclipse-workspace-2\\LaunchBrowser\\Drivers\\geckodriver.exe");
		
		//creating firefox webdriver d
		WebDriver d = new FirefoxDriver();

		//loading billing test site and logging in
		d.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website
		d.manage().window().maximize(); // maximing it
		d.findElement(By.name("username")).sendKeys("techfiosdemo@gmail.com");
		d.findElement(By.name("password")).sendKeys("abc123");
		d.findElement(By.name("login")).click();
		
		// HW#2
		//Making new deposit of amount $10 with 'Deposit' description for user number #15 using Deposit button under Transaction menu
		
		d.findElement(By.xpath("//span[contains(text(), 'Transactions')]")).click();//Transaction tab
		d.findElement(By.xpath("//a[contains(text(), 'New Deposit')]")).click();//New deposit tab
		d.findElement(By.id("select2-account-container")).click();//drop down list
		d.findElement(By.id("select2-account-container")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//ul[@id='select2-account-results']//child::li[15]")).click();//selecting item from dropdown list
		d.findElement(By.xpath("//input[@id='description']")).sendKeys("Deposit");//description
		d.findElement(By.xpath("//input[@id='amount']")).sendKeys("10.00");//amount
		d.findElement(By.xpath("//button[@id='submit']")).click();//submit
		
		//Checking element "Transaction was successful" is visible
		By recentDepositVerifyLocator = By.xpath("//*[@class='alert alert-success fade in']"); //successful info display element 
		WebDriverWait waitForDeposit = new WebDriverWait(d, 5); //explicit wait making it wait until it is visible
		waitForDeposit.until(ExpectedConditions.visibilityOfElementLocated(recentDepositVerifyLocator));
		System.out.println("Deposit Added Success");
		
		//Verifying Deposit amount and description 
		//Expected values 
		String expectedDes = "Deposit";
		String expectedAmount = "10.00";
		String expectedAll = expectedDes + expectedAmount;
		
		//Getting actual values from table
		By recentDepositLocator = By.xpath("//table/tbody/descendant::tr[1]/td[1]/a");//description from table
		String displayedDescription = d.findElement(recentDepositLocator).getText();
		By recentDepositLocator1 = By.xpath("//table/tbody/descendant::tr[1]/td[2]");//amount from table
		String displayedDescription1 = d.findElement(recentDepositLocator1).getText();
		String actualAll = displayedDescription + displayedDescription1;
		
		//Printout to verify
		System.out.println("************************************************");
		System.out.println(
				"Expected Description Typed: " + expectedDes + " and Expected Added Amount: " + expectedAmount);
		System.out.println(
				"Actual Description Typed: " + displayedDescription + " and Added Amount: " + displayedDescription1);

		//Using Assert function to compare actual and expected result
		Assert.assertEquals("Deposit Transaction not found!", expectedAll, actualAll);
		System.out.println("Deposit Test Passed");
		System.out.println("************************************************");

		// HW#3
		//Making transfer between two accounts of amount $10 and description Transfer
		d.findElement(By.xpath("//a[contains(text(), 'Transfer')]")).click();
		d.findElement(By.id("select2-faccount-container")).click();
		d.findElement(By.xpath("//ul[@id='select2-faccount-results']//child::li[8]")).click();
		d.findElement(By.id("select2-taccount-container")).click();
		d.findElement(By.xpath("//ul[@id='select2-taccount-results']//child::li[9]")).click();
		d.findElement(By.xpath("//input[@id='description']")).sendKeys("Transfer");
		d.findElement(By.xpath("//input[@id='amount']")).sendKeys("10.00");
		d.findElement(By.xpath("//button[@id='submit']")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicit wait 
		
		//Making sure 'Transaction was successful' message  is present on the page
		boolean transDisplayStatus;
		try {
			//WebElement DASHBOARD_PAGE_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
			WebElement TRANSFER_VERIFY_ELEMENT = d.findElement(recentDepositVerifyLocator);
			transDisplayStatus = true;
			System.out.println("Transfer Success");

		} catch (NoSuchElementException e) {

			transDisplayStatus = false;
			e.printStackTrace();
		}
	
		//Verifying Transfer
		//Expected values
		String expectedTrans = "Transfer";
		String expectedTransAmount = "10.00";
		String expectedTransAll = expectedTrans + expectedTransAmount;
		
		//Getting actual values from table
		By recentTranLocator = By.xpath("//table/tbody/descendant::tr[1]/td[2]/a");
		String displayedTransfer = d.findElement(recentTranLocator).getText();
		By recentTranLocator1 = By.xpath("//table/tbody/descendant::tr[1]/td[3]");
		String displayedTransfer1 = d.findElement(recentTranLocator1).getText();
		String actualTranAll = displayedTransfer + displayedTransfer1;
		
		//Printout for verification 
		System.out.println("************************************************");
		System.out.println("Expected Transfer Description: " + expectedTrans + " and Expected Added Amount: "
				+ expectedTransAmount);
		System.out.println(
				"Actual Transfer Description: " + displayedTransfer + " and Added Amount: " + displayedTransfer1);
		
		//Assert function to compare actual and expected values
		Assert.assertEquals("Transfer Transaction not found!", expectedTransAll, actualTranAll);
		System.out.println("Transfer Test Passed");
		System.out.println("************************************************");

		//Closing browser.
		d.close();
		d.quit();
	

	}// end of main

}// end of class
