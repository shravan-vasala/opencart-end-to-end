package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Locators or element
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(linkText = "Register")
	WebElement linkRegister;
	
	@FindBy(linkText = "Login")
	WebElement linkLogin;
	
	@FindBy(name = "search")
	WebElement inputSearch;
	
	@FindBy(xpath = "//i[@class = 'fa fa-search']")
	WebElement buttonSearch;
	
	// Action methods
	
	public void clickMyAccount() {
		linkMyAccount.click();
	}
	
	public void clickRegister() {
		linkRegister.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
	public void setSearch(String search) {
		inputSearch.sendKeys(search);
	}
	
	public void clickSearch() {
		buttonSearch.click();
	}
	
	
}
