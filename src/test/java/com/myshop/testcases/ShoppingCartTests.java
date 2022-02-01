package com.myshop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.base.BaseClass;
import com.myshop.pageobjects.CheckOutPage;
import com.myshop.pageobjects.HomePage;
import com.myshop.pageobjects.ProductDisplayPage;
import com.myshop.pageobjects.SearchResultsPage;
import com.myshop.pageobjects.ShoppingCartPage;

public class ShoppingCartTests extends BaseClass {
	
	SearchResultsPage Result;
	ProductDisplayPage MyProduct;
	HomePage Hp;
	ShoppingCartPage Cart;
	CheckOutPage Checkout;
	
	@Test
	public void cartPageTitle() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		Cart=MyProduct.addtocartbtn();
		String ActualTitle=Cart.pageTitle();
		String ExpectedTitle="Shopping Cart";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
			
	}
	
	@Test
	public void addedToCartMsg() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		Cart=MyProduct.addtocartbtn();
		boolean result=Cart.CartMsg();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Regression")
	public void priceCheck() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		Cart=MyProduct.addtocartbtn();
		Double unitprice=Cart.unitPrice();
		Integer quantity=Cart.Quantity();
		Double finalPrice=Cart.GrandTotal();
		Assert.assertTrue((unitprice*quantity==finalPrice));
	}
	@Test(groups= {"Sanity","Regression"})
	public void proceedToCheckOutbtn() throws Throwable
	{
		Hp=new HomePage(driver);
		Result=Hp.searchProduct("Samsung Galaxy");
		MyProduct=Result.clickOnProduct();
		Cart=MyProduct.addtocartbtn();
		Checkout=Cart.ValidateCheckoutBtn();
		String ActualTitle=Checkout.verifyTitle();
		String ExpectedTitle="Checkout";
		Assert.assertEquals(ActualTitle,ExpectedTitle);
	}
	
	

}
