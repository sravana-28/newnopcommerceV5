package com.nopcommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass 
{
	@Test(priority=1)
	public void SearchCustomerbyName() throws InterruptedException
	{
		logger.info("**************** Starting TC_LoginDDT_002 ************* ");
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		//Goto search Page
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		//provide firstname and lastname to searchpage
		
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setFirstName("Victoria");
		searchcust.setLastName("Terces");
		searchcust.clickSearch();
		Thread.sleep(3000);
		
		
		//validation
		
		boolean status=searchcust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
		
		
		
	}
	


}
