package demoV;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrackUserLoginTest {

	public static void main(String[] args) throws IOException {
		
	//fetch common data from property file
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
				Properties pobj = new Properties();
				pobj.load(fis);
				String URL = pobj.getProperty("uurl");
				String UN = pobj.getProperty("un1");
				String PWD = pobj.getProperty("pwd1");
				
				//fetch test data from excel file
				FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
				Workbook wb = WorkbookFactory.create(fin);
				Sheet shc = wb.getSheet("search");
				//String searchPro = sc1.getRow(0).getCell(0).getStringCellValue();
			  	//String pro_name = sc1.getRow(0).getCell(1).getStringCellValue();
				
				//launch the browser
				WebDriver driver=new ChromeDriver();
				
				//maximize the browser window
				driver.manage().window().maximize();
				
				//enter url
				driver.get(URL);
				
				//wait for page load
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
				
				//login to application
			  	driver.findElement(By.xpath("//a[.='Login']")).click();
			 	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(UN);
			  	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(PWD);
			  	driver.findElement(By.name("login")).click();
				
				

	}

}
