package session4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollUpDown {

	public static void main(String[] args) throws InterruptedException {
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
		
		//declaring JavascriptExecutor object of type JavascriptExecuter driver
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//accessing properties of JavascriptExecutor to perform scroll function
		js.executeScript("scroll(0,1200)");
				
		Thread.sleep(1000);
		js.executeScript("scroll(0,0)");
		
		Thread.sleep(1000);
		js.executeScript("scroll(0,600)");
		
		driver.close();
		driver.quit();
		

	}

}
