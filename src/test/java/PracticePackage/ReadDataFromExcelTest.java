package PracticePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws IOException  {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet2");
        int rowcount = sh.getLastRowNum();
        int lastcell = sh.getRow(0).getLastCellNum();
        for(int i=0;i<=rowcount;i++)
        {
        	for(int j=0;j<lastcell;j++)
        	{
        		String org = sh.getRow(i).getCell(j).getStringCellValue();
        		System.out.print(org+" ");
        	}
        	System.out.println();
        }
	}

}
