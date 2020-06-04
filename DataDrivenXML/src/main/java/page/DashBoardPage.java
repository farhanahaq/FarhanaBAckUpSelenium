package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashBoardPage {

	WebDriver driver;
	
	//declaring constructor to receive driver from whoever is calling this class or constructor
	//and passing the value to local driver
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	// Element Library;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Dashboard')]")
	WebElement DASHBOARD_PAGE_TITLE_LOCATOR;
	

	//Method to validate Dashboard is visible
	public void chkDashBoardTabVisible() {
		waitForElement(driver, 2, DASHBOARD_PAGE_TITLE_LOCATOR);
		Assert.assertEquals(DASHBOARD_PAGE_TITLE_LOCATOR.getText(), "Dashboard", "Title didnot match");
		DASHBOARD_PAGE_TITLE_LOCATOR.click();
		
		//System.out.println("DashBoardButton is VISIBLE");
	}

	private void waitForElement(WebDriver driver2, int timeInSeconds, WebElement dASHBOARD_PAGE_TITLE_LOCATOR2) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(dASHBOARD_PAGE_TITLE_LOCATOR2));
		
	}
	
	
}
