package demoV;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MycartTest {

	public static void main(String[] args) throws IOException {
		// get common data from property file
				FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commondata.properties");
				Properties p = new Properties();
				p.load(fis);
				String UURL = p.getProperty("uurl");
				String UUSERNAME = p.getProperty("uun");
			    String UPASSWORD = p.getProperty("upwd");
			    
			    //get Test data from excel file
			  	FileInputStream f= new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
			  	Workbook wb= WorkbookFactory.create(f);
				org.apache.poi.ss.usermodel.Sheet sc1 = wb.getSheet("search");
			  	String searchPro = sc1.getRow(0).getCell(0).getStringCellValue();
			  	String pro_name = sc1.getRow(0).getCell(1).getStringCellValue();
			    
			    //launch browser
			    WebDriver driver = new ChromeDriver();
			 
			    //maximize the browser
			  	driver.manage().window().maximize();
			  		
			  	//enter url
			  	driver.get(UURL);
			  	
			  	//wait page load statement
			  	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			  	
			  	//login to application
			  	driver.findElement(By.xpath("//a[.='Login']")).click();
			 	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(UUSERNAME);
			  	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(UPASSWORD);
			  	driver.findElement(By.name("login")).click();
			  	
			  	//search product
			  	driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(searchPro);
			  	driver.findElement(By.xpath("//button[@class='search-button']")).click();
			  	driver.findElement(By.xpath("//a[.='"+pro_name+"']")).click();
			                                 
			  	//add product to wish list by clicking wishlist symbol
			  	driver.findElement(By.xpath("//i[@class='fa fa-heart']")).click();
			  	
			  	//add product to my cart by clicking add to cart
			  	driver.findElement(By.xpath("//a[.='Add to cart']")).click();
			  	
			  	//click on my cart link
			  	driver.findElement(By.xpath("//i[@class='icon fa fa-shopping-cart']/..")).click();
			  	
			  	//click on update  shopping cart 
			  	driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
			  	
			  	//handle alert popup
			  	driver.switchTo().alert().accept();
			  	
			  	String res = driver.findElement(By.xpath("//h4[@class='cart-product-description']/a[.='"+pro_name+"']")).getText();
			  	System.out.println(res);
			  	//System.out.println(pro_name);
			  	if(res.equalsIgnoreCase(pro_name))
			  	{
			  		System.out.println("product added to my cart successfully");
			  	}
			  	else 
			  	{
			  		System.out.println("product not added to my cart");
			  	}
			  	
			  	//click on proceed to checkout
			  	driver.findElement(By.xpath("//button[.='PROCCED TO CHEKOUT']")).click();
			  	
			  	//click on cod radio button
			  	driver.findElement(By.xpath("//input[@value='COD']")).click();
			  	
				//click on submit button
				driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
			  	
			  	//close driver
			  	driver.quit();

	}

}
