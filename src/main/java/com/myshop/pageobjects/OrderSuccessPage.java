package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class OrderSuccessPage extends BaseClass {
	
WebDriver Ldriver;//our local driver
	
	public OrderSuccessPage(WebDriver rdriver)//this is our remote driver
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//specifying page factory class
	}
        
        Myactions actions=new Myactions();
        
        @FindBy(xpath="//div[@class='page-title']/h1")
        WebElement OrderSuccessMessage;
        
        @FindBy(xpath="//div[@class='col-main']/p[1]")
        WebElement OrderId;
        
        @FindBy(xpath="//div[@class='buttons-set']/button")
        WebElement ContinueShopping;
        
        public boolean orderPlacedMsg()
        {
        	return actions.isDisplayed(driver,OrderSuccessMessage);
        }
        
        public boolean orderID() 
        {
        	return actions.isDisplayed(driver, OrderId);
        }
        
        public boolean ContinueShopping()
        {
        	return actions.isDisplayed(driver, ContinueShopping);
        }
        
        

}
