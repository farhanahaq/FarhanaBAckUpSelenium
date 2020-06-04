package testLocators;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VariousLocators {
	/*WebDriver driver;

	@Before // you cant call for annotation inside a class but has to be inside a method
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.objectspy.space/");
		driver.manage().window().maximize();

	}

	@Test
	
	
	public void test() throws InterruptedException {

		// link text and partial link text
		// driver.findElement(By.id("sex-0")).click();
		// driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		// driver.findElement(By.partialLinkText("OS-API Product")).click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// css
		// driver.findElement(By.cssSelector("input#profession-0")).click();
		// driver.findElement(By.cssSelector("input#photo")).click();

		// ERROR for cssSelector with class attributes
		// driver.findElement(By.cssSelector("input.input-file")).click();
		// driver.findElement(By.cssSelector("input#photo")).click(); //by ID attribute
		// driver.findElement(By.name("photo")).click();//by Name attributes
		WebElement buttonElement = driver.findElement(By.xpath("//input[@class='input-file']"));// by Name attributes
		buttonElement.click();

		// ERROR with relative x path with class attributes
		// driver.findElement(By.xpath("//input[@class='input-file']")).click();

		// ERROR with 2 attributes xpath
		// driver.findElement(By.xpath("//input[@class='input-file'and
		// @name='photo']")).click()

		// xpath
		// absolute xpath for Home tab
		// driver.findElement(By.xpath("html/body/div/div/div[2]/ul/li/a[text()='Home']")).click();

		// Relative xpath
		// driver.findElement(By.xpath("//input[@id='sex-0']")).click();

		// xpath with attribute node + contains text when no unique )]")).click();
		// driver.findElement(By.xpath("//a[contains (text(), 'Home')]")).click();

		// working buttons

		
		
		  driver.findElement(By.xpath("//button[contains(text(), 'Open Window')]")).
		  click(); Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[contains(text(), 'Open Tab')]")).click();
		 
		 

		Thread.sleep(5000);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	*/
}
