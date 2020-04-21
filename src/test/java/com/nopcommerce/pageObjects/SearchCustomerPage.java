package com.nopcommerce.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage
{
	public WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		ldriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@FindBy(how=How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID,using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']//tbody/tr")
	@CacheLookup
	List<WebElement>tableRows;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement>tableColumns;
	
	public void setEmail(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);		
	}
	
	public void setLastName(String lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	public void clickSearch()
	{
		btnSearch.click();
	}
	public int getNoOfRows()
	{
		return(tableRows.size());
	}
	public int getNoOfColumns()
	{
		return(tableColumns.size());
	}
	
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		
		for(int i=1;i<=getNoOfRows();i++)
		{
			
			String emailid=table.findElement(By.xpath("//table[@role='grid']/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(emailid);
			
			if(emailid.equals(email))
			{
				flag=true;
				break;
			}
				
		}
		return flag;	
		
	}
	public boolean searchCustomerByName(String Name)
	{
		boolean flag=false;
		
		for(int i=1;i<=getNoOfColumns();i++)
		{
			String name=table.findElement(By.xpath("//table[@role='grid']/tbody/tr[" + i + "]/td[3]")).getText();
			
			if(Name.equals(name))
			{
				flag=true;
				break;
			}		
			
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
