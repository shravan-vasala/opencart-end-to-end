package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	// Locator
	
	@FindBy(xpath = "//div[@id='cart']")
	WebElement buttonItems;
	
	@FindBy(xpath = "//strong[normalize-space()='View Cart']")
	WebElement linkViewCart;
	
	@FindBy(xpath = "//ul[@class = 'dropdown-menu pull-right']//table//tr[4]//td[2]")
	WebElement tableTotalAmount;
	
	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	WebElement buttonCheckout;
	
	public void clickItemsToNavigateToCart() {
		buttonItems.click();
	}
	
	public void clickCartView() {
		linkViewCart.click();
	}
	
	public String getTotalPrice() {
		return tableTotalAmount.getText();
	}
	
	public void clickOnCheckout() {
		buttonCheckout.click();
	}
}
