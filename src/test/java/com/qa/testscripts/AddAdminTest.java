package com.qa.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.AdminPage;
import com.qa.pages.DashBoardPage;
import com.qa.pages.LoginPage;
import com.qa.utils.Utilities;

public class AddAdminTest extends AdminPage {

	private DashBoardPage dpage;
	private LoginPage lpage;
	private AdminPage apage;
	Utilities util;
	String sheetName="addAdmin";
	
	public AddAdminTest()
	{
		super();
	}
	
	  @BeforeMethod
	  public void setUp() throws InterruptedException
	  {
		  initApp();
		  lpage=new LoginPage();
		  dpage=lpage.loginCred(pro.getProperty("username"),pro.getProperty("password"));
		  Thread.sleep(7000);
		  apage=new AdminPage();
		  
		}
	
	/* @Test(priority=1)
	 public void addAdminUser() throws InterruptedException, IOException
	 {
		    dpage.gotoAdminpage();
			//apage.gotoUsers();
		}
	  */
	  @DataProvider
	  public Object[] [] geAdminUserData()
	  {
		
		  Object[][] ob=null;
		try {
			ob = Utilities.getUserdata(sheetName);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return ob;
	  }
	 
	  @Test(priority=1,dataProvider="geAdminUserData")
	   public void newUsersData(String userRole, String empName, String useName, String status, String password, String cnfPassword) throws InterruptedException
	     {
		    dpage.gotoAdminpage();
	    	apage.gotoUsers();
			apage.addNewUser(userRole, empName, useName, status, password, cnfPassword);
			
		
	     }  
	    	
	    @AfterMethod
	    public void closeApp()
	    {
	    	driver.quit();
	    	
	    	
	    }
	    	
	  }
	   
