package PracticePackage;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataIntoPropertyfileTest {

	public static void main(String[] args) throws IOException {
		/* 
		*Properties pobj = new Properties();
       * pobj.setProperty("browser", "chrome");
        *pobj.setProperty("url","http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
       * pobj.setProperty("un", "admin");
       * pobj.setProperty("pwd", "Test@123");
       * FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\commondata.properties");
       * pobj.store(fos, "write data");
        */
        
      FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
      Properties pobj = new Properties();
      pobj.load(fis);
      String browser = pobj.getProperty("browser");
      String url = pobj.getProperty("url");
      String un = pobj.getProperty("un");
      String pwd = pobj.getProperty("pwd");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	  driver.get(url);
	  driver.findElement(By.id("inputEmail")).sendKeys(un);
	  driver.findElement(By.id("inputPassword")).sendKeys(pwd);
	  driver.findElement(By.xpath("//button[.='Login']")).click();
	  
	}

}
