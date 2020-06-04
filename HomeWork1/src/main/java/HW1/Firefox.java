package HW1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\14693\\eclipse-workspace-2\\LaunchBrowser\\Drivers\\geckodriver.exe");
		WebDriver d = new FirefoxDriver();

		// HW#2
		d.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website
		d.manage().window().maximize(); // maximing it
		d.findElement(By.name("username")).sendKeys("techfiosdemo@gmail.com");
		d.findElement(By.name("password")).sendKeys("abc123");
		d.findElement(By.name("login")).click();
		d.findElement(By.xpath("//span[contains(text(), 'Transactions')]")).click();
		d.findElement(By.xpath("//a[contains(text(), 'New Deposit')]")).click();
		d.findElement(By.id("select2-account-container")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//ul[@id='select2-account-results']//child::li[15]")).click();
		d.findElement(By.xpath("//input[@id='description']")).sendKeys("Deposit");
		d.findElement(By.xpath("//input[@id='amount']")).sendKeys("10.00");
		d.findElement(By.xpath("//button[@id='submit']")).click();

		By recentDepositVerifyLocator = By.xpath("//*[@class='alert alert-success fade in']");
		WebDriverWait waitForDeposit = new WebDriverWait(d, 5);
		waitForDeposit.until(ExpectedConditions.visibilityOfElementLocated(recentDepositVerifyLocator));
		System.out.println("Deposit Added Success");

		String expectedDes = "Deposit";
		String expectedAmount = "10.00";
		String expectedAll = expectedDes + expectedAmount;
		// System.out.println(expectedAll);

		By recentDepositLocator = By.xpath("//table/tbody/descendant::tr[1]/td[1]/a");
		String displayedDescription = d.findElement(recentDepositLocator).getText();
		By recentDepositLocator1 = By.xpath("//table/tbody/descendant::tr[1]/td[2]");
		String displayedDescription1 = d.findElement(recentDepositLocator1).getText();
		String actualAll = displayedDescription + displayedDescription1;
		// System.out.println(actualAll);

		System.out.println("************************************************");
		System.out.println(
				"Expected Description Typed: " + expectedDes + " and Expected Added Amount: " + expectedAmount);
		System.out.println(
				"Actual Description Typed: " + displayedDescription + " and Added Amount: " + displayedDescription1);

		Assert.assertEquals("Deposit Transaction not found!", expectedAll, actualAll);
		System.out.println("Deposit Test Passed");
		System.out.println("************************************************");

		// next HW#3
		d.findElement(By.xpath("//a[contains(text(), 'Transfer')]")).click();
		d.findElement(By.id("select2-faccount-container")).click();
		d.findElement(By.xpath("//ul[@id='select2-faccount-results']//child::li[8]")).click();
		d.findElement(By.id("select2-taccount-container")).click();
		d.findElement(By.xpath("//ul[@id='select2-taccount-results']//child::li[9]")).click();
		d.findElement(By.xpath("//input[@id='description']")).sendKeys("Transfer");
		d.findElement(By.xpath("//input[@id='amount']")).sendKeys("10.00");
		d.findElement(By.xpath("//button[@id='submit']")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
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
	
		
		String expectedTrans = "Transfer";
		String expectedTransAmount = "10.00";
		String expectedTransAll = expectedTrans + expectedTransAmount;
		// System.out.println(expectedTransAll);

		By recentTranLocator = By.xpath("//table/tbody/descendant::tr[1]/td[2]/a");
		String displayedTransfer = d.findElement(recentTranLocator).getText();
		By recentTranLocator1 = By.xpath("//table/tbody/descendant::tr[1]/td[3]");
		String displayedTransfer1 = d.findElement(recentTranLocator1).getText();
		String actualTranAll = displayedTransfer + displayedTransfer1;
		// System.out.println(actualTranAll);

		System.out.println("************************************************");
		System.out.println("Expected Transfer Description: " + expectedTrans + " and Expected Added Amount: "
				+ expectedTransAmount);
		System.out.println(
				"Actual Transfer Description: " + displayedTransfer + " and Added Amount: " + displayedTransfer1);

		Assert.assertEquals("Transfer Transaction not found!", expectedTransAll, actualTranAll);
		System.out.println("Transfer Test Passed");
		System.out.println("************************************************");

		d.quit();
		d.close();

	}// end of main

}// end of class
