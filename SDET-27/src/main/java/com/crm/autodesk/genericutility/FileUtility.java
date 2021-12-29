package com.crm.autodesk.genericutility;

import java.io.FileInputStream;

import java.util.Properties;

/**
 * 
 * @authorAswathy
 *
 */
public class FileUtility {
	/**its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String getPropertyKeyValue(String key) throws Throwable {	
	FileInputStream fis=new FileInputStream("./data/commondata.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	String value=pObj.getProperty(key);
	return value;
}
}