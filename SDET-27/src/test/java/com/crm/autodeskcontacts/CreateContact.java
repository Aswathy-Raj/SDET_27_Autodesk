package com.crm.autodeskcontacts;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

public class CreateContact extends BaseClass{

	@Test(groups= {"RegressionSuite","SmokeSuite"})
	public void createContacts() throws Throwable {
		
		//get random number
		int ranDomNum = jLib.getRandomNumber();
	
		//get data from Excel
		String orgName = eLib.getDataFromExcel("Sheet1", 1,2)+ranDomNum;
        //String contName=r.getCell(1).getStringCellValue()+ranDomNum;     
    	//navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//click on create contact
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContact();
		
		//enter all details and create new contact
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(orgName);
		
		//verify from header
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ActMsg=cip.getContInfo();


		Assert.assertTrue(ActMsg.contains(orgName));
		System.out.println("Contact created successfully");
	}

}
