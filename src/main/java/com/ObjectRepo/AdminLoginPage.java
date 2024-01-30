package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	//identify all elements using annotaions (Declaration)
	@FindBy(id="inputEmail")
	private WebElement adminUN;
	
	@FindBy(id="inputPassword")
	private WebElement adminPWD;
	
	@FindBy(name="submit")
    private WebElement adminLoginBtn;
	
	//execute all elements & initialize 
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//provide getters methods (Utilization)
	public WebElement getAdminUN() {
		return adminUN;
	}

	public WebElement getAdminPWD() {
		return adminPWD;
	}

	public WebElement getAdminLoginBtn() {
		return adminLoginBtn;
	}
	
	//business logic
	public void loginAsAdmin(String un,String pwd)
	{
		adminUN.sendKeys(un);
		adminPWD.sendKeys(pwd);
		adminLoginBtn.click();
	}
	
}
