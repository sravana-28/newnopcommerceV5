package com.nopcommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByEmail_004 extends BaseClass

{
	
	@Test(priority=1)
	public void searchCustomerbyEmail() throws InterruptedException	
	{
		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		//goto search
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		//provide email in searchapage
		
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setEmail("brenda_lindgren@nopCommerce.com");
		searchcust.clickSearch();
		Thread.sleep(3000);
		
		boolean status=searchcust.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
		Assert.assertEquals(true, status);
			
	}
	
	
	

}
