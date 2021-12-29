package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {

	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public WebElement OrgHeaderText() {
		return orgHeaderText;
	}
	
	//business library
	public String getOrgInfo()
	{
		return(orgHeaderText.getText());
	}
}
