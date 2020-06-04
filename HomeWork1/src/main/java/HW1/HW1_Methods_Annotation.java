package HW1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Problem: Steps:
1. Go to http://newtours.demoaut.com/mercurywelcome.php
2. Verify title match: Welcome: Mercury Tours
2. Enter username: mercury
3. Enter password: mercury
4. Click sign-in (Hint: Incorporate implicit wait or Thread.sleep)
5. Verify SIGN-OFF button displayed
*/

public class HW1_Methods_Annotation {

	// creating class level object driver
	WebDriver driver;

	@Before
	public void launchWebsite() {
		// launching the website and maximizing it

		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");// calling chrome driver
		driver = new ChromeDriver(); // created Chrome driver object
		driver.get("http://newtours.demoaut.com/mercurywelcome.php"); // going to website
		driver.manage().window().maximize(); // maximizing the window
	}

	@Test
	public void title_login_DisplayBtn_Test() throws InterruptedException {
		// checking title, provide user name and password and click login, verify
		// sign-off button

		String K = "Welcome: Mercury Tours"; // variable to hold expected result
		System.out.println("Expected title is " + K);
		String J = driver.getTitle(); // variable to hold actual result
		System.out.println("Actual Title is " + J);

		// if-else loop to check title matched or not for my verification on console
		if (J.matches(K)) {
			System.out.println("Title MATCHED");
		} else {
			System.out.println("Title DIDNOT match");
		}
		Assert.assertEquals(K, J); // calling Assert function that compares expected and actual value

		// Inputing user name/password/clicking login button
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		

		// implicit wait-time 10 seconcd max wait but if previous action done then it will not wait till 10 sec.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// implicit wait-time 5 sec after clicking login button
		Thread.sleep(5000);

		// created boolean variable which checked sign-off button is displayed or not
		boolean yesDisplayed = driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();

		// checking for my own verification on the console
		if (yesDisplayed) {
			System.out.println("SIGN-OFF button is DISPLAYED");
		} else {
			System.out.println("SIGN-OFF button is NOT displayed");
		}

	}

	/*
	 * @Test public void loginAndDisplayBtn_Test_Ngtv_Test1() throws
	 * InterruptedException { //provide user name and password and click login
	 * 
	 * driver.findElement(By.name("userName")).sendKeys("mercuri");
	 * driver.findElement(By.name("password")).sendKeys("mercury");
	 * driver.findElement(By.name("login")).click(); Thread.sleep(5000);
	 * 
	 * //created boolean variable which checked sign-off button is displayed or not
	 * boolean yesDisplayed =
	 * driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();
	 * 
	 * //checking for my own verification on the console if(yesDisplayed) {
	 * System.out.println("SIGN-OFF button is DISPLAYED"); } else {
	 * System.out.println("SIGN-OFF button is NOT displayed"); }
	 * 
	 * }
	 * 
	 * @Test public void loginAndDisplayBtn_Ngtv_Test2() throws InterruptedException
	 * { //provide user name and password and click login
	 * 
	 * driver.findElement(By.name("userName")).sendKeys("mercury");
	 * driver.findElement(By.name("password")).sendKeys("mercuri");
	 * driver.findElement(By.name("login")).click(); Thread.sleep(5000);
	 * 
	 * //created boolean variable which checked sign-off button is displayed or not
	 * boolean yesDisplayed =
	 * driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();
	 * 
	 * //checking for my own verification on the console if(yesDisplayed) {
	 * System.out.println("SIGN-OFF button is DISPLAYED"); } else {
	 * System.out.println("SIGN-OFF button is NOT displayed"); }
	 * 
	 * }
	 * 
	 * @Test public void loginAndDisplayBtn_Ngtv_Test3() throws InterruptedException
	 * { //provide user name and password and click login
	 * 
	 * driver.findElement(By.name("userName")).sendKeys("mercuri");
	 * driver.findElement(By.name("password")).sendKeys("mercuri");
	 * driver.findElement(By.name("login")).click(); Thread.sleep(5000);
	 * 
	 * //created boolean variable which checked sign-off button is displayed or not
	 * boolean yesDisplayed =
	 * driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();
	 * 
	 * //checking for my own verification on the console if(yesDisplayed) {
	 * System.out.println("SIGN-OFF button is DISPLAYED"); } else {
	 * System.out.println("SIGN-OFF button is NOT displayed"); }
	 * 
	 * }
	 * 
	 * @Test public void loginAndDisplayBtn_Ngtv_Test4() throws InterruptedException
	 * { //provide user name and password and click login
	 * 
	 * driver.findElement(By.name("userName")).sendKeys("venus");
	 * driver.findElement(By.name("password")).sendKeys("venus");
	 * driver.findElement(By.name("login")).click(); Thread.sleep(5000);
	 * 
	 * //created boolean variable which checked sign-off button is displayed or not
	 * boolean yesDisplayed =
	 * driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();
	 * 
	 * //checking for my own verification on the console if(yesDisplayed) {
	 * System.out.println("SIGN-OFF button is DISPLAYED"); } else {
	 * System.out.println("SIGN-OFF button is NOT displayed"); } }
	 */

	@After
	public void tearDown() {
		// closing the website
		driver.close();
	}

}// end of class
