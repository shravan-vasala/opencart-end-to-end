package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartPageTest extends BaseClass{
	@Test
	public void test_addToCart() {
		logger.info("Started TC_005_AddToCartPageTest");
		try {
			HomePage home = new HomePage(driver);
			home.setSearch("iPhone");
			home.clickSearch();
			
			SearchPage search = new SearchPage(driver);
			
			if (search.isProductExists("iPhone")) {
				search.selectProduct("iPhone");
				search.setQuantity("2");
				search.clickAddCart();
			}
			
			boolean status = search.checkConfirmMessage();
			Assert.assertTrue(status);
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("Failed TC_005_AddToCartPageTest");
	}
}
