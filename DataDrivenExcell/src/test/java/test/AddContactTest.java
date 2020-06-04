package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcellReader;

public class AddContactTest {
	
WebDriver driver;

	// passing sheetname, column name and row numbers with login credentials from
	// excel file
	// to use it in methods of LoginPage.java to login
	//as global variables so that various pages can use it login to test functionality

	// created object 'reader' of class ExcellReader class and passing excell doc in
	// Drivers folder
	ExcellReader reader = new ExcellReader("./Data/DataDrivenExcel.xlsx");
	// passing excel sheet values in methods of ExcellReader class
	String userName = reader.getCellData("Logininfo", "UserName", 2);
	String passWord = reader.getCellData("Logininfo", "Password", 2);

	@Test
	public void validUserShouldBeAbleToLogin() throws InterruptedException {
		driver = BrowserFactory.init();

		// creating object of class LoginPage
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		// calling methods of Login.page class to pass excel doc login credentials
		loginpage.enterUserName(userName);
		loginpage.enterPassword(passWord);
		loginpage.clickSubmitButton();

		// creating object of class AddContactPage
		AddContactPage addContact = PageFactory.initElements(driver, AddContactPage.class);
		// calling method to click on buttons
		addContact.AddContactButton();

		// calling method of AddContactPage class to pass values to create new contact
		// from excel sheet
		String fullName = reader.getCellData("AddContactInfo", "FullName", 2);
		String CompanyName = reader.getCellData("AddContactInfo", "CompanyName", 2);
		String email = reader.getCellData("AddContactInfo", "Email", 2);
		String phone = reader.getCellData("AddContactInfo", "Phone", 2);
		String address = reader.getCellData("AddContactInfo", "Address", 2);
		String city = reader.getCellData("AddContactInfo", "City", 2);
		String state = reader.getCellData("AddContactInfo", "State", 2);
		String zip = reader.getCellData("AddContactInfo", "Zip", 2);

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

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	

}
}