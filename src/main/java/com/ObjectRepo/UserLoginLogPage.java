package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class UserLoginLogPage extends WebDriverUtils {
	
	@FindBy(xpath="//select[@name='DataTables_Table_0_length']")
	private WebElement showDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchEdt;
	
	@FindBy(xpath="(//td[contains(.,'bipin')]/../td[4])[last()]")
	public WebElement loginTime;
	
	public UserLoginLogPage(WebDriver driver)
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
	
	public void searchUser(String s)
	{
		searchEdt.sendKeys(s+Keys.BACK_SPACE);
	}
	
	public void userLoginDetails(WebDriver driver,String s)
	{
		String logintime = driver.findElement(By.xpath("(//td[contains(.,'s')]/../td[4])[last()]")).getText();
		//String s = loginTime.getText();
		System.out.println("user login time: "+ logintime );
	}

}
