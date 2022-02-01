package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class HomePage extends BaseClass {
	
        
    WebDriver Ldriver;//our local driver
	
	public HomePage(WebDriver rdriver)//this is our remote driver
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//specifying page factory class
	}
        
        Myactions actions=new Myactions();
        
        @FindBy(xpath="//a[@class='logo']")
         WebElement mylogo;
        
        @FindBy(xpath="//input[@id='search']")
         WebElement searchbox;
        
        @FindBy(xpath="//button[@class='button search-button']")
        WebElement searchbutton;
        
        @FindBy(xpath="//a/span[text()='Account']")
        WebElement Accounts;
        
        @FindBy(linkText="My Account")
        WebElement MyAccount;
        
        public boolean validateLogo() throws Throwable
        {
    		return actions.isDisplayed(driver, mylogo);
    	}
    	
    	public String getMyStoreTitle()
    	{
    		String mysiteTitle=driver.getTitle();
    		return mysiteTitle;
    	}
    	
    	public SearchResultsPage searchProduct(String productName) throws Throwable
    	{
    		actions.type(searchbox, productName);
    		actions.scrollByVisibilityOfElement(driver, searchbutton);
    		actions.click(driver, searchbutton);
    		Thread.sleep(3000);
    		return new SearchResultsPage(driver);
    	}
        
    	public LogInPage clickOnAccounts() throws Throwable {
    		actions.click(driver, Accounts);
    		Thread.sleep(2000);
    		actions.click(driver, MyAccount);
    		return new LogInPage(driver);
    	}
        
        
        
        
}
