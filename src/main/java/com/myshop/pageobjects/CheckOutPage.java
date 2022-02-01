package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class CheckOutPage extends BaseClass {
	
WebDriver Ldriver;//our local driver
	
	public CheckOutPage(WebDriver rdriver)//this is our remote driver
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//specifying page factory class
	}
        
        Myactions actions=new Myactions();
        
        @FindBy(id="billing:firstname")
        WebElement Firstname;
        
        @FindBy(id="billing:lastname")
        WebElement Lastname;
        
        @FindBy(id="billing:street1")
        WebElement Address;
        
        @FindBy(id="billing:city")
        WebElement City;
        
        @FindBy(id="billing:region_id")
        WebElement State;
        
        @FindBy(id="billing:postcode")
        WebElement Zip;
        
        @FindBy(id="billing:country_id")
        WebElement Country;
        
        @FindBy(id="billing:telephone")
        WebElement Telephone;
        
        @FindBy(id="billing:use_for_shipping_yes")
        WebElement ShipToThisAdd;
        
        @FindBy(xpath="//button[@onclick='billing.save()']")
        WebElement Continue;
        
        @FindBy(xpath="//button[@onclick='shippingMethod.save()']")
        WebElement Methodcontinue;
        
        @FindBy(id="p_method_ccsave")
        WebElement CreditCard;
        
        @FindBy(id="p_method_checkmo")
        WebElement MoneyOrder;
        
        @FindBy(xpath="//button[@onclick='payment.save()']")
        WebElement SavePaymentMethod;
        
        @FindBy(xpath="//button[@title='Place Order']")
        WebElement PlaceOrder;
        
        
        public String verifyTitle()
        {
        	return actions.getTitle(driver);
        }
        
        public void billingInfo(String fname,String lname,
	    		String address,String city,String state,String zip,
	    		String country,String telephone)
	    
	    {
	    	actions.type(Firstname, fname);
	    	actions.type(Lastname, lname);
	    	actions.type(Address, address);
	    	actions.type(City, city);
	    	actions.selectByVisibleText(state,State);
	    	actions.type(Zip, zip);
	    	actions.selectByVisibleText(country,Country);  	
	    	actions.type(Telephone,telephone);	    	
	    	
	    }
        
        public boolean shipto()
        {
        	return actions.isSelected(driver,ShipToThisAdd);
        }
        
        public void ClickOnContinue()
        {
        	actions.click(driver, Continue);
        }
        
        public void Continuemethod()
        {
        	actions.click(driver,Methodcontinue);
        }
        
        public void PayMethod()
        {
            actions.click(driver, CreditCard);
        	actions.click(driver, MoneyOrder);
        	
        	 
        }
        
        public void paymentSave()
        {
        	actions.click(driver, SavePaymentMethod);
        }
        
        public void placeOrder()
        {
        	actions.click(driver, PlaceOrder);
        }
        
        
        
        
        
        
        
        
        
        
        

}
