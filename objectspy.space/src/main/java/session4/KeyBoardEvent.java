package session4;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvent {

	public static void main(String[] args) {

		String browser = "chrome";

		WebDriver driver;
		if (browser.equalsIgnoreCase("firefox")) {
			// passing location of Firefox driver
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\geckodriver.exe");
			// creating firefox webdriver d
//				driver = new FirefoxDriver();
//				driver.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website

		} else if (browser.equalsIgnoreCase("chrome")) {
			// passing location of Chrome driver
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\14693\\eclipse-workspace-Selenium\\objectspy.space\\Drivers\\chromedriver.exe");
			// creating chrome webdriver d
//				driver = new ChromeDriver();
//				driver.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website
		}

		driver = new ChromeDriver();
		// loading billing test site and logging in
		driver.get("http://techfios.com/test/billing/?ng=admin/"); // getting a website
		driver.manage().window().maximize(); // maximing it
		
		WebElement USER_NAME = driver.findElement(By.name("username"));
		USER_NAME.clear();
		USER_NAME.sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		//keyboard event action by class Actions
		Actions action = new Actions(driver);
		action.sendKeys(Keys.RETURN).build().perform();
		//driver.findElement(By.name("login")).click();

	}

}
