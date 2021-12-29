package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrgIndTypeDemo {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		
		int ranDomNum = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("Sheet1", 6,1)+ranDomNum;
		
       // String contName=r.getCell(1).getStringCellValue()+ranDomNum;    
       // String industries=r.getCell(2).getStringCellValue();
       //String types=r.getCell(3).getStringCellValue();
        WebDriver driver;
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
             driver= new FirefoxDriver();   
		}
		else if(BROWSER.equals("ie")) {
        driver= new InternetExplorerDriver(); 
}
		else { 
			driver = new ChromeDriver();
		} 
		wLib.waitForpageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);	
		driver.findElement(By.id("submitButton")).click();
	    
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("industry")).sendKeys(orgName);
	    driver.findElement(By.name("accounttype")).sendKeys(orgName);
		
		String orgindus = eLib.getDataFromExcel("Sheet1", 6,2);
		wLib.select( driver.findElement(By.xpath("//select[@name='industry']")), orgindus);
	String orgtype = eLib.getDataFromExcel("Sheet1", 6,3);
		wLib.select( driver.findElement(By.xpath("//select[@name='accounttype']")), orgtype);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		String crIndustry = driver.findElement(By.id("mouseArea_Industry")).getText();
		
	       if(crIndustry.equals(orgindus))
			{
				System.out.println("Industry is added");
			}
			else {
				System.out.println("Industry is not added");
			}
	       String crType = driver.findElement(By.id("mouseArea_Type")).getText();
		if(crType.equals(orgtype))
		{
			System.out.println("Type is added");
		}
		else {
			System.out.println("Type is not added");
		}

			
			
		wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	} 
}
