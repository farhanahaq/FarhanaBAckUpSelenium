package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
	WebDriver driver;
	
//	String userName = "techfiosdemo@gmail.com";
//	String passWord = "abc123";
	
	@Test
	@Parameters({"userName", "password"})//these arguments coming from .xml doc
	public void validUserShouldBeAbleToLogin(String userName, String password) throws InterruptedException { //these arguments
		//these arguments are coming from Page.class methods
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		// calling methods of Login.page class to pass login credentials to login 
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		loginpage.clickSubmitButton();
		Thread.sleep(2000);
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.chkDashBoardTabVisible();
		
		BrowserFactory.tearDown();
	
	}

}
