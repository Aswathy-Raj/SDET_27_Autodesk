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

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganiztionCopyShippingAddressSelect extends BaseClass {

	public void organiztionCopyShippingAddressSelect() throws Throwable {
		
		int ranDomNum = jLib.getRandomNumber();
		
		
		String orgName = eLib.getDataFromExcel("Sheet1", 3,2)+ranDomNum;
		String shpAdd = eLib.getDataFromExcel("Sheet1", 10,3)+ranDomNum; 
		
		
	
	//navigate to  organization module
	
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationsLink();
	
	//click on create organization button
	
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnCreateOrg();
	
	//organization name
	
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	cop.createCopyShipAddr(orgName, shpAdd);
	

	String actual=driver.findElement(By.xpath("//span[@id='dtlview_Shipping Address']")).getText();
	
	if(actual.contains(shpAdd)) {
		System.out.println("Test is pass");
		
	}
	else {
		System.out.println("Test is fail");
	}
	
	
	

}

	
	}


