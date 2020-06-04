package session4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws Exception {

		String browser = "chrome";

		WebDriver driver;
		if (browser.equalsIgnoreCase("firefox")) {
			// passing location of Firefox driver
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\geckodriver.exe");


		} else if (browser.equalsIgnoreCase("chrome")) {
			// passing location of Chrome driver
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");

		}
		

		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximing it
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.dell.com/en-us"); // getting a website
		
		WebElement PRODUCT_MENU_LOCATOR = driver.findElement(By.xpath("//button[@id='l1']"));
		WebElement NETWORKING_MENU_LOCATOR = driver.findElement(By.xpath("//a[@id='l1_5']"));
		//creating action object for Action class
		Actions action = new Actions(driver);
		action.moveToElement(PRODUCT_MENU_LOCATOR).build().perform();
		Thread.sleep(1000);
		action.moveToElement(NETWORKING_MENU_LOCATOR).build().perform();
		
		Thread.sleep(1000);
		driver.close();
		driver.quit();
		

	}

}
