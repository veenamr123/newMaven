package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.ObjectRepo.IrctcPage;
import com.genericUtility.WebDriverUtils;

public class DemoIrctcTest {
	WebDriverUtils wlib = new WebDriverUtils();
	@Test
	public void irctcTest() throws InterruptedException
	{
		int date=27;
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		wlib.maximize(driver);
		wlib.waitForPageLoad(driver, 50);//https://www.irctc.co.in/
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[.=' BUSES ']")).click();
		wlib.switchToWindow(driver, "IRCTC Bus");
		Thread.sleep(5000);
		driver.findElement(By.id("departFrom")).sendKeys("bangalore");
		WebElement de = driver.findElement(By.xpath("//div[.='Bangalore']"));
		wlib.mousehover(driver, de);
		//driver.findElement(By.xpath("//div[.='Bangalore']")).click();
		driver.findElement(By.id("goingTo")).sendKeys("goa");
		driver.findElement(By.xpath("//div[.='Goa']")).click();
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[.='"+date+"']")).click();
		driver.findElement(By.xpath("//button[.='Search Bus ']")).click();
		//label[.='After 6 pm'])[1]
		
		
		
		
	/*	IrctcPage ip=new IrctcPage(driver);
		ip.buseslnk.click();
		wlib.switchToWindow(driver,"IRCTC bus-Online " );
		ip.departEdt.click();   */
		
		
	}

}
