package com.crm.autodesk.genericutility;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * 
 * @author ownerAswathy
 * 
 */

public class ExcelUtility {

	/**used to read data from excel based below arguments
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable 
	 */
    public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {		
	FileInputStream fis=new FileInputStream("./data/testdata.xlsx");
    Workbook wb= WorkbookFactory.create(fis);
    Sheet sh=wb.getSheet(sheetName);
    Row row=sh.getRow(rowNum);
    String data= row.getCell(cellNum).getStringCellValue();
    wb.close();
	return data;
    }
    
	/**
	 * used last row on specified sheet
	 * @param 
	 * @throws Throwable 
	 * 
	 */
	
	
	  public int getRowCount(String sheetName) throws Throwable  {
		  FileInputStream fis = new FileInputStream("./data/testdata.xlsx");
		  Workbook wb = WorkbookFactory.create(fis);
		  return 0;
		  
	}
	
	    public void setDataExcel(String sheetName,int rowNum, int cellNum, String data) throws Throwable, IOException {
	    	FileInputStream fis=new FileInputStream("./data/testdata.xlsx");
	    	Workbook wb=WorkbookFactory.create(fis);
	    	Sheet sh=wb.getSheet(sheetName);
	    	Row row=sh.getRow(rowNum);
	    	Cell cell=row.createCell(cellNum);
	    	cell.setCellValue(data);
	    	FileOutputStream fos=new FileOutputStream("./data/testdata.xlsx");
	    	wb.write(fos);
	    	wb.close();	
	    }
	 
	    
	    
	    
	    
	    
    }
    

