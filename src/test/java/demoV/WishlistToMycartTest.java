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

public class WishlistToMycartTest {
	public static void main(String[] args) throws IOException {
		
	
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String URL = pobj.getProperty("uurl");
	String UN = pobj.getProperty("uun");
	String PWD = pobj.getProperty("upwd");
	
	//fetch test data from excel file
	FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
	Workbook wb = WorkbookFactory.create(fin);
	Sheet shc = wb.getSheet("search");
	String searchPro = shc.getRow(0).getCell(0).getStringCellValue();
	String  proName= shc.getRow(0).getCell(1).getStringCellValue();
	 
	//launch the browser
			WebDriver driver=new ChromeDriver();
			
			//maximize the browser window
			driver.manage().window().maximize();
			
			//enter user url
			driver.get(URL);
			
			//wait for page load
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			//click on login link
			driver.findElement(By.xpath("//a[.='Login']")).click();
			
			//login to application
			driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
			driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
			driver.findElement(By.xpath("//button[.='Login']")).click();
			
			//search product
			driver.findElement(By .xpath("//input[@class='search-field']")).sendKeys(searchPro);
			driver.findElement(By.xpath("//button[@class='search-button']")).click();
			driver.findElement(By.xpath("//a[.='Apple iPhone 6 (Silver, 16 GB)']")).click();
			
			//add product to wishlist
			driver.findElement(By.xpath("//i[@class='icon fa fa-heart']")).click();
			
			//add product to my cart
			driver.findElement(By.xpath("//button[.='Add to cart']")).click();
			
			//click on my cart
			//driver.findElement(By.)
			
			
	
	
	
	
	
	}
	

}
