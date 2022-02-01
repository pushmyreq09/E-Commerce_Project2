package com.myshop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.base.BaseClass;
import com.myshop.pageobjects.HomePage;
import com.myshop.pageobjects.LogInPage;
import com.myshop.pageobjects.MyAccountsPage;

public class AccountsPageTests extends BaseClass {
	LogInPage LogIn;
	HomePage Hp;
	MyAccountsPage MyAccount;
	
	
	@Test(groups="Smoke")
	public void wishListOptiondisplayTest() throws Throwable
	{
		Hp=new HomePage(driver);
		Hp.clickOnAccounts();
		LogIn=new LogInPage(driver);
		MyAccount=LogIn.login(username, password);
		boolean result=MyAccount.validateMyWishList();
		Assert.assertTrue(result);
	}
	@Test(groups="Smoke")
	public void myOrdersOptionDisplayTest() throws Throwable
	{
		Hp=new HomePage(driver);
		Hp.clickOnAccounts();
		LogIn=new LogInPage(driver);
		MyAccount=LogIn.login(username, password);
		boolean result=MyAccount.validateOrderHistory();
		Assert.assertTrue(result);
	}
	

}
