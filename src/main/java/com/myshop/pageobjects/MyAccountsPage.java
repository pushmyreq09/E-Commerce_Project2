package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class MyAccountsPage extends BaseClass {
	
Myactions actions= new Myactions();
WebDriver Ldriver;//our local driver

    public MyAccountsPage(WebDriver rdriver)//this is our remote driver
       {
	      Ldriver=rdriver;
	      PageFactory.initElements(rdriver,this);//specifying page factory class
       }
	
	@FindBy(xpath="//ul/li[8]")
	 WebElement myWishList;
	
	@FindBy(xpath="//a[text()='My Orders']")
	 WebElement myOrders;
	
	

	
	public boolean validateMyWishList() throws Throwable {
		return actions.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return actions.isDisplayed(driver, myOrders);
	}
	
	public String getCurrURL() throws Throwable {
		String accountPageurl=actions.getCurrentURL(driver);
		return accountPageurl;
	}

}
