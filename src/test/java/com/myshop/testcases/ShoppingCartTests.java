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

	@Test(groups = "Smoke")
	public void cartPageTitle() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		MyProduct = Result.clickOnProduct();
		Cart = MyProduct.addtocartbtn();
		String ActualTitle = Cart.pageTitle();
		String ExpectedTitle = "Shopping Cart";
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test(groups = { "Sanity", "Smoke" })
	public void addedToCartMsg() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		MyProduct = Result.clickOnProduct();
		Cart = MyProduct.addtocartbtn();
		boolean result = Cart.CartMsg();
		Assert.assertTrue(result);
	}

	@Test(groups = "Regression")
	public void priceCheck() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		MyProduct = Result.clickOnProduct();
		Cart = MyProduct.addtocartbtn();
		Double unitprice = Cart.unitPrice();
		Integer quantity = Cart.Quantity();
		Double finalPrice = Cart.GrandTotal();
		Assert.assertTrue((unitprice * quantity == finalPrice));
	}

	@Test(groups = { "Sanity", "Regression" })
	public void proceedToCheckOutbtn() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		MyProduct = Result.clickOnProduct();
		Cart = MyProduct.addtocartbtn();
		Checkout = Cart.ValidateCheckoutBtn();
		String ActualTitle = Checkout.verifyTitle();
		String ExpectedTitle = "Checkout";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@Test(groups = "Sanity")
	public void invalidQtyErrMsg() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		Cart = Result.addtoCart();
		log.info("setting invalid qty and updating the qty");
		Cart.setInvalidQty();
		String Actualmsg = Cart.errorMsg();
		log.info("My actual msg");
		System.out.println(Actualmsg);
		String Expectedmsg = "Some of the products cannot be ordered in requested quantity.";
		System.out.println(Expectedmsg);
		log.info("Verifying the messages");
		Assert.assertEquals(Actualmsg, Expectedmsg);
		log.info("Invalid qty msg test passed");
	}

	@Test(groups = "Sanity")
	public void emptyCartMsg() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		Cart = Result.addtoCart();
		log.info("setting invalid qty and updating the qty");
		Cart.setInvalidQty();
		log.info("clicking on the empty cart button");
		String Actualmsg = Cart.emptyCart();
		log.info("actual msg is");
		System.out.println(Actualmsg);
		String Expectedmsg = "SHOPPING CART IS EMPTY";
		log.info("Expected msg is");
		System.out.println(Expectedmsg);
		log.info("verifying the message");
		Assert.assertEquals(Actualmsg, Expectedmsg);
		log.info("empty cart msg test passed");

	}

}
