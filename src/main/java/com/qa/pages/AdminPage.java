package com.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.base.BaseClass;


public class AdminPage extends BaseClass
{
	
	public static Select se;

	
	@FindBy(xpath="//a[text()='User Management']")
	WebElement clickUserMgt;
	
	@FindBy(xpath="//*[@id='menu_admin_viewSystemUsers']")
	WebElement clickUsers;
	
	@FindBy(xpath="//input[@name='btnAdd']")
	WebElement clickAdd;
	
	@FindBy(xpath="//*[@id='systemUser_userType']")
	WebElement clickUserrole;

	@FindBy(xpath="//input[@id='systemUser_employeeName_empName']")
	WebElement employeeName;
	
	@FindBy(xpath="//input[@id='systemUser_userName']")
	WebElement userName;
	
	@FindBy(xpath="//select[@id='systemUser_status']")
	WebElement selectStatus;
	
	
	@FindBy(xpath="//input[@id='systemUser_password']")
	WebElement upwd;
	
	@FindBy(xpath="//input[@id='systemUser_confirmPassword']")
	WebElement cpwd;
	
	@FindBy(xpath="//input[@id='btnSave' and @class='addbutton']")
	WebElement clickSave;
	
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void gotoUsers() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(clickUserMgt).build().perform();
		Thread.sleep(8000);
		clickUsers.click();
		Thread.sleep(4000);
		clickAdd.click();
		
		
	}
	
	 public void  addNewUser(String userRole, String empName, String useName, String status, String password, String cnfPassword) throws InterruptedException
	 {
		 
		 
		 se=new Select(clickUserrole);
		 se.selectByVisibleText(userRole);
		 employeeName.sendKeys(empName);
		 Thread.sleep(4000);
		 userName.sendKeys(useName);
		 se=new Select(selectStatus);
		 se.selectByVisibleText(status);
		 upwd.sendKeys(password);
		 cpwd.sendKeys(cnfPassword);
		 Thread.sleep(4000);
		 clickSave.submit();
		 Thread.sleep(6000);
		 
		 
	}
	  
}
