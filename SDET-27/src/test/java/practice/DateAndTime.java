package practice;

import java.util.Date;

public class DateAndTime {

	public static void main(String[] args) {
		//public int getSystemDateWithFormat(); 
		
			Date date=new Date();
			String dateAndTime=date.toString();
			System.out.println(dateAndTime);
			String YYYY= dateAndTime.split(" ")[5];
			String DD=dateAndTime.split(" ")[2];
			int MM=date.getMonth()+1;
		    String finalFormat=YYYY+"-"+MM+"-"+DD;
		    System.out.println(finalFormat);
		}

	}

	