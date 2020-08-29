package com.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.LoginPage;

public class LoginPageTest extends LoginPage 
{

private LoginPage lpage;	
 
  public LoginPageTest() {
  super();
  
  }
	
  @BeforeMethod
  public void setUp()
  {
	  initApp();
	  lpage=new LoginPage();
	}
	
  // verifying the title
   @Test(priority=1)
   public void verifyPageTitle() throws InterruptedException
   {
	 String actTitle=lpage.getPagetitle();
	 Assert.assertEquals(actTitle, "OrangeHRM");
	 Thread.sleep(5000);
	}

   //verify Webelement
   
   @Test(priority=2)
   public void verifyLoginElement() throws InterruptedException
	   {
		   boolean ele=lpage.verifyWebelement();
		   Assert.assertTrue(ele);
		   Thread.sleep(5000);
	   }
   
   
   @Test(priority=3)
   public void loginTest() throws InterruptedException
   {
	   lpage.loginCred(pro.getProperty("username"),pro.getProperty("password"));
	   Thread.sleep(6000);
  }
   
    //close the browser
  @AfterMethod
  public void closeApp()
  {
	  driver.quit();
  }
  
}
