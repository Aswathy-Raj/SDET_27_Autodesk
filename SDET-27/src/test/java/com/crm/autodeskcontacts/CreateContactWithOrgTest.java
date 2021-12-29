package com.crm.autodeskcontacts;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.Random;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

/**
 * 
 * @authorAswathy
 *
 */
	public class CreateContactWithOrgTest extends BaseClass{

		//create object
		@Test
		
		public void createContactWithOrgTest() throws Throwable
		{
			int ranDomNum = jLib.getRandomNumber();
			//read test data
			String orgName = eLib.getDataFromExcel("Sheet1", 3,2)+ranDomNum;
			//String Actmsg=eLib.getDataFromExcel("Sheet1", 3,2);
	      
	        
	      
			
		
		    //navigate to contact
			HomePage hp= new HomePage(driver);
			hp.clickOnContactsLink();
			
		    //navigate to create contact
			ContactPage cp=new ContactPage(driver);
			cp.clickOnCreateContact();
			
			//create contact with org
			CreateContactPage ccp=new CreateContactPage(driver);
			ccp.clickOnCreateOrgContactImg(orgName);
			
			ContactInfoPage cip=new ContactInfoPage(driver);
	        String Actmsg=cip.getContInfo();
			
	        if(Actmsg.contains(orgName)) {
	        	System.out.println("successful");
	        }
			
			
		
	}
	}



