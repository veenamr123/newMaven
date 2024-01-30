package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	
	@FindBy(xpath="//input[@class='search-field']")
	private WebElement searchBar;
	
	@FindBy(xpath="//button[@class='search-button']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[.='My Account']")
	private WebElement myAccLink;
	
	@FindBy(xpath="//a[.='Order History']")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath="//a[.='Wishlist']")
	private WebElement WishListLink;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[.='My Cart']")
	private WebElement myCartLink;
	
	@FindBy(xpath="//li[@class='active']")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//i[@class='fa fa-heart']")
	private WebElement wishBtn;
	
	@FindBy(xpath="//a[.='Add to cart']")
	private WebElement addTocartbtn;
	
	public UserHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getMyAccLink() {
		return myAccLink;
	}

	public WebElement getOrderHistoryLink() {
		return orderHistoryLink;
	}

	public WebElement getWishListLink() {
		return WishListLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}
	
   public WebElement getSearchBtn() {
		return searchBtn;
	}
   
   public WebElement getShoppingCart() {
		return shoppingCart;
	}
   
   public WebElement getWishBtn() {
		return wishBtn;
	}

	public WebElement getAddTocartbtn() {
		return addTocartbtn;
	}
	
	//business logic
	public void searchProduct(String proName)
	{
		searchBar.sendKeys(proName);
		searchBtn.click();
	}
	
	public void addProductToWishlist(WebDriver driver,String pro_name )
	{
		driver.findElement(By.xpath("//a[.='"+pro_name+"']")).click();
		wishBtn.click();
		addTocartbtn.click();
	}
	
	public void orderHistoryDisplay()
	{
		String res = shoppingCart.getText();
  	
  	if(res.equalsIgnoreCase("Shopping Cart")) 
  		System.out.println("order history page displayed");
  	else
  		System.out.println("order history page not displayed");
	}
	
	public void logoutUser()
	{
		logoutLink.click();
	}
}
