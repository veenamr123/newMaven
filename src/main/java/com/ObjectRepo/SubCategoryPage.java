package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.genericUtility.WebDriverUtils;

public class SubCategoryPage extends WebDriverUtils{
	
	//identify all elements using annotations (Declaration)
	@FindBy(name="category")
	private WebElement categoryDropdown;
	
	@FindBy(xpath="//input[@name='subcategory']")
	private WebElement subCategoryEdt;
	
	@FindBy(xpath="//button[.='Create']")
	private WebElement createSubCatBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement subCatConfirmMsg;
	
	//execute all elements & initialize
	public SubCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//provide getters methods (Utilization)
	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public WebElement getSubCategoryEdt() {
		return subCategoryEdt;
	}

	public WebElement getCreateSubCatBtn() {
		return createSubCatBtn;
	}
	
	public WebElement getSubCatConfirmMsg()
	{
		return subCatConfirmMsg;
	}

	//business logic
	public void createSubCategory(String catname,String subcatName)
	{
		dropDownText(categoryDropdown, catname);
		subCategoryEdt.sendKeys(subcatName);
		createSubCatBtn.click();
		System.out.println(subCatConfirmMsg .getText());
	}
	
}
