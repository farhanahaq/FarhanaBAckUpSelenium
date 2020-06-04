package session5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CRMTest {
	WebDriver driver;
	
	@BeforeTest
	public void init() {
	//WebDriver driver;
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize(); // maximing it
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website	
	}
	
	@Test
	public void loginTest() {
	//Element Library
	By USER_NAME_FIELD = By.id("username");
	By PASSWORD_FIELD = By.id("password");
	By SIGNIN_BUTTON = By.name("login");
	
	//DATA
	String loginId = "techfiosdemo@gmail.com";
	String password = "abc123";
	
	//passing credentials to elements
	driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
	driver.findElement(PASSWORD_FIELD).sendKeys(password);
	driver.findElement(SIGNIN_BUTTON).click();
	//Thread.sleep(2000);
	
	}
}