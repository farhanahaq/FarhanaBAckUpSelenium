package session4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

	public static void main(String[] args) throws InterruptedException {
		// passing location of Chrome driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
		// creating chrome webdriver d
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximing it
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//getting to oracle site which has 3 frames
		driver.get("https://docs.oracle.com/javase/8/docs/api/"); // getting a website
		Thread.sleep(2000);

		//getting to top lefthandside frame by its name and clicking on one link
		driver.switchTo().frame("packageListFrame");
		Thread.sleep(2000);
		driver.findElement(By.linkText("java.applet")).click();
		Thread.sleep(2000);

		//switching to bottom lefthandside frame and clicking on one link
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("packageFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains (text(), 'AppletContext')]//self::span")).click();
		Thread.sleep(2000);
		
		//now refreshing window and going to righthandside page and clicking on two link
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.switchTo().frame("classFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'compact1')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(("//div[@class='topNav']/following-sibling::div[1]/ul[2]/li[2]"))).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
