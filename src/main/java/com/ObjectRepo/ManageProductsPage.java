package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class ManageProductsPage extends WebDriverUtils {
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//h3[.='Manage Products']")
	private WebElement pageDisplayed;
	
	@FindBy(xpath="//td[.='daiken']/../td[@class=' ']//i[@class='icon-remove-sign']")
    private WebElement removeBtn;
	
	@FindBy(xpath="//div[@class='alert alert-error']")
	private WebElement deletedMsg;
	
	public ManageProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	
	public WebElement getpageDisplayed() {
		return pageDisplayed;
	}
	
	public WebElement getConfirmMsg() {
		return deletedMsg;
	}
	
	//business logic
	public void removeProduct(WebDriver driver,String catName)
	{
		searchEdt.sendKeys(catName);
		removeBtn.click();
		acceptAlert(driver);
		System.out.println(deletedMsg.getText());
	}
	
	public void manageProductPage()
	{
		String result = pageDisplayed.getText();
		if(result.contains("Manage Products")) 
			System.out.println("page displayed properly");
		else 
			System.out.println("page not loaded properly");
	}
}
