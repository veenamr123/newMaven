package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	//identify all elements using annotaions (Declaration)
	
	    @FindBy(xpath="//a[.='Login']")
	    private WebElement loginLink;
	    
		@FindBy(xpath="//input[@name='email']")
		private WebElement emailEdt;
		
		@FindBy(xpath="//input[@id='exampleInputPassword1']")
		private WebElement passwordEdt;
		
		@FindBy(xpath="//button[text()='Login']")
		private WebElement loginBtn;
		
		//execute all elements & initialize 
		public UserLoginPage(WebDriver driver)
	    {
		   PageFactory.initElements(driver,this);
	    }

		//getter methods(Utilization)
		public WebElement getLoginLink() {
			return loginLink;
		}

		public WebElement getEmailEdt() {
			return emailEdt;
		}

		public WebElement getPasswordEdt() {
		 return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//business logic
		public void loginAsUser(String un,String pwd)
		{
			loginLink.click();
			emailEdt.sendKeys(un);
			passwordEdt.sendKeys(pwd);
			loginBtn.click();
		}
}

