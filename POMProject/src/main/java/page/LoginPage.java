package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	//declaring constructor to receive driver from whoever is calling this class or constructor
	//and passing the value to local driver
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	// Element Library

	@FindBy(how = How.ID, using = "username")
	WebElement USERNAME_FIELD_LOCATOR;
	@FindBy(how = How.ID, using = "password")
	WebElement PASSWORD_FIELD_LOCATOR;
	@FindBy(how = How.NAME, using = "login")
	WebElement SIGNIN_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Dashboard')]")
	WebElement DASHBOARD_PAGE_TITLE_LOCATOR;

	// method to send username value to username locator on the techfiod login page
	public void enterUserName(String userName) {
		USERNAME_FIELD_LOCATOR.sendKeys(userName);
	}

	// method to send password value to password locator on the techfiod login page
	public void enterPassword(String password) {
		PASSWORD_FIELD_LOCATOR.sendKeys(password);
	}

	// method to click submit button locator on the techfiod login page
	public void clickSubmitButton() {
		SIGNIN_BUTTON_LOCATOR.click();
	}

}
