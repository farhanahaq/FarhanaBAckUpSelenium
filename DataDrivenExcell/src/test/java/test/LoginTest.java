package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcellReader;

public class LoginTest {
	
	WebDriver driver;
	
	//passing sheetname, column name and row numbers with login credentials from excel file
	//to use it in methods of LoginPage.java to login
	
	//created object 'reader' of class ExcellReader class
	ExcellReader reader = new ExcellReader("./Data/DataDrivenExcel.xlsx");
	//passing excel sheet values in methods of ExcellReader class 
	String userName = reader.getCellData("Logininfo", "UserName", 2);
	String passWord = reader.getCellData("Logininfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		// calling methods of Login.page class to pass login credentials to login 
		loginpage.enterUserName(userName);
		loginpage.enterPassword(passWord);
		loginpage.clickSubmitButton();

	
	}

}
