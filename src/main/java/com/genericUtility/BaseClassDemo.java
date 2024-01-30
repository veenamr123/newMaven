package com.genericUtility;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClassDemo {
	public WebDriverUtils wlib = new WebDriverUtils();
	public WebDriver driver;
	@BeforeClass
	public void bc()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		wlib.maximize(driver);
		wlib.waitForPageLoad(driver, 10);
		driver.get("https://www.irctc.co.in/nget/train-search");
	}

}
