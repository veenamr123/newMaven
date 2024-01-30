package com.ObjectRepo;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsertProductPage extends WebDriverUtils {
	
	//identify all elements using annotations (Declaration)
	@FindBy(name="category")
	private WebElement CategoryDD;
	
	@FindBy(xpath="//select[@name='subcategory']")
	private WebElement subCateDD;
	
	@FindBy(xpath="//input[@name='productimage1']")
	private WebElement proImage1;
	
	@FindBy(xpath="//input[@name='productimage2']")
	private WebElement proImage2;
	
	@FindBy(xpath="//input[@name='productimage3']")
	private WebElement proImage3;
	
	@FindBy(xpath="//select[@name='productAvailability']")
	private WebElement proAvilabilityDD;
	
	@FindBy(xpath="//button[.='Insert']")
	private WebElement insertBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement confirmMsg;
	
	//execute all elements & initialize
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//provide getters methods (Utilization)
	public WebElement getCategoryDD() {
		return CategoryDD;
	}

	public WebElement getSubCateDD() {
		return subCateDD;
	}

	public WebElement getProImage1() {
		return proImage1;
	}

	public WebElement getProImage2() {
		return proImage2;
	}

	public WebElement getProImage3() {
		return proImage3;
	}

	public WebElement getProAvilabilityDD() {
		return proAvilabilityDD;
	}

	public WebElement getInsertBtn() {
		return insertBtn;
	}
	
	
	public WebElement getConfirmMsg() {
		return confirmMsg;
	}
	
	public void createProduct(String cn,String scn,String stock,WebDriver driver,HashMap<String,String> map,String img)
	{
		
		dropDownText(CategoryDD,cn);
		dropDownText(subCateDD, scn);
		for(Entry<String, String> set:map.entrySet())
		{
		    driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		dropDownText(proAvilabilityDD,stock);
		proImage1.sendKeys(img);
		proImage2.sendKeys(img);
		proImage3.sendKeys(img);
		insertBtn.click();
		System.out.println(confirmMsg.getText());
	}
	
}
