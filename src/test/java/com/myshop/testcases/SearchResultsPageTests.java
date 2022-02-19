package com.myshop.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.actionsdriver.Myactions;
import com.myshop.base.BaseClass;
import com.myshop.pageobjects.HomePage;
import com.myshop.pageobjects.LogInPage;
import com.myshop.pageobjects.MyAccountsPage;
import com.myshop.pageobjects.ProductComparisonPage;
import com.myshop.pageobjects.ProductDisplayPage;
import com.myshop.pageobjects.SearchResultsPage;

public class SearchResultsPageTests extends BaseClass {

	SearchResultsPage Result;
	ProductDisplayPage MyProduct;
	HomePage Hp;
	LogInPage Lp;
	MyAccountsPage MyPage;
	ProductComparisonPage compare;

	@Test(enabled = false)
	public void VerifyResultsPageTitle() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		String ActualTitle = Result.getTitle();
		String ExpectedTitle = "Search results for: 'Samsung Galaxy'";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@Test(enabled = false)
	public void validateSorting() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung TV");
		log.info("Sorting by name");
		Result.sortByName();
		ArrayList<String> AfterSort = new ArrayList<String>();
		for (WebElement i : Result.productName()) {
			AfterSort.add(i.getText());
		}
		log.info("this is the actual result");
		System.out.println(AfterSort);

		ArrayList<String> validateSort = new ArrayList<String>();
		for (WebElement j : Result.productName()) {
			validateSort.add(j.getText());
		}
		Collections.sort(validateSort);
		log.info("this is the expected result");
		System.out.println(validateSort);

		log.info("now matching the results");
		if (AfterSort.equals(validateSort))

		{
			Assert.assertTrue(true);
			log.info("Elements are sorted properly");

		}

		else {
			log.info("sorting failed");
			captureScreen(driver, "validateSorting");
			Assert.assertTrue(false);

		}
	}

	@Test(enabled = false)
	public void verifyProductPageTitle() throws Throwable {
		Hp = new HomePage(driver);
		Result = Hp.searchProduct("Samsung Galaxy");
		MyProduct = Result.clickOnProduct();
		String ActualTitle = MyProduct.ValidateTitle();
		String ExpectedTitle = "Samsung Galaxy";
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test
	public void productComparison() throws Throwable {
		log.info("opened the url");
		Hp = new HomePage(driver);
		Lp = Hp.clickOnAccounts();
		MyPage = Lp.login(username, URL);
		Thread.sleep(3000);
		Result = MyPage.tvMenu();
		log.info("adding products to compare");
		Thread.sleep(2000);
		Result.addTocompare();
		log.info("comparing products");
		Set<String> Handles = driver.getWindowHandles();
		Iterator<String> it = Handles.iterator();
		String Parenthandle=it.next();
		String Childhandle=it.next();
		driver.switchTo().window(Childhandle);
		driver.manage().window().maximize();
		log.info("switched to comparison popup");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		String ActualTitle=compare.pageTitle();
		Assert.assertEquals(ActualTitle, "Compare Products");
		log.info("Pagetitle verified");
		Assert.assertEquals(compare.productName1(), "LG LCD");
		Assert.assertEquals(compare.productName2(), "Samsung LCD");
		compare.closeWindow();
		driver.switchTo().window(Parenthandle);
          log.info("switching back to tv menu");
		Assert.assertEquals(Result.getTitle(), "TV");
		log.info("product comparison test passed");

	}
	
	public void shareWishlist() throws Throwable
	{
		log.info("opened the url");
		Hp = new HomePage(driver);
		Lp = Hp.clickOnAccounts();
		MyPage = Lp.login(username, URL);
		Thread.sleep(3000);
		Result = MyPage.tvMenu();
	}
}
