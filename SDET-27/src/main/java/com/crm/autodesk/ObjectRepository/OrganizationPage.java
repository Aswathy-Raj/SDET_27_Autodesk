package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImage;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	//initilaization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateOrgLookUpImage() {
		return createOrgLookUpImage;
	}
	
	public WebElement getsearchTextEdt() {
		return searchTextEdt;
	}
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	
	}
	//business library
	public void clickOnCreateOrg()
	{
		createOrgLookUpImage.click();
	}
}

