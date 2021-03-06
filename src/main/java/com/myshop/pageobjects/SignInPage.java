package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class SignInPage extends BaseClass {

	Myactions actions = new Myactions();
	WebDriver Ldriver;// our local driver

	public SignInPage(WebDriver rdriver)// this is our remote driver
	{
		Ldriver = rdriver;
		PageFactory.initElements(rdriver, this);// specifying page factory class
	}

	@FindBy(xpath = "//h1[text()='Create an Account']")
	private WebElement PageTitle;

	@FindBy(id = "firstname")
	private WebElement Firstname;

	@FindBy(id = "lastname")
	private WebElement Lastname;

	@FindBy(id = "email_address")
	private WebElement Email_address;

	@FindBy(id = "password")
	private WebElement Password;

	@FindBy(id = "confirmation")
	private WebElement Confirmation;

	@FindBy(xpath = "//button[@title='Register']")
	private WebElement Registration;

	public void AccountCreation(String fname, String lname, String Email, String password, String confirm)

	{
		actions.type(Firstname, fname);
		actions.type(Lastname, lname);
		actions.type(Email_address, Email);
		actions.type(Password, password);
		actions.type(Confirmation, confirm);

	}

	public MyAccountsPage ValidateRegistration() {
		Registration.click();
		return new MyAccountsPage(driver);
	}

	public String VerifyPagetitle() {
		return actions.getTitle(driver);
	}

}
