package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class LogInPage extends BaseClass {

	WebDriver Ldriver;// our local driver

	public LogInPage(WebDriver rdriver)// this is our remote driver
	{
		Ldriver = rdriver;
		PageFactory.initElements(rdriver, this);// specifying page factory class
	}

	Myactions actions = new Myactions();
	@FindBy(name = "login[username]")
	private WebElement emailaddress;

	@FindBy(id = "pass")
	private WebElement Password;

	@FindBy(name = "send")
	private WebElement loginbtn;

	@FindBy(xpath = "//span[text()='Create an Account']")
	private WebElement createNewAccountBtn;

	public MyAccountsPage login(String uname, String pswd) throws Throwable {
		actions.scrollByVisibilityOfElement(driver, emailaddress);
		actions.type(emailaddress, uname);
		actions.type(Password, pswd);
		actions.click(driver, loginbtn);
		Thread.sleep(2000);
		return new MyAccountsPage(driver);
	}

	public SignInPage createNewAccount() throws Throwable {
		actions.click(driver, createNewAccountBtn);
		return new SignInPage(driver);
	}

}
