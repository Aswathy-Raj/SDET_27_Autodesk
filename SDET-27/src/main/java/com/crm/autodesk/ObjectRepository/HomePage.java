package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

//create seperate class for homepage 
public class HomePage extends WebDriverUtility{

//declaration

	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;

	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	//initialization
	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	public WebElement getProductsLnk() {
		return productsLnk;
	}
	public WebElement getAdministratorImg () {
		return administratorImg;
	}
	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//business library
	public void clickOnOrganizationsLink() {
		organizationLnk.click();
	}
	public void clickOnContactsLink() {
		contactsLnk.click();
	}
	public void signOutLink(WebDriver driver) {
		
		mouseOverOnElement(driver,administratorImg);
		signoutLnk.click();
	}

	//public void logout(WebDriver driver) {
		// TODO Auto-generated method stub
		
	//}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
