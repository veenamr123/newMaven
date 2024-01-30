package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	//identify all elements using annotaions (Declaration)
		@FindBy(xpath="//i[@class='icon-chevron-down pull-right']")
		private WebElement orderManagementLink;
		
		@FindBy(xpath="//a[@href='pending-orders.php']/..")
		private WebElement pendingOrdersLink;
		
		@FindBy(xpath="//a[.=' Create Category ']")
		private WebElement createCategoryLink;
		
		@FindBy(xpath="//a[.='Sub Category ']")
        private WebElement subCategoryLink;
		
		@FindBy(xpath="//a[.='Insert Product ']")
		private WebElement insertProductLink;
		
		@FindBy(xpath="//a[.='Manage Products ']")
		private WebElement manageProductsLink;
		
		@FindBy(xpath="//a[.='User Login Log ']")
		private WebElement userLoginLogLink;
		
		@FindBy(xpath="//a[@class='dropdown-toggle']")
		private WebElement logoutDropdown;
		
		@FindBy(xpath="//a[.='Logout']")
		private WebElement logoutBtn;
		
		//execute all elements & initialize
		public AdminHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		//provide getters methods (Utilization)
		public WebElement getOrderManagementLink() {
			return orderManagementLink;
		}

		public WebElement getPendingOrdersLink() {
			return pendingOrdersLink;
		}

		public WebElement getCreateCategoryLink() {
			return createCategoryLink;
		}

		public WebElement getSubCategoryLink() {
			return subCategoryLink;
		}

		public WebElement getInsertProductLink() {
			return insertProductLink;
		}

		public WebElement getManageProductsLink() {
			return manageProductsLink;
		}

		public WebElement getUserLoginLogLink() {
			return userLoginLogLink;
		}

		public WebElement getLogoutDropdown() {
			return logoutDropdown;
		}

		public WebElement getLogoutBtn() {
			return logoutBtn;
		}
		
		//business logic
		public void logoutAdmin()
		{
			logoutDropdown.click();
			logoutBtn.click();
		}
		
}
