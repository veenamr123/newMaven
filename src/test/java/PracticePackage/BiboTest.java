package PracticePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BiboTest {

	public static void main(String[] args) throws InterruptedException {
		String monthyear = "January 2024";
		String rmonyear = "May 2024";
		int day=5;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		//Thread.sleep(5000);
		for(;;) {
		try {	
		
		driver.findElement(By.xpath("//div[text()='"+monthyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+day+"']")).click();
		break;
		}catch(Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
		}
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//a[.='Done']")).click();
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		for(;;) {
			try {
		driver.findElement(By.xpath("//div[.='"+rmonyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+day+"']")).click();
		break;
		}catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
	}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
	}
}
	


