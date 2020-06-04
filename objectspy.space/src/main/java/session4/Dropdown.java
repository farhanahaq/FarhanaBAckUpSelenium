package session4;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	public static void main(String[] args) throws InterruptedException {
//		String browser="chrome";
//		
//		if (browser.equalsIgnoreCase("firefox")){
//				//passing location of Firefox driver
//				System.setProperty("webdriver.gecko.driver",
//				"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\geckodriver.exe");
//				//creating firefox webdriver d
//				//WebDriver driver = new FirefoxDriver();
//				
//		} else if (browser == "chrome") {
//				//passing location of Chrome driver
//				System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
//				//creating chrome webdriver d
//				//WebDriver driver = new ChromeDriver();			
//		}

		System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
	//loading billing test site and logging in
	driver.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website
	driver.manage().window().maximize(); // maximing it
	driver.findElement(By.name("username")).sendKeys("techfiosdemo@gmail.com");
	driver.findElement(By.name("password")).sendKeys("abc123");
	driver.findElement(By.name("login")).click();
	
	driver.findElement(By.xpath("//span[contains(text(), 'CRM')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(text(), 'Add Contact')]")).click();
	Thread.sleep(3000);
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("scroll(0,600)");
	
	Thread.sleep(3000);
	WebElement DROPDOWN_LOCATOR = driver.findElement(By.xpath("//div[@class='form-group']//descendant::select[@id='country']"));
	Select getCountry = new Select(DROPDOWN_LOCATOR);
	getCountry.selectByVisibleText("Algeria");
	driver.findElement(By.xpath("//button[@id='submit']")).click();


	

}
}