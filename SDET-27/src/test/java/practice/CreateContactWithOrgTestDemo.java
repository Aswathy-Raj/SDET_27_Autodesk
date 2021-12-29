package practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactWithOrgTestDemo {
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
		String orgName = eLib.getDataFromExcel("Sheet1", 3,2);
		//Sheet sh=book.getSheet("Sheet1");
		//Row r=sh.getRow(2);
		
		
        //String contName=r.getCell(1).getStringCellValue()+ranDomNum;     
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
	    
		
	   //wait for Element to be active
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		Set<String>set=driver.getWindowHandles();
	    Iterator<String> it =set.iterator();
	    
	    while(it.hasNext()) {
	    
	    	String currentID=it.next();
	    	driver.switchTo().window(currentID);
	    	String cPageTitle= driver.getTitle();
	    	if(cPageTitle.contains("Accounts")) {
	    		break;
	    	}
}
	    driver.findElement(By.name("search_text")).sendKeys(orgName);
	    driver.findElement(By.name("search")).click();
	   // driver.findElement(By.xpath("//a[text()='"+contName+"']")).click();
	    
		
		Set<String> set1=driver.getWindowHandles();
	    Iterator<String> it1 =set1.iterator();
	    
	    while(it1.hasNext()) {
		    
	    	String currentID=it1.next();
	    	driver.switchTo().window(currentID);
	    	String cPageTitle= driver.getTitle();
	    	if(cPageTitle.contains("Contacts")) {
	    		break;
	    	}
}
	    
	    wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
}
}
