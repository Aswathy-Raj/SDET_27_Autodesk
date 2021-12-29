package com.rmgyanta.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectCheckDataBse {
	
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("http://localhost:8084/");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
	driver.findElement(By.linkText("Projects")).click();
	driver.findElement(By.className("material-icons")).click();
	
	driver.findElement(By.name("projectName")).sendKeys("testc");
	driver.findElement(By.name("createdBy")).sendKeys("xyz");
	WebElement status = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
	Select s = new Select(status);
	s.selectByIndex(2);

	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	}
  
}
