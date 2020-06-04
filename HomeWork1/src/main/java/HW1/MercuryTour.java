package HW1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTour {
/* Basic Main method doing all the jobs 
 * Steps:
1. Go to http://newtours.demoaut.com/mercurywelcome.php
2. Verify title match: Welcome: Mercury Tours
2. Enter username: mercury
3. Enter password: mercury
4. Click sign-in (Hint: Incorporate implicit wait or Thread.sleep)
5. Verify SIGN-OFF button displayed
*/

	public static void main(String[] args) {
		
		//Opening web page and maximize
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");//calling chrome driver
		WebDriver driver = new ChromeDriver(); //created driver object
		driver.get("http://newtours.demoaut.com/mercurywelcome.php"); //going to website
		driver.manage().window().maximize(); //maximizing the window
		
		//Verifying the title
		String K = "Welcome: Mercury Tours"; //variable to hold expected result
		System.out.println("Expected title is " + K);
		String J = driver.getTitle(); //variable to hold actual result
		System.out.println("Actual Title is "+ J);
		
		//if-else loop to check title matched or not for my verification on console 
		if (J.matches(K)){
			System.out.println("Title MATCHED");
		}
		else {
			System.out.println("Title DIDNOT match");
		}
		Assert.assertEquals(K, J); //calling Assert function that compared expected and actual value
		
		
		//provide user name and password and click login
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		
		
		//Checking Sign-Off button displayed or not	
		//created boolean variable which checked sign-off button is displayed or not
		boolean isDisplayed = driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();
		
		//checking for my own verification on the console
		if(isDisplayed) {
			System.out.println("SIGN-OFF button is DISPLAYED");
		}
		else {
			System.out.println("SIGN-OFF button is NOT displayed");
		}
		
		
		//closing website
		driver.close();
		
			
	}//end of main
	
	
		
}//end of class
