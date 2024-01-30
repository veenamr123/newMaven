package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.AdminHomePage;
import com.ObjectRepo.AdminLoginPage;

public class BaseClass {
	
	public DataBaseUtils dLib=new DataBaseUtils();
	public FileUtils fLib=new FileUtils();
	public ExcelUtils eLib=new ExcelUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public JavaUtils jLib=new JavaUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void config_bs() throws SQLException
	{
		dLib.ConnectToDb();
		Reporter.log("---connect to db----",true);
	}
	
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void config_bc(String BROWSER) throws IOException
	{
		//String BROWSER = fLib.readData("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser");}
		
		sdriver=driver;
		wLib.maximize(driver);
		String Url = fLib.readData("url");
		driver.get(Url);
		wLib.waitForPageLoad(driver, 10);
		Reporter.log("---launched browser----",true);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void config_bm() throws Exception
	{
		 String UN = fLib.readData("un");
		 String PWD = fLib.readData("pwd");
		 AdminLoginPage alp=new AdminLoginPage(driver);
		 alp.loginAsAdmin(UN, PWD);
		 Reporter.log("---login to app----",true);
	}
	
	 @AfterMethod(alwaysRun = true)
	public void config_am()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.logoutAdmin();
		Reporter.log("----logout from app---",true);
	}
	
	@AfterClass(alwaysRun = true)
	public void config_ac()
	{
		driver.quit();
		Reporter.log("---close the browser---",true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_as() throws SQLException
	{
		dLib.closeDb();
		Reporter.log("---db disconnected---",true);
	}
}
