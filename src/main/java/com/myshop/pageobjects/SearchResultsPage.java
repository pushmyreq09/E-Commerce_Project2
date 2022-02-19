package com.myshop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;

public class SearchResultsPage extends BaseClass {
	WebDriver Ldriver;// our local driver

	public SearchResultsPage(WebDriver rdriver)// this is our remote driver
	{
		Ldriver = rdriver;
		PageFactory.initElements(rdriver, this);// specifying page factory class
	}

	Myactions actions = new Myactions();

	@FindBy(id = "product-collection-image-3")
	private WebElement ProductResult;

	@FindBy(xpath = "//h2[@class='product-name']")
	private List<WebElement> ProductNames;

	@FindBy(xpath = "//div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/select[1]")
	private WebElement Sorter;

	@FindBy(xpath = "//a[text()='Samsung Galaxy']//following::button[1]")
	private WebElement AddtoCartbtn;

	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")
	private WebElement compareproduct1;

	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]")
	private WebElement compareproduct2;

	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[1]/a[1]")
	private WebElement addtowishlist;

	@FindBy(xpath = "//button[@title='Compare']")
	private WebElement Comparebtn;

	public String getTitle() {
		return actions.getTitle(driver);
	}

	public void sortByName() {

		actions.selectByVisibleText("Name", Sorter);

	}

	public List<WebElement> productName() {

		return ProductNames;
	}

	public ProductDisplayPage clickOnProduct() throws Throwable {
		actions.click(driver, ProductResult);
		return new ProductDisplayPage(driver);
	}

	public ShoppingCartPage addtoCart() {
		actions.click(driver, AddtoCartbtn);
		return new ShoppingCartPage(driver);
	}

	public void addTocompare() throws InterruptedException {
		compareproduct1.click();
		Thread.sleep(2000);
		compareproduct2.click();
		Thread.sleep(2000);
		Comparebtn.click();

	}

}
