package com.myshop.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.base.BaseClass;
import com.myshop.dataprovider.DataProviderClass;
import com.myshop.pageobjects.HomePage;
import com.myshop.pageobjects.LogInPage;
import com.myshop.pageobjects.MyAccountsPage;
import com.myshop.pageobjects.SignInPage;

public class SignInTests extends BaseClass {

	SignInPage SignIn;
	LogInPage Register;
	HomePage Hp;
	MyAccountsPage MyAccount;

	@Test(groups = "Smoke")
	public void verifyPageTitle() throws Throwable {
		log.info("opened the url");
		Hp = new HomePage(driver);
		Register = Hp.clickOnAccounts();
		log.info("clicked on myaccounts");
		SignIn = Register.createNewAccount();
		log.info("clicked on createnew account");
		String ActualTitle = SignIn.VerifyPagetitle();
		String ExpectedTitle = "Create New Customer Account";
		log.info("validating the signIn page Title");
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		log.info("page Title verified");
	}

	// using data provider for signIn
	@Test(groups = "Regression", dataProvider = "newAcountDetailsData", dataProviderClass = DataProviderClass.class)
	public void SignIn(HashMap<String, String> hashMapValue) throws Throwable {
		log.info("opened the url");
		Hp = new HomePage(driver);
		Register = Hp.clickOnAccounts();
		log.info("clicked on myaccounts");
		SignIn = Register.createNewAccount();
		log.info("clicked on createnew account");
		log.info("entering details to register");
		SignIn.AccountCreation(hashMapValue.get("FirstName"), hashMapValue.get("LastName"), hashMapValue.get("Email"),
				hashMapValue.get("SetPassword"), hashMapValue.get("ConfirmPassword"));
		log.info("details entered and clicked on register");
		MyAccount = SignIn.ValidateRegistration();
		log.info("validating myaccounts page title");
		String Actualurl = MyAccount.getCurrURL();
		String Expectedurl = "http://live.techpanda.org/index.php/customer/account/index/";
		Assert.assertEquals(Actualurl, Expectedurl);
		log.info("SignIn testcase passed");

	}

}
