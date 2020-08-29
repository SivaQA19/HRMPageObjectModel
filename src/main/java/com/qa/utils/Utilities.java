package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.BaseClass;

public class Utilities extends BaseClass {

	public static String testData="C:\\Users\\Dell\\eclipse-workspace\\OrangeHRMPOM\\Testdata\\adduserdata.xlsx";
	static Workbook wbook;
	static Sheet wsheet;
	
	
	public static Object[][] getUserdata(String sheeetName) throws EncryptedDocumentException, IOException {
		
		 FileInputStream fis=null;
		try {
			 fis=new FileInputStream(testData);
			} 
		  catch (FileNotFoundException e) {
			e.printStackTrace();
		   }
		
		   wbook=WorkbookFactory.create(fis);
		   wsheet=wbook.getSheet(sheeetName);
		   Object [][] obj=new Object[wsheet.getLastRowNum()][wsheet.getRow(0).getLastCellNum()];
		   
		   for(int i=0; i<wsheet.getLastRowNum(); i++)
		   {
			   for (int j=0; j<wsheet.getRow(0).getLastCellNum(); j++)
			   {
				   obj[i][j]=wsheet.getRow(i+1).getCell(j).toString();
			   }
		   }
		   
		return obj;
	}	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String currentDir = System.getProperty("user.dir");
				FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
			}	 
	  
 }	

