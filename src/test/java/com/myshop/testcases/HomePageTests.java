package com.myshop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myshop.base.BaseClass;
import com.myshop.pageobjects.HomePage;

public class HomePageTests extends BaseClass {
	HomePage Hp;
	
	@Test(groups="Smoke")
	
	public void verifyLogo() throws Throwable {
		
		log.info("Opened the url");
	    Hp=new HomePage(driver);
		boolean result=Hp.validateLogo();
		log.info("validating logo");
		Assert.assertTrue(result);
		log.info("logo test passed");
	}
	@Test(groups="Smoke")
	public void verifyTitle() {
		
		log.info("Opened the url");
		Hp=new HomePage(driver);
		String PageTitle=Hp.getMyStoreTitle();
		log.info("validating the pagetitle");
		Assert.assertEquals(PageTitle,"Home page");
		log.info("logo test passed");
		
	}
		
		
	

}
