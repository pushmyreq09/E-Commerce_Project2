package com.myshop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.base.BaseClass;
import com.myshop.pageobjects.HomePage;
import com.myshop.pageobjects.ProductDisplayPage;
import com.myshop.pageobjects.SearchResultsPage;
import com.myshop.pageobjects.ShoppingCartPage;

public class ProductDisplayPageTests extends BaseClass {

	SearchResultsPage Result;
	ProductDisplayPage MyProduct;
	HomePage Hp;
	ShoppingCartPage Cart;
	
	@Test(groups="Smoke")
	public void productPageTitle() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		String ActualTitle=MyProduct.ValidateTitle();
		String ExpectedTitle="Samsung Galaxy";
		Assert.assertEquals(ActualTitle,ExpectedTitle);

	}
	
	@Test()
	public void productImageDisplay() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();		
		boolean result=MyProduct.ProductImage();
		Assert.assertTrue(result);
	}
	
	@Test()
	public void productNameDisplay() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		boolean result=MyProduct.ProductName();
		Assert.assertTrue(result);
	}
	@Test()
	public void productPriceDisplay() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		boolean result=MyProduct.Price();
		if(result==true)
		 {
			  Assert.assertTrue(true);
			  log.info("test passed");
			  
		  }
		  else
			  {
			  captureScreen( driver,"productPriceDisplay");
			  Assert.assertTrue(false);
		      log.info("test failed");
			  }	
		
		
	}
	@Test
	public void setQuantity()
	{
		MyProduct.enterQuantity("2");
		
		
	}
	@Test(groups= {"Sanity","Regression"})
	public void clickAddToCart() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		Cart=MyProduct.addtocartbtn();
		String ActualTitle=Cart.pageTitle();
		String ExpectedTitle="Shopping Cart";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		
	}
	
}
