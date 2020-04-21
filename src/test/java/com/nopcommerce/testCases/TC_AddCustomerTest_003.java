package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_AddCustomerTest_003 extends BaseClass

{
	

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		logger.info("**************** Starting TC_LoginTest_003 ************* ");
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);		
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		logger.info("***************   TC_AddCustomerTest_003 statred  *********** ");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();
		
		logger.info("***************  Providing customer details  *********** ");
		
		
		
		String email=randomstring()+"@gmail.com";
		
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFirstName("sandhya");
		addcust.setLastName("sravana");
		addcust.setGender("Female");
		addcust.setDob("12/05/1987"); // Format: D/MM/YYY
		addcust.setCompanyName("busyQA");
		addcust.setCustomerRoles("Vendors");
		addcust.setManagerOfVendor("Vendor 1");
		Thread.sleep(3000);
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();
		
		//validation
		if(addcust.verifyConfirmationMsg())
		{
			logger.info("***************  Customer added succesfully *********** ");
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("*************** Customer Not added succesfully *********** ");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			
		}
		logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
			
		
	}

}
