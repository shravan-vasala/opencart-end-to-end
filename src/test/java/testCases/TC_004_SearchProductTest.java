package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {
	
	@Test
	public void testProductSearch() throws InterruptedException {
		logger.info("Started TC_004_SearchProductTest");
			
			try {
				HomePage home = new HomePage(driver);
				home.setSearch("mac");
				home.clickSearch();
				
				SearchPage search = new SearchPage(driver);
				boolean macStatus = search.isProductExists("MacBook");
				
				Assert.assertTrue(macStatus);
				
			} catch (Exception e) {
				Assert.fail();
			}
			
	}
}
