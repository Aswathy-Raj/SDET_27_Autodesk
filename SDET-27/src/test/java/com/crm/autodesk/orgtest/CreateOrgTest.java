package com.crm.autodesk.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateOrgTest extends BaseClass
{

	

	//create object

	@Test(groups= {"RegressionSuite","SmokeSuite"})
			public void createOrgTest() throws Throwable
			{
				
				//get random number int
			int ranDomNum = jLib.getRandomNumber();
			
			//read test data
			String orgName = eLib.getDataFromExcel("Sheet1", 3,2)+ranDomNum;
			
			
		
		//navigate to org
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//navigate to create org
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrg();
		
		//create org and enter details
		
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		Assert.fail();
		
		
		//verification
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		//oip.getOrgInfo();
		String ActMsg=oip.getOrgInfo();
		Assert.assertTrue(ActMsg.contains(orgName));
			System.out.println("Organization created");
		
		
			}	
		          
		 @Test(groups= {"RegressionSuite","SmokeSuite"})
		 public void demo()
		 {
			 System.out.println("demo");
		 }
}
