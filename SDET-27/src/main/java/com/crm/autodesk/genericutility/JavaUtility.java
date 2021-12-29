package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @authorAswathy
 *
 */
public class JavaUtility {

	/**
	 * its used to generate random number
	 * @return
	 */
	public int getRandomNumber() {
		Random random=new Random();
		int Random=random.nextInt(10000);
		return Random;	
		
	}
	/**
	 * used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
	}
	/**
	 * used to get system format in YYYY-MM-DD format
	 * @return
	 */
	
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String dateAndTime=date.toString();
		
		String YYYY= dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
	    String finalFormat=YYYY+"-"+MM+"-"+DD;
	    return finalFormat;
	}
	
}
