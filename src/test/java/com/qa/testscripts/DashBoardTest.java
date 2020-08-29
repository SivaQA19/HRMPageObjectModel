package com.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.DashBoardPage;
import com.qa.pages.LoginPage;

public class DashBoardTest extends DashBoardPage
{

	private LoginPage lpage;
	private DashBoardPage dpage;
	
	public DashBoardTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initApp();
		lpage=new LoginPage();
		dpage=lpage.loginCred(pro.getProperty("username"),pro.getProperty("password"));
		
	}
	
	@Test
	public void checkDashboardTitle() throws InterruptedException
	{
		
		boolean ele=dpage.verifyDashboardTitle();
		Assert.assertTrue(ele);
		Thread.sleep(4000);
		
    }
	
	
	@AfterMethod
	public void closeApp() 
	{
		driver.quit();
	}
	
}
