package com.TestNG;

import org.testng.annotations.Test;

public class DdtWithDataProviderTest {
	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider="readExcelData")
	public void readFromExcel(String path,String value)
	{
		System.out.println(path+"--->"+value);
	}

}
