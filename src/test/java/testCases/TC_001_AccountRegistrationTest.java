package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test
	public void test_account_Registration() {
		try {
			HomePage home = new HomePage(driver);
			home.clickMyAccount();
			home.clickRegister();
			
			AccountRegistrationPage registration = new AccountRegistrationPage(driver);
			String name = randomString().toUpperCase();
			registration.setFirstName(name);
			registration.setLastName(name);
			registration.setEmail(name + "@gmail.com");
			registration.setTelephone(randomNumber());
			String pass = randomAlphaNumeric();
			registration.setPassword(pass);
			registration.setConfirmPassword(pass);
			registration.clickPrivacy();
			registration.clickContinue();
			
			String message = registration.getConfirmationMessage();
			Assert.assertEquals(message, "Your Account Has Been Created!");
			
		} catch(Exception e) {
			Assert.fail();
		}
	}
}
