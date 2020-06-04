package page;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankNCash {

	WebDriver driver;

	// declaring constructor to receive driver from whoever is calling this class or
	// constructor
	// and passing the value to local driver
	public BankNCash(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Bank & Cash')]")
	WebElement BANK_CASH_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'New Account')]")
	WebElement ADD_NEW_ACCOUNT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement ACCOUNT_TITLE_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement DESCRIPTION_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement BALANCE_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement SUBMIT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement AC_ADD_SUCCESS_MSG_LOCATOR;

	// go to BANK and CASH and ADD New AC Button
	public void newAccountButtons() {
		waitForElement(driver, 2, BANK_CASH_BUTTON_LOCATOR);
		BANK_CASH_BUTTON_LOCATOR.click();
		waitForElement(driver, 2, ADD_NEW_ACCOUNT_BUTTON_LOCATOR);
		ADD_NEW_ACCOUNT_BUTTON_LOCATOR.click();
		System.out.println("Add New AC Button is Visible");
	}

	public void enterACName(String ACName) {
		ACCOUNT_TITLE_LOCATOR.sendKeys(ACName);
	}

	public void enterDescription(String Desc) {
		DESCRIPTION_LOCATOR.sendKeys(Desc);
	}

	public void enterBalance(String Balance) {
		BALANCE_LOCATOR.sendKeys(Balance);
	}

	public void clickSubmit() {
		SUBMIT_BUTTON_LOCATOR.click();
	}

	// Validate AC ADD Success Message
	public void isAccountCreated() throws InterruptedException {
		try {
			waitForElement(driver, 4, AC_ADD_SUCCESS_MSG_LOCATOR);
			System.out.println("ACCOUNT was created!");

		} catch (ElementNotVisibleException e) {
			System.out.println("Account was NOT created!");
			e.printStackTrace();
		}
	}

	public void waitForElement(WebDriver driver2, int timeInSeconds, WebElement dASHBOARD_PAGE_TITLE_LOCATOR2) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(dASHBOARD_PAGE_TITLE_LOCATOR2));

	}

}
