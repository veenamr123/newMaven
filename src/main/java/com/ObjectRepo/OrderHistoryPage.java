package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class OrderHistoryPage extends WebDriverUtils {
	
	@FindBy(xpath="(//h4[@class='cart-product-description']/following::a[contains(.,'Track')])[last()]")
	private WebElement trackLink;
	
	@FindBy(xpath="//td[@class='fontkink']")
	private WebElement orderID;
	
	public OrderHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTrackLink() {
		return trackLink;
	}

	public WebElement getOrderID() {
		return orderID;
	}

	//fetch orderID from order tracking details page
	public String fetchOrderID(WebDriver driver)
	{
		trackLink.click();
		switchToWindow(driver, "Order Tracking Details");
		String id = orderID.getText();
		switchToWindow(driver, "Order History");
		return id;
	}
    
}
