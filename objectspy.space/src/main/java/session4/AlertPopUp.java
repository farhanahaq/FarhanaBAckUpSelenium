package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUp {

	public static void main(String[] args) throws InterruptedException {

			// passing location of Chrome driver
			System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
			//creating chrome webdriver d
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); // getting a website
			driver.manage().window().maximize(); // maximing it
			Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			String popmsg = driver.switchTo().alert().getText();
			System.out.println("pop-up msg was " + popmsg);
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			
			Thread.sleep(3000);
			driver.close();
			driver.quit();

	}

}
