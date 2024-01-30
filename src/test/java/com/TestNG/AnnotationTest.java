package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest {
	
	@BeforeSuite
	public void dbConnection()
	{
		System.out.println("db connection");
	}
	
	@BeforeTest
	public void browserlaunch()
	{
		System.out.println("launch browser in parallel execution");
	}
	
	@AfterSuite
	public void dbDisconnect()
	{
		System.out.println("db disconnected");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("close browser in sequential execution");
	}
	
	@BeforeMethod
	public void loginToApp()
	{
		System.out.println("login to the application");
	}
	
	@AfterMethod
	public void logoutApp()
	{
		System.out.println("logout of the application");
	}
	
	@Test(groups="regression")
	public void runnTest()
	{
		System.out.println("test script-1 execution");
	}
	
	@Test(groups="smoke")
	public void demoTest()
	{
		System.out.println("test script-2 execution");
	}
	
	@AfterSuite
	public void dbClose()
	{
		System.out.println("close db connection");
	}

}
