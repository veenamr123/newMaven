package com.TestNG;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.genericUtility.ExcelUtils;

public class DataProviderTest {
	
	@Test(dataProvider = "data")
	public void displayTest(String src,String dest)
	{
		System.out.println(src+"-->"+dest);
	}
	
	@Test(dataProvider="productName")
	public void productTest(String pro,int price)
	{
		System.out.println(pro+"-->"+price);
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object [][] obj= new Object[3][2];
		
		obj[0][0]="banglore";
		obj[0][1]="pune";
		
		obj[1][0]="hyd";
		obj[1][1]="chennai";
		
		obj[2][0]="mysore";
		obj[2][1]="delhi";
		
		return obj;
	}
	
	@DataProvider
	public Object[][] login()
	{
		Object[][] o = new Object[2][2];
		o[0][0]="admin";
		o[0][1]="Test@123";
		o[1][0]="bipin";
		o[1][1]="Test@123";
		return o;
				
	}
	
	@DataProvider
	public Object[][] readExcelData() throws EncryptedDocumentException, IOException 
	{
		ExcelUtils eLib=new ExcelUtils();
		Object[][] o = eLib.readMultipleSetOfData("insertproduct");
		return o;
	}
	
	@DataProvider
	public Object[][] productName()
	{
		Object[][] o=new Object[3][2];
		
		o[0][0]="nokia";
		o[0][1]=5000;
		
		o[1][0]="mi";
		o[1][1]=3000;
		
		o[2][0]="oneplus";
		o[2][1]=4000;
		
		return o;
		
	}

}
