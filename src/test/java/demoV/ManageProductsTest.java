package demoV;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
//import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

@Listeners(com.genericUtility.ListenerImplenClass.class)
public class ManageProductsTest {

	public static void main(String[] args) throws IOException {
		
		//Random ran = new Random();
		//int random = ran.nextInt(100);
		
		//fetch common data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String UN = pobj.getProperty("un");
		String PWD = pobj.getProperty("pwd");
		
		//fetch test data from excel file
		FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fin);
		Sheet shc = wb.getSheet("category");
		Sheet shi = wb.getSheet("insertproduct");
		String catname = shc.getRow(0).getCell(1).getStringCellValue();
		String desc = shc.getRow(1).getCell(1).getStringCellValue();
		String subcatname = shc.getRow(2).getCell(1).getStringCellValue();
		
		//launch the browser
		WebDriver driver=new ChromeDriver();
		
		//maximize the browser window
		driver.manage().window().maximize();
		
		//enter url
		driver.get(URL);
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//login to application
		driver.findElement(By.id("inputEmail")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[.='Login']")).click();
		
		//click on category
		driver.findElement(By.xpath("//a[.=' Create Category ']")).click();
		
		//enter category name,description and save
		driver.findElement(By.name("category")).sendKeys(catname);
		driver.findElement(By.name("description")).sendKeys(desc);
		driver.findElement(By.xpath("//button[.='Create']")).click();
		String str1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(str1);
		
		//enter sub-category 
		driver.findElement(By.xpath("//a[.='Sub Category ']")).click();
		
		//enter category name,sub-category name and save
				WebElement catele = driver.findElement(By.name("category"));
				Select s1 = new Select(catele);
				s1.selectByVisibleText(catname);
				
				driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys(subcatname);
				
				driver.findElement(By.xpath("//button[.='Create']")).click();
				String str2 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
				System.out.println(str2);
				
	    //click on insert product
				driver.findElement(By.xpath("//a[.='Insert Product ']")).click();
		
		//select category and sub-category		
				WebElement cele = driver.findElement(By.name("category"));
				Select s2 = new Select(cele);
				s2.selectByVisibleText(catname);
				
				WebElement scele = driver.findElement(By.xpath("//select[@name='subcategory']"));
				Select s3 = new Select(scele);
				s3.selectByVisibleText(subcatname);
				
		//enter all text fields of insert product page
				HashMap<String, String> map = new HashMap<String,String>();
				int rowcount = shi.getLastRowNum();
				
				for(int i=0;i<=rowcount;i++)
				{
					String key = shi.getRow(i).getCell(0).getStringCellValue();
					String value = shi.getRow(i).getCell(1).getStringCellValue();
					map.put(key, value);
				}
				
				for(Entry<String, String> set:map.entrySet())
				{
				    driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
				
				WebElement ele1 = driver.findElement(By.xpath("//select[@name='productAvailability']"));
				Select s4 = new Select(ele1);
				s4.selectByVisibleText("In Stock");
				
				driver.findElement(By.xpath("//input[@name='productimage1']")).sendKeys("C:\\Users\\RAGHAVENDRA\\eclipse-workspace\\MavenProject\\src\\test\\java\\admin\\ManageProductsTest.java");
				driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys("C:\\Users\\RAGHAVENDRA\\eclipse-workspace\\MavenProject\\src\\test\\java\\admin\\ManageProductsTest.java");
				driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\Users\\RAGHAVENDRA\\eclipse-workspace\\MavenProject\\src\\test\\java\\admin\\ManageProductsTest.java");
				driver.findElement(By.xpath("//button[.='Insert']")).click();
				String str3 = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();
				System.out.println(str3);
				
				//click on manage products
				driver.findElement(By.xpath("//a[.='Manage Products ']")).click();
				
				//search for a random product 
				driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys("daiken");
				driver.findElement(By.xpath("//td[.='daiken']/../td[@class=' ']//i[@class='icon-remove-sign']")).click();
				
				//handle alert popup
				driver.switchTo().alert().accept();
				
				//print confirmation message of product removed
				String str5 = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
				System.out.println(str5);
				
				//logout as admin
				driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
				driver.findElement(By.xpath("//a[.='Logout']")).click();
	}

}
