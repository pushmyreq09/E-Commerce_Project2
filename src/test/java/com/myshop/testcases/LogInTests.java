
package com.myshop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.base.BaseClass;
import com.myshop.dataprovider.DataProviderClass;
import com.myshop.pageobjects.HomePage;
import com.myshop.pageobjects.LogInPage;
import com.myshop.pageobjects.MyAccountsPage;

public class LogInTests extends BaseClass {

	LogInPage LogIn;
	HomePage Hp;
	MyAccountsPage MyAccount;

	@Test(groups = { "Smoke", "Sanity" })
	public void logInTest() throws Throwable {
		log.info("opened the url");
		Hp = new HomePage(driver);
		Hp.clickOnAccounts();
		log.info("clicked on myaccounts");
		LogIn = new LogInPage(driver);
		MyAccount = LogIn.login(username, password);
		log.info("entered username and password");
		String ActualUrl = MyAccount.getCurrURL();
		String ExpectedUrl = "http://live.techpanda.org/index.php/customer/account/index/";
		log.info("validating the accounts page title");
		Assert.assertEquals(ActualUrl, ExpectedUrl);
		log.info("LogIn test passed");

	}

	// this one is using data provider with 1 valid and 2 invalid inputs
	@Test(groups = { "Smoke", "Sanity" }, dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void logInTest1(String uname, String pswd) throws Throwable {
		log.info("opened the url");
		Hp = new HomePage(driver);
		Hp.clickOnAccounts();
		log.info("clicked on myaccounts");
		LogIn = new LogInPage(driver);
		MyAccount = LogIn.login(uname, pswd);
		log.info("entered username and password");
		String ActualUrl = MyAccount.getCurrURL();
		String ExpectedUrl = "http://live.techpanda.org/index.php/customer/account/index/";
		log.info("validating the accounts page title");
		if (ActualUrl == ExpectedUrl) {
			Assert.assertTrue(true);
			log.info("LogInTest passed");

		} else {
			log.info("LogIn test failed");
			captureScreen(driver, "logInTest1");
			Assert.assertTrue(false);

		}

	}

}
