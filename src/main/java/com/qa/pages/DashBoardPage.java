package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseClass;

public class DashBoardPage extends BaseClass
{
   
	@FindBy(xpath="//div[@class='head']//following::h1[1]")
	WebElement checkTitle;
	
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']/b")
	WebElement clickAdmin;
	
	@FindBy(xpath="//*[@id='menu_pim_viewPimModule']/b")
    WebElement clickPIM;
	
	@FindBy(xpath="//*[@id='menu_leave_viewLeaveModule']/b")
    WebElement clickLeave;
	
	@FindBy(xpath="//*[@id='menu_time_viewTimeModule']/b")
    WebElement clickTime;
	
	public DashBoardPage()
	 {
		PageFactory.initElements(driver, this);
	 }
	
	
	public boolean verifyDashboardTitle()
	{
		return checkTitle.isDisplayed();
	}
	
	public AdminPage gotoAdminpage()
	{
		clickAdmin.click();
		return new AdminPage();
	}
	
	public PIMPage gotoPIMPage()
	{
		clickPIM.click();
		return new PIMPage();
		
	}
	
	public LeavePage gotoLeavePage()
	{
		clickLeave.click();
		return new LeavePage();
	}

	public TimePage gotoTimePage()
	{
		clickTime.click();
		return new TimePage();
	}
	
}
