package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {       
	
	@FindBy(xpath="(//div[@class='col-md-9']/descendant::div[@class='product-info text-left'])[1]")
    private WebElement searchedpro;
	
	@FindBy(xpath="//a[.='Continue Shopping']")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath="//h4[@class='cart-product-description']/preceding::input[@name='remove_code[]']")
	private WebElement removeChechBx;
	
	@FindBy(xpath="//button[.='PROCCED TO CHEKOUT']")
	private WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath="//input[@value='Update shopping cart']")
	private WebElement updateCartBtn;
	
	@FindBy(xpath="//input[@value='COD']")
	private WebElement codOption;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBtn;
	
	public MyCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCodOption() {
		return codOption;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public WebElement getSearchedpro() {
		return searchedpro;
	}

	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}

	public WebElement getRemoveChechBx() {
		return removeChechBx;
	}

	public WebElement getProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

	public WebElement getUpdateCartBtn() {
		return updateCartBtn;
	}
	
	//business logic
	public void placeOrder(WebDriver driver,String proName)
	{
		proceedToCheckoutBtn.click();
		codOption.click();
		submitBtn.click();
		String res = driver.findElement(By.xpath("(//h4[@class='cart-product-description'])[last()]")).getText();
		if(res.equalsIgnoreCase(proName))
	        System.out.println("order placed successfully");
		else
			System.out.println("product not placed");
	}
}
