package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class ShoppingCartPage extends BaseClass {
	
WebDriver Ldriver;//our local driver
	
	public ShoppingCartPage(WebDriver rdriver)//this is our remote driver
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//specifying page factory class
	}
        
        Myactions actions=new Myactions();
           
        
        @FindBy(xpath="//h1[text()='Shopping Cart']")
        WebElement Pagetitle;
        
        @FindBy(xpath="//li/span")
        WebElement CartMessage;
        
        @FindBy(xpath="//td[@class='product-cart-price']/span/span")
        WebElement UnitPrice;
        
        @FindBy(xpath="//input[@title='Qty']")
        WebElement Qty;
        
        
        @FindBy(xpath="//strong/span[@class='price']")
        WebElement GrandTotal;
        
        @FindBy(xpath="//li[@class='method-checkout-cart-methods-onepage-bottom']/button")
        WebElement CheckOutBtn;
        
        public boolean CartTitle()
        {
        	return actions.isDisplayed(driver, Pagetitle);
        }
        
        public boolean CartMsg()
        {
        	return actions.isDisplayed(driver, CartMessage);
        }
        
        public double unitPrice()
        {
        	String price=UnitPrice.getText();
        	price=price.replaceAll("[^a-zA-Z0-9]", "");
        	Double MyUnitprice=Double.parseDouble(price);
        	return MyUnitprice;
        }
        public int Quantity()
        {
        	String Quantity=Qty.getAttribute("value");
        	Integer MyQty=Integer.parseInt(Quantity);
        	return MyQty;
        	
        }
        public double GrandTotal()
        {
        	String total=GrandTotal.getText();
        	total=total.replaceAll("[^a-zA-Z0-9]", "");
        	Double MyFinalprice=Double.parseDouble(total);
        	return MyFinalprice;
        }
        
        public boolean TotalPrice()
        {
        	return actions.isDisplayed(driver, GrandTotal);
        }
        
        public CheckOutPage ValidateCheckoutBtn()
        {
        	actions.click(driver, CheckOutBtn);
        	return new CheckOutPage(driver);
        }
        public String pageTitle()
        {
        	String Title=actions.getTitle(driver);
        	return Title;
        }
        
       

        

}
