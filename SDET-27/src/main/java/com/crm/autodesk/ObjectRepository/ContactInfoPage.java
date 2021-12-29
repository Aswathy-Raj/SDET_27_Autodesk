package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contHeaderText;
	
	//initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement ContactInfoPage() {
		return contHeaderText;
	}
	//business library
	public String getContInfo() {
		return(contHeaderText.getText());
	}
}
