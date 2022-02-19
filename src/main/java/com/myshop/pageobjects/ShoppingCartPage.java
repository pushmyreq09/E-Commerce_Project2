package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class ShoppingCartPage extends BaseClass {

	WebDriver Ldriver;// our local driver

	public ShoppingCartPage(WebDriver rdriver)// this is our remote driver
	{
		Ldriver = rdriver;
		PageFactory.initElements(rdriver, this);// specifying page factory class
	}

	Myactions actions = new Myactions();

	@FindBy(xpath = "//h1[text()='Shopping Cart']")
	private WebElement Pagetitle;

	@FindBy(xpath = "//li/span")
	private WebElement CartMessage;

	@FindBy(xpath = "//td[@class='product-cart-price']/span/span")
	private WebElement UnitPrice;

	@FindBy(xpath = "//input[@title='Qty']")
	private WebElement Qty;

	@FindBy(xpath = "//strong/span[@class='price']")
	private WebElement GrandTotal;

	@FindBy(xpath = "//li[@class='method-checkout-cart-methods-onepage-bottom']/button")
	private WebElement CheckOutBtn;

	@FindBy(xpath = "//tbody/tr[1]/td[4]/button[1]")
	private WebElement updatebtn;

	@FindBy(xpath = "//li[@class='error-msg']")
	private WebElement Errormsg;

	@FindBy(id = "empty_cart_button")
	private WebElement EmptyCart;

	@FindBy(className = "page-title")
	private WebElement Cartmsg;

	public boolean CartTitle() {
		return actions.isDisplayed(driver, Pagetitle);
	}

	public boolean CartMsg() {
		return actions.isDisplayed(driver, CartMessage);
	}

	public double unitPrice() {
		String price = UnitPrice.getText();
		price = price.replaceAll("[^a-zA-Z0-9]", "");
		Double MyUnitprice = Double.parseDouble(price);
		return MyUnitprice;
	}

	public int Quantity() {
		String Quantity = Qty.getAttribute("value");
		Integer MyQty = Integer.parseInt(Quantity);
		return MyQty;

	}

	public double GrandTotal() {
		String total = GrandTotal.getText();
		total = total.replaceAll("[^a-zA-Z0-9]", "");
		Double MyFinalprice = Double.parseDouble(total);
		return MyFinalprice;
	}

	public boolean TotalPrice() {
		return actions.isDisplayed(driver, GrandTotal);
	}

	public CheckOutPage ValidateCheckoutBtn() {
		actions.click(driver, CheckOutBtn);
		return new CheckOutPage(driver);
	}

	public String pageTitle() {
		String Title = actions.getTitle(driver);
		return Title;
	}

	public void setInvalidQty() {
		Qty.clear();
		Qty.sendKeys("1000");
		updatebtn.click();

	}

	public String errorMsg() {
		return Errormsg.getText();
	}

	public String emptyCart() {
		EmptyCart.click();
		return Cartmsg.getText();
	}

}
