package tfCRMTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//example of @Test which is a JUnit function
public class LoginTestJUnit {

	WebDriver driver;
	
	//@Test
	/*public void launchBrowser() {
		
		//setting the properties to a chrome driver
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		//go to this website http://techfios.com/test/billing/?ng=admin/ ==> using river.get(String url);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		//Maximizing the windows
		driver.manage().window().maximize();

		// Providing user name in the text box
		// Identify the text box and send/passing the user name
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");

		// passing password
		driver.findElement(By.id("password")).sendKeys("abc123");

		// click on login button
		driver.findElement(By.name("login")).click();

		//closing the browser
		driver.close();
		*/
	
		@Before
		public  void launchBrowser() {
		
		//setting the properties to a chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14693\\eclipse-workspace-Selenium\\MavenProject\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		//go to this website http://techfios.com/test/billing/?ng=admin/ ==> using river.get(String url);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		//Maximizing the windows
		driver.manage().window().maximize();

		}

		@Test
		public  void loginTest() {

		// Providing user name in the text box
		// Identify the text box and send/passing the user name
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");

		// passing password
		driver.findElement(By.id("password")).sendKeys("abc123");

		// click on login button
		driver.findElement(By.name("login")).click();

		}
		
		@Test
		public  void loginNegetaiveTest() {

		// Providing user name in the text box
		// Identify the text box and send/passing the user name
		//driver.findElement(By.id("userna")).sendKeys("techfiosdemo@gmail.com");//Wrong element name in code
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");//Wrong element name in code

		// passing password
		driver.findElement(By.id("password")).sendKeys("abc");//wrong password
		//driver.findElement(By.id("password")).sendKeys("abc123");
		// click on login button
		driver.findElement(By.name("login")).click();
		
		}
		@After
		public void tearDown() {

		//closing the browser
		driver.close();


}


}


