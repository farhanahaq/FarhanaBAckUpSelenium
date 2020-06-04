package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
public class AddContactTest {
	
WebDriver driver;


	@Test
	@Parameters({"userName", "password", "fullname", "companyname", "email", "phone", "address", "city", "state", "zip"})//these arguments coming from .xml doc
	public void validUserShouldBeAbleToLogin(String userName, String password, String fullName, String CompanyName, String email, String phone, String address, String city, String state, String zip) throws InterruptedException { //these arguments
		//these arguments needs to be passed to Page.class methods
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		// calling methods of Login.page class to pass login credentials to login 
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		loginpage.clickSubmitButton();
		Thread.sleep(2000);
		
		//creating object for dashboardpage class and validating dashboardpage title
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.chkDashBoardTabVisible();

		// creating object of class AddContactPage
		AddContactPage addContact = PageFactory.initElements(driver, AddContactPage.class);
		// calling method to click on buttons
		addContact.AddContactButton();

		// calling method of AddContactPage class to pass values to create new contact
		// from excel sheet
//		String fullName = "null";
//		String CompanyName = "null";
//		String email = "null";
//		String phone = "null";
//		String address = "null";
//		String city = "null";
//		String state = "null";
//		String zip = "null";

		// calling methods from page class to pass on data from excel to create new
		// contact info
		addContact.AddContactName(fullName);
		addContact.AddCompanyName(CompanyName);
		addContact.AddEmail(email);
		addContact.AddPhone(phone);
		addContact.AddAddress(address);
		addContact.AddCity(city);
		addContact.AddState(state);
		addContact.AddZip(zip);
		addContact.SubmitButton();
		// clicking on List contact
		addContact.List_Contact_click();
		addContact.Contact_Search_name(fullName);
		addContact.Contact_Search_Button_Click();
		addContact.scrollingUpDown();
		addContact.deleteEnteredContact();
		
		BrowserFactory.tearDown();

	}
	

}