package com.crm.autodesk.orgtest;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;


public class CreateOrgWithIndustries_Type extends BaseClass {

	//create object
	@Test
	public void createOrgWithIndustriesType() throws Throwable {


		//get Random number
		int ranDomNum = jLib.getRandomNumber();
		//read test data from Excel Sheet
		String orgName = eLib.getDataFromExcel("Sheet1", 6,1)+ranDomNum;
		
         
        String industry=eLib.getDataFromExcel("Sheet1", 6,2);
       String type=eLib.getDataFromExcel("Sheet1", 6,3);
        //WebDriver driver;
		
		
		
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrg();
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrgWithIndustryType(orgName,industry,type);
		
			 
		String crIndustry = driver.findElement(By.id("mouseArea_Industry")).getText();
		
	       if(crIndustry.contains(industry))
			{
				System.out.println("Industry is added");
			}
			else {
				System.out.println("Industry is not added");
			}
	       String crType = driver.findElement(By.id("mouseArea_Type")).getText();
		if(crType.contains(type))
		{
			System.out.println("Type is added");
		}
		else {
			System.out.println("Type is not added");
		}

			
			
		
	} 
	
}
			
			
			 
			
			
			
			
	


