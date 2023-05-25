package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	// Locator
	
	@FindBy(xpath = "//*[@id = 'content']//div[3]//img")
	List<WebElement> searchProducts;
	
	@FindBy(id = "input-quantity")
	WebElement inputQuantity;
	
	@FindBy(id = "button-cart")
	WebElement buttonAddCart;
	
	@FindBy(xpath = "//div[contains(text(), 'Success: You have added')]")
	WebElement confirmMessage;
	
	// Action method
	
	public boolean isProductExists(String productName) {
		boolean flag = false;
		for (WebElement product: searchProducts) {
			if (product.getAttribute("title").equals(productName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public void selectProduct(String productName) {
		for (WebElement product: searchProducts) {
			if (product.getAttribute("title").equals(productName)) {
				product.click();
			}
		}
	}
	
	public void setQuantity(String quantity) {
		inputQuantity.clear();
		inputQuantity.sendKeys(quantity);
	}
	
	public void clickAddCart() {
		buttonAddCart.click();
	}
	
	public boolean checkConfirmMessage() {
		try {
			return confirmMessage.isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	
	
}
