package PracticePackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelNokiaTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		int rowcount = sh.getLastRowNum();
		int cellcount = sh.getRow(0).getLastCellNum();
		
		for(int i=0;i<=rowcount;i++)
		{
			String res = sh.getRow(i).getCell(0).getStringCellValue();
			if(res.equals("nokia")) {
				double fres = sh.getRow(i).getCell(1).getNumericCellValue();
				System.out.println(res+"--->");
				System.out.println(fres);
				
			}
			
		}
	}

}
