package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	/**
	 * This method is used to read data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to write data into excel
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet,int row,int cell,String data) throws IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheet);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fo = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fo);
		wb.close();
	} 
	
	/**
	 * This method is used to map data by fetching it from concurrent columns of excel
	 * @param sheet
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> hashMapData(String sheet,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheet);
		int lastRow = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String,String>();   //empty
		
		for(int i=0;i<=lastRow;i++)
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * This method is used to find the row count
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNo(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
	
	public Object[][] readMultipleSetOfData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet s = wb.getSheet(sheetName);
		int lastRow = s.getLastRowNum()+1;     //s.getPhysicalNumberOfRows()
		int lastcel = s.getRow(0).getLastCellNum();
		
		Object[][] o = new Object[lastRow][lastcel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastcel;j++)
			{
				o[i][j]=s.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return o;
	}

}
