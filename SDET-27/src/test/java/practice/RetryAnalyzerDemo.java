package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerDemo {

	@Test(retryAnalyzer=com.crm.autodesk.genericutility.RetryAnalyzerImplementation.class)
	
	
	public void retryAnalyzer()
	{
		
		System.out.println("RetryAnalyzer");
		Assert.fail();
	}

}