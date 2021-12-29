package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	@FindBy(name="lastname")
	private WebElement contactLastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement contactnameLookUpImage;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getcontactLastNameEdt() {
		return contactLastNameEdt;
	}
	
	public WebElement getContactnameLookUpImage() {
		return contactnameLookUpImage;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//business library for create contact
	
	public void createContact(String orgName) {
		contactLastNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	//business library for lastname

	public void clickOnCreateOrgContactImg(String orgName)
	{
		contactLastNameEdt.sendKeys(orgName);
		contactnameLookUpImage.click();
		saveBtn.click();
	}
}
