package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pass, String exp) {
		
		logger.info("Started TC_003_LoginDataDrivenTest");
		try {
			HomePage home = new HomePage(driver);
			home.clickMyAccount();
			home.clickLogin();
			
			LoginPage login = new LoginPage(driver);
			login.setEmail(email);
			login.setPassword(pass);
			login.clickLogin();
			MyAccountPage account = new MyAccountPage(driver);
			boolean status = account.isMyAccountPageExists();
			if (exp.equals("Valid")) {
				if (status) {
					account.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.fail();
				}
			}
			
			if (exp.equals("Invalid")) {
				if (status) {
					account.clickLogout();
					Assert.fail();
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			
		}
	}
}
