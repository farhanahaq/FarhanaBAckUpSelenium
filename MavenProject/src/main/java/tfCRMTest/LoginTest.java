package tfCRMTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;


public class LoginTest {
	//creating a global driver object
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException  {
		
		/*
		//setting the properties to a chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14693\\eclipse-workspace-Selenium\\MavenProject\\Drivers\\chromedriver.exe");
		
		//Creating object of web driver
		WebDriver driver = new ChromeDriver();
		
		//go to this website http://techfios.com/test/billing/?ng=admin/ ==> using river.get(String url);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		//Providing user name in the text box 
		//Identify the text box and send/passing the user name
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		
		//passing password
		driver.findElement(By.id("password")).sendKeys("abc123");
		
		//click on login button
		driver.findElement(By.name("login")).click();
		
		//Maximizing the windows
		driver.manage().window().maximize();
		
		//stop the driver for 2 sec and need to add throws exception for it 
		//Thread.sleep(2000); 
		
		//closing the browser
		driver.close();
		*/
		
		//calling in sequences 
		launchBrowser();
		loginTest();
		Thread.sleep(2000);
		tearDown();
		
		

	}//end of main
	
	public static void launchBrowser() {
				
				//setting the properties to a chrome driver
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\14693\\eclipse-workspace-Selenium\\MavenProject\\Drivers\\chromedriver.exe");
				
				driver = new ChromeDriver();
				
				//go to this website http://techfios.com/test/billing/?ng=admin/ ==> using river.get(String url);
				driver.get("http://techfios.com/test/billing/?ng=admin/");
				
				//Maximizing the windows
				driver.manage().window().maximize();
				
				String j= driver.getTitle();
				String k = "Login - TechFios Test Application - Billing";
				System.out.println("Got page title as " + j);
				Assert.assertEquals(k, j);
				
				

			}

	
	public static void loginTest()  {
		
			// Providing user name in the text box
			// Identify the text box and send/passing the user name
			driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");

			// passing password
			driver.findElement(By.id("password")).sendKeys("abc123");

			// click on login button
			driver.findElement(By.name("login")).click();
			
			}
	
	public static void tearDown() {
		
		//closing the browser
		driver.close();
		
}

	
}//end of class
