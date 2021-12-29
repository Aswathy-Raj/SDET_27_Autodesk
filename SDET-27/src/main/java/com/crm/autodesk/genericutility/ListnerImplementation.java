package com.crm.autodesk.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener{
	public void onTestStart(ITestResult result)
	{
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		
    }
	
	public void onTestFailure(ITestResult result)
	{
		
	
	//capture the method name
	String methodName=result.getMethod().getMethodName();
	
	String CurrentDate= new JavaUtility().getSystemDateWithFormat();
	
	
	String screenShotName= methodName+"-"+CurrentDate;
	
	try {
		new WebDriverUtility().takeScreenshot(BaseClass.sdriver, screenShotName);
	}
	catch(Throwable e) {
		
		e.printStackTrace();
	}

	}


public void onTestSkipped(ITestResult result) {
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
}

}