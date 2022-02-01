package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class SearchResultsPage extends BaseClass 
{
WebDriver Ldriver;//our local driver
	
	public SearchResultsPage(WebDriver rdriver)//this is our remote driver
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//specifying page factory class
	}
        
        Myactions actions=new Myactions();
        
        @FindBy(id="product-collection-image-3")
        WebElement ProductResult;
        
        public String getTitle()
        {
        	return actions.getTitle(driver);
        }
        
        public boolean isProductAvailable() throws Throwable {
    		return actions.isDisplayed(driver, ProductResult);
    	}
    	
    	public ProductDisplayPage clickOnProduct() throws Throwable {
    		actions.click(driver, ProductResult);
    		return new ProductDisplayPage(driver);
    	}

}
