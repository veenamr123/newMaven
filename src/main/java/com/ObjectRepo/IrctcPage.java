package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IrctcPage {
	@FindBy(xpath="//a[.=' BUSES ']")//a[.=' BUSES ']
	public WebElement buseslnk;
	
	@FindBy(id="loginuserid")    //input[@id='loginuserid']
	public WebElement departEdt;
	
	
	public IrctcPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

}
