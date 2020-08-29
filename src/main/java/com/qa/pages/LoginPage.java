package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement clLogin;
	
	
	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement verifyLogin;
	
	
	// initialize webelements
   public LoginPage()
	 {
	     PageFactory.initElements(driver, this);
	 }
	
   
   //page title
   
   public String getPagetitle()
   {
	   return driver.getTitle();
   }
   
   //webelement check
   public boolean verifyWebelement()
   {
	   return verifyLogin.isDisplayed();
	   
   }
   
    //login cred
   public DashBoardPage loginCred(String uname, String pwd)
   {
	    username.sendKeys(uname);
	    password.sendKeys(pwd);
	    clLogin.click();
	    return new DashBoardPage();
	}
   
  }
