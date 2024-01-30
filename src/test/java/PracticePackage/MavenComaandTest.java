package PracticePackage;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MavenComaandTest {

	  @Test
	  public void mavenCommandTest()
	  {
		  System.out.println("--test-1--");
		  
	  }
	  @Test
	  public void displayTest()
	  {
	   System.out.println("--display--");
	  
	  }
	  
	  @Test
	  public void writeTest()
	  {
		  System.out.println("--write--");
	  }
	  
	  @Test
	  public void readTest()
	  {
		  String Browser = System.getProperty("browser");
		  String URL = System.getProperty("url");
		  String UN = System.getProperty("username");
		  String PWD = System.getProperty("password");
		  
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get(URL);
			
			driver.findElement(By.id("inputEmail")).sendKeys(UN);
			driver.findElement(By.id("inputPassword")).sendKeys(PWD);
			driver.findElement(By.xpath("//button[.='Login']")).click();
	  }
	  
	  
 }

	


