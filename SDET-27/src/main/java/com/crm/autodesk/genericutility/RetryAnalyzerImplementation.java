package com.crm.autodesk.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public  class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count=0;
	int retrycount=5;
	
	public boolean retry(ITestResult result) {
		
		while(count<=5)
		{
			count++;
			return true;
		}
		return false;
		
	}
	
	
}
