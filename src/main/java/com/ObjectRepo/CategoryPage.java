package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	//identify all elements using annotations (Declaration)
			@FindBy(name="category")
			private WebElement categoryEdt;
			
			@FindBy(name="description")
			private WebElement discriptionEdt;
			
			@FindBy(xpath="//button[.='Create']")
			private WebElement catCreateBtn;
			
			@FindBy(xpath="//div[@class='alert alert-success']")
			private WebElement catConfirmMsg;
			
			//execute all elements & initialization
			public CategoryPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//provide getters methods (Utilization)
			public WebElement getcatConfirmMsg() {
				return catConfirmMsg;
			}
			
			
			public WebElement getCategoryEdt() {
				return categoryEdt;
			}

			public WebElement getDiscriptionEdt() {
				return discriptionEdt;
			}

			public WebElement getCatCreateBtn() {
				return catCreateBtn;
			}
			
			//business logic
			public void createCategory(String catName,String discription)
			{
				categoryEdt.sendKeys(catName);
				discriptionEdt.sendKeys(discription);
				catCreateBtn.click();
				System.out.println(catConfirmMsg.getText());
			}
			
}
