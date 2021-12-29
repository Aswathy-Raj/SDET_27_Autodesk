package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {

	//object creation for libraries
	
	public  JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public  WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void dbConnection() 
	
	{
		
		//dLib.connectToDB();
		System.out.println("...DataBase Connection successful......");
	}
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void launchBrowser()throws Throwable {
		//read  the data
		
		String BROWSER= fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
        }
		else {
			System.out.println("invalid browser");
		}
		sdriver=driver;
		wLib.waitForpageToLoad(driver);
		//wLib.maximiseWindow(driver);
		driver.get(URL);
		
	}
	@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable 
	{
		// read the data
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("......login successful....");
		
	}
	
	@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
	
		public void logoutOfApp()
		{
		HomePage hp= new HomePage(driver);
		hp.signOutLink(driver);
		
		}
	@AfterSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void closeDbConnection()
	{
		//dLib.closeDB();
		System.out.println("........Database closed........");
	}
	
}
