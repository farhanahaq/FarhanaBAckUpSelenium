package session5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximing it
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website	
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		//System.out.println(driver.getWindowHandle());
		
		//searching for xpath and clicking on one link from the search result
		driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys("xpath");
		driver.findElement(By.xpath("//button[@id='header-desktop-search-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
		Thread.sleep(2000);
		
		//for each item of windowHandlers, print windHandler and switch to that window
		for(String i : driver.getWindowHandles()) {
			System.out.println(i);
			driver.switchTo().window(i);
			
			}
		System.out.println(driver.getTitle());//printing the last window
		
	
		
		
		
		
		
		
		
	}

}
