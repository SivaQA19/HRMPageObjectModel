package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.pages.LoginPage;
import com.qa.utils.WebEventListener;

public class BaseClass 
{

	public static WebDriver driver;
	public static Properties pro;
	public static EventFiringWebDriver efDriver;
	public static WebEventListener eventListener;
	
	//get the properties file
	public BaseClass() 
	{
		try
		{
		pro=new Properties();
		FileInputStream fis;
	    fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\FreeCRMPOM\\src\\main\\java\\com\\qa\\config\\environment.properties");
		pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	
	
	public static void initApp()
	{
		 String browserName=pro.getProperty("browser");
		 
		 if(browserName.equalsIgnoreCase("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ("//Drivers//chromedriver.exe "));
			 
			    ChromeOptions chOption = new ChromeOptions();
			    chOption.addArguments("headless");
		        chOption.addArguments("window-size=1200x600");
			    chOption.addArguments("start-maximized");
		        chOption.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				chOption.setExperimentalOption("useAutomationExtension", false);
		        Map<String, Object> prefs = new HashMap<String, Object>();
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		        chOption.setExperimentalOption("prefs", prefs);
		        driver = new ChromeDriver(chOption);
		        
		        
			/* 
		     ChromeOptions options=new ChromeOptions();
			 options.addArguments("start-maximized");
			 options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			 options.setExperimentalOption("useAutomationExtension", false);
			*/
		        
		      efDriver=new EventFiringWebDriver(driver);
		    // Now create object of EventListerHandler to register it with EventFiringWebDriver
		      eventListener=new WebEventListener();
		      efDriver.register(eventListener);
		      driver=efDriver;
		      
			 
		     driver.manage().deleteAllCookies();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			 driver.get(pro.getProperty("url"));
			 
		 }
		 
		 else if(browserName.equalsIgnoreCase("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ("//Drivers//geckodriver.exe "));
			 driver=new FirefoxDriver();
		 }
		 
	 }
	
}
