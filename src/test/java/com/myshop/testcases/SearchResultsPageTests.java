package com.myshop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;
import com.myshop.pageobjects.HomePage;
import com.myshop.pageobjects.ProductDisplayPage;
import com.myshop.pageobjects.SearchResultsPage;

public class SearchResultsPageTests extends BaseClass {
	
	
	SearchResultsPage Result;
	ProductDisplayPage MyProduct;
	HomePage Hp;
	
	@Test(groups="Smoke")
	public void VerifyResultsPageTitle() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		String ActualTitle=Result.getTitle();
		String ExpectedTitle="Search results for: 'Samsung Galaxy'";
		Assert.assertEquals(ActualTitle,ExpectedTitle);
	}
	
	
	@Test(groups="Smoke")
	public void searchResults() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		boolean productresult=Result.isProductAvailable();
		Assert.assertTrue(productresult);
		
	}
	
	@Test()
	public void verifyProductPageTitle() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		String ActualTitle=MyProduct.ValidateTitle();
		String ExpectedTitle="Samsung Galaxy";
		Assert.assertEquals(ActualTitle,ExpectedTitle);
		
	}
	
}
