package com.crm.autodesk.orgtest;
/**
 * @authorAswathy
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganizationNotifyOwnerSelected extends BaseClass {
      
	
	public void organizationNotifyOwnerSelected() throws Throwable {
		//create 


		
		int ranDomNum = jLib.getRandomNumber();
		
		String orgName = eLib.getDataFromExcel("Sheet1", 3,2)+ranDomNum;
		
	
		//navigate to org
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//navigate to create org
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrg();
		
		//create org
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrgNotifyOwner(orgName);
   
		//verification
		String actual = driver.findElement(By.xpath("//span[@id='dtlview_Notify Owner']")).getText();
	    String yes="yes";
	   
	   if(actual.contains(yes))
	   {
		   System.out.println("Test is pass ");
	   }
	   else
	   {
		   System.out.println("Test is fail");
	   }
	   
	  
	
	
	}

}
