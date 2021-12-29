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

public class CreateContactDemo {
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
		
		
		
		//Sheet sh=book.getSheet("Sheet1");
		//Row r=sh.getRow(2);
		
		String orgName = eLib.getDataFromExcel("Sheet1", 1,2);
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
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String msg=driver.findElement(By.className("dvHeaderText")).getText();
		if(msg.contains(orgName)) {
			System.out.println("New Contact created");
		}
		else {
			System.out.println("contact not created");
		}
		wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
