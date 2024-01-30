package com.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplenClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		//Testscript execution starts here
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+" Execution started ", true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" Passed ");
		Reporter.log(methodName+" Executed successfully ", true);
	}


	@Override
	public void onTestFailure(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		try {
			String path = WebDriverUtils.getScreenShot(BaseClass.sdriver,methodName);
			
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL, methodName+" Failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(methodName+" -->Failed", true);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+" -->Skipped", true);
	}

	@Override
	public void onStart(ITestContext context)
	{
		//configure report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\extentReport\\report.html");
		htmlreport.config().setDocumentTitle("Online-Shopping");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Zeel-Shopee");
		
	    report=new ExtentReports();
	    report.attachReporter(htmlreport);
	    report.setSystemInfo("Base Platform", "OS");
	    report.setSystemInfo("Base Browser", "chrome");		
	    report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
	    report.setSystemInfo("Reporter name", "Veena");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
	
	

}
