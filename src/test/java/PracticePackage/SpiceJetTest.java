package PracticePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJetTest {

   public static void main(String[] args)
   {
	   //to handle notifications
	   ChromeOptions opt=new ChromeOptions();
	   opt.addArguments("--disable-notifications");
	   
	   //launch browser
	   WebDriver driver=new ChromeDriver(opt);
	  
	   // enter URL
	   driver.get("https://www.spicejet.com/");
	   
	   //maximize the window
	   driver.manage().window().maximize();
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	   
	   //select round trip radio button
	   driver.findElement(By.xpath("//div[.='round trip']")).click();
	   
	   //enter from destination in textbox
	   WebElement ele = driver.findElement(By.xpath("//div[text()='From']"));
	   ele.click();
	   driver.switchTo().activeElement().sendKeys("del");
	   
	   //enter to destination in textbox
	   driver.findElement(By.xpath("//div[.='To']")).sendKeys("blr");
	   //driver.findElement(By.xpath("//div[.='Departure Date']")).click();
	   
	}

 //div[text()='"+monthyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+day+"']
}
