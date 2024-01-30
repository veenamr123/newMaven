package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class PendingOrdersPage extends WebDriverUtils{
	
	@FindBy(xpath="//select[@name='DataTables_Table_0_length']")
	private WebElement showDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//input[@name='Submit2']")//input[@name='Submit2']
	public WebElement closeWindow;
	
	public PendingOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    public WebElement getShowDD() {
		return showDD;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	//business logic
	public void showEntries()
	{
		dropDownText(showDD, "100");
	}
	
	public void searchProduct(String s)
	{
		searchEdt.sendKeys(s);
	}
	
	public String getLastOrderNum(WebDriver driver,String user)
	{
		driver.findElement(By.xpath("(//td[contains(text(),'"+user+"')]/..//i[@class='icon-edit'])[last()]")).click();
		switchToWindow(driver, "update compliant");
		String s = driver.findElement(By.xpath("//b[.='order Id:']/../../td[@class='fontkink']")).getText();
		closeWindow.click();
		switchToWindow(driver, "Order History");
		return s;
	}
	
}
