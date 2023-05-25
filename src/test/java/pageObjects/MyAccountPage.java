package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement headingMessage;
	
	@FindBy(xpath = "//div[@class = 'list-group']//a[text() = 'Logout']")
	WebElement linkLogout;
	
	public boolean isMyAccountPageExists() {
		try {
			return headingMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		linkLogout.click();
	}
}
