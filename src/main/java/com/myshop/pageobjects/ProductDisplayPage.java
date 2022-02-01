package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class ProductDisplayPage extends BaseClass 
{
WebDriver Ldriver;//our local driver
	
	public ProductDisplayPage(WebDriver rdriver)//this is our remote driver
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//specifying page factory class
	}
        
        Myactions actions=new Myactions();
        
        @FindBy(xpath="//div[@class='zoomContainer']")
        WebElement ProductDisplay;
        
        @FindBy(id="product-price-3")
        WebElement PriceDisplay;
        
        @FindBy(xpath="//div[@class='qty-wrapper']/input")
        WebElement EnterQuantity;
        
        @FindBy(xpath="//button[@title='Add to Cart']")
        WebElement AddToCartbtn;
        
        @FindBy(xpath="//div[@class='product-name']/span")
        WebElement ProductName;
        
        public boolean ProductImage()
        {
          return actions.isDisplayed(driver, ProductDisplay);
        }
        
        public boolean ProductName()
        {
          return actions.isDisplayed(driver, ProductName);
        }
      
        public boolean Price()
        {
          return actions.isDisplayed(driver, PriceDisplay);
        }
        
        public void enterQuantity(String Qty)
        {
        	actions.selectBySendkeys(Qty, EnterQuantity);
        }
        
        public ShoppingCartPage addtocartbtn()
        {
        	actions.click(driver, AddToCartbtn);
        	return new ShoppingCartPage(driver);
        }
        
        public String ValidateTitle()
        {
            return actions.getTitle(driver);
        	
        }


}
