package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{

	//declaration
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@name='notify_owner']")
	private WebElement notifycheckbox;
	
	@FindBy(xpath="//input[@onclick='return copyAddressLeft(EditView)']")
	private WebElement cpyShipAdd;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//initialization
	public  CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
		
	public WebElement getTypeDropDown() {
			return typeDropDown;
		
	}
	
	public WebElement getnotifycheckbox() {
		return notifycheckbox;
	
    }
	
	public WebElement getCpyShipAdd() {
		return cpyShipAdd;
	
    }
	
	public WebElement getSaveBtn() {
		return saveBtn;
	
    }
	//business library for create organization
	
	public void createOrg(String orgName) {
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	//business library for create organization with industry dropdown
	public void createOrgWithIndustryType(String orgName, String industry, String type) {
		organizationNameEdt.sendKeys(orgName);
		industryDropDown.sendKeys(industry);
		typeDropDown.sendKeys(type);
		saveBtn.click();
	}
	
	public void createOrgNotifyOwner(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
		notifycheckbox.click();
		saveBtn.click();
	}
	
	public void createCopyShipAddr(String orgName, String shpAdd)
	{
		organizationNameEdt.sendKeys(orgName);
		
		cpyShipAdd.click();
		saveBtn.click();
	}

}
