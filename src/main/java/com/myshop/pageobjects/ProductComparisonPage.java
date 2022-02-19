package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class ProductComparisonPage extends BaseClass {
	WebDriver Ldriver;

	public ProductComparisonPage(WebDriver rdriver) {
		Ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	Myactions actions = new Myactions();

	@FindBy(xpath = "//h1[contains(text(),'Compare Products')]")
	private WebElement PageTitle;

	@FindBy(linkText = "LG LCD")
	private WebElement ProductName1;

	@FindBy(linkText = "Samsung LCD")
	private WebElement ProductName2;

	@FindBy(xpath = "//button[@title='Close Window']")
	private WebElement Close;

	public String pageTitle() {
		return PageTitle.getText();
	}

	public String productName1() {
		return ProductName1.getText();
	}

	public String productName2() {
		return ProductName2.getText();
	}

	public void closeWindow() {
		Close.click();

	}

}
