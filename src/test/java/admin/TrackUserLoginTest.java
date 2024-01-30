package admin;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.AdminHomePage;
import com.ObjectRepo.AdminLoginPage;
import com.ObjectRepo.MyCartPage;
import com.ObjectRepo.OrderHistoryPage;
import com.ObjectRepo.PendingOrdersPage;
import com.ObjectRepo.UserHomePage;
import com.ObjectRepo.UserLoginLogPage;
import com.ObjectRepo.UserLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

//@Listeners(com.genericUtility.ListenerImplenClass.class)
public class TrackUserLoginTest {
	@Test(groups="regression")
public void trackUserLoginTest() throws IOException, InterruptedException {
			
			FileUtils fLib = new FileUtils();
			ExcelUtils eLib = new ExcelUtils();
			WebDriverUtils wLib = new WebDriverUtils();
			
			//Get common data from property file
			String URL = fLib.readData("url");
			String USERNAME = fLib.readData("un");
			String PASSWORD = fLib.readData("pwd");
			String UURL = fLib.readData("uurl");
		    String NUSERNAME = fLib.readData("un1");
		    String NPASSWORD = fLib.readData("pwd1");
		    //get Test data from excel file
		    String searchPro = eLib.readDataFromExcel("search", 0, 0);
		    String pro_name = eLib.readDataFromExcel("search", 0, 1);
		    
		    //launch browser
		    WebDriver driver = new ChromeDriver();
		 
		    //maximize the browser
		  	wLib.maximize(driver);
		 
		  	//enter User url
		  	driver.get(UURL);
		  	
		  	//wait page load statement
		    wLib.waitForPageLoad(driver, 20);
		  	
		  	//login to application as new user
		    UserLoginPage ulp=new UserLoginPage(driver);
			ulp.loginAsUser(NUSERNAME, NPASSWORD);
		   
		    //search product
			UserHomePage uhp=new UserHomePage(driver);
			uhp.searchProduct(searchPro);
			uhp.addProductToWishlist(driver, pro_name);
			uhp.getMyCartLink().click();
			
			//place order by choosing cod
			MyCartPage mcp=new MyCartPage(driver);
			mcp.placeOrder(driver,pro_name);
			
			//click on myaccounts and orderHistory of user
			uhp.getMyAccLink().click();
			uhp.getOrderHistoryLink().click();
			
            //fetch orderId of recent order
			OrderHistoryPage ohp= new OrderHistoryPage(driver);
			String orderNum = ohp.fetchOrderID(driver);
			
			//logout as user
			uhp.logoutUser();
			
		  	//open new tab
			wLib.openNewTab(driver);
		  	//driver.switchTo().newWindow(WindowType.TAB);
		  	
		  	//enter admin url
		  	driver.get(URL);
		  	
			//login to application as admin
		  	AdminLoginPage alp=new AdminLoginPage(driver);
		  	alp.loginAsAdmin(USERNAME, PASSWORD);
			
			//track user placed order in pending order
		  	AdminHomePage ahp=new AdminHomePage(driver);
		  	ahp.getOrderManagementLink().click();
		  	ahp.getPendingOrdersLink().click();
		  	
		  	//fetch orderID of last order from user
		  	PendingOrdersPage pop=new PendingOrdersPage(driver);
		  	pop.showEntries();
		  	pop.searchProduct(NUSERNAME);
		  	String aOrderNum=pop.getLastOrderNum(driver, NUSERNAME);
		  	
		  	if(aOrderNum.equals(orderNum))
		  			System.out.println("user order is displayed in admin's pending orders, order number is: "+orderNum);
		  	else 
				System.out.println("order not placed");
			
			//click on user login log link
		  	ahp.getUserLoginLogLink().click();
		  	UserLoginLogPage up=new UserLoginLogPage(driver);
		  	up.showEntries();
		  	up.searchUser(NUSERNAME);
		  	up.userLoginDetails(driver,NUSERNAME);
		  	
		    //logout application
		    ahp.logoutAdmin();
		    driver.quit();
		}
	}


