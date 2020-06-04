package test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import page.AddDeleteContact;
import page.BankNCash;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class test {
	WebDriver driver;
	
	// creating method to call methods from other class(es)

	@Test (priority =1 )
	public void validUserShdBeAbleToLogin() {
		// calling method from BrowserFactory without creating object as it is a static
		// method

		driver = BrowserFactory.launchBrowser();// will launch browser and go to website and return webdriver

		// creating object for non-static methods from diff class passing driver and
		// that class page
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		// calling method to pass login credentials
		loginpage.enterUserName("techfiosdemo@gmail.com");
		loginpage.enterPassword("abc123");
		loginpage.clickSubmitButton();
	}

	@Test (priority =2)
	public void chkDashBoardPage() {
		// calling method from BrowserFactory without creating object as it is a static
		// method

		driver = BrowserFactory.launchBrowser();// will launch browser and go to website and return webdriver

		// creating object for non-static methods from diff class passing driver and
		// that class page
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		// calling method to pass login credentials
		loginpage.enterUserName("techfiosdemo@gmail.com");
		loginpage.enterPassword("abc123");
		loginpage.clickSubmitButton();

		DashBoardPage dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardpage.chkDashBoardTabVisible();

	}
	
	@Test(priority = 3)
	public void createNewACPage() throws InterruptedException {
		// accessing method from BrowserFactory without creating object as it is a
		// static method
		// will launch browser and go to website and return webdriver
		driver = BrowserFactory.launchBrowser();

		// creating Login page object for non-static methods from diff class passing
		// driver and that class page
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		// calling method to pass login credentials
		loginpage.enterUserName("techfiosdemo@gmail.com");
		loginpage.enterPassword("abc123");
		loginpage.clickSubmitButton();

		// creating Dashboard object
		DashBoardPage dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardpage.chkDashBoardTabVisible();// checking button visibility

		// creating BankNCash object
		BankNCash bankncash = PageFactory.initElements(driver, BankNCash.class);
		bankncash.newAccountButtons();// clicking on New Account Button

		// Regular Test Data
		String ACTitle = "Rubyred";
		String description = "Business";
		String balance = "500";

		// Randomizing ACTitle and Balance
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);
		Thread.sleep(3000);
		// Adding random number to ACTitle and Balance
		String name_final = ACTitle + randomNumber;
		String balance_final = balance + randomNumber;

		// passing data to input text boxes on Add New AC window
		bankncash.enterACName(name_final);
		bankncash.enterDescription(description);
		bankncash.enterBalance(balance_final);
		bankncash.clickSubmit();
		bankncash.isAccountCreated();
		
	}
	
	@Test(priority = 4)
	public void createNewContactPage() throws InterruptedException {
		// accessing method from BrowserFactory without creating object as it is a
		// static method
		// will launch browser and go to website and return webdriver
		driver = BrowserFactory.launchBrowser();

		// creating Login page object for non-static methods from diff class passing
		// driver and that class page
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		// calling method to pass login credentials
		loginpage.enterUserName("techfiosdemo@gmail.com");
		loginpage.enterPassword("abc123");
		loginpage.clickSubmitButton();

		// creating Dashboard object
		DashBoardPage dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardpage.chkDashBoardTabVisible();// checking button visibility

		// generating random number variable
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);

		// Test Data - regular
		String fullName = "Green" + randomNumber;
		String companyName = "MeanGreen";
		String emailId = "green@gmail.com";
		String phoneNumber = "1234567890";
		String address = "heaven Road";
		String city = "Riverdale";
		String state = "FL";
		String zip = "23145";
		
		//creating AddDeleteContact page object
		AddDeleteContact addDeleteContact = PageFactory.initElements(driver, AddDeleteContact.class);
		
		//calling methods to pass on new contact info
		addDeleteContact.AddContactButton();
		addDeleteContact.AddContactName(fullName);
		addDeleteContact.AddCompanyName(companyName);
		addDeleteContact.AddEmail(emailId);
		addDeleteContact.AddPhone(phoneNumber);
		addDeleteContact.AddAddress(address);
		addDeleteContact.AddCity(city);
		addDeleteContact.AddState(state);
		addDeleteContact.AddZip(zip);
		addDeleteContact.SubmitButton();
		//clicking on List contact
		addDeleteContact.List_Contact_click();
		addDeleteContact.Contact_Search_name(fullName);
		addDeleteContact.Contact_Search_Button_Click();
		addDeleteContact.VerifyAddContact(fullName);
		addDeleteContact.scrollingUpDown();	
		
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
