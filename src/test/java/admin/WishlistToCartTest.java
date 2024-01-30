package admin;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.MyCartPage;
import com.ObjectRepo.UserHomePage;
import com.ObjectRepo.UserLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;
//@Listeners(com.genericUtility.ListenerImplenClass.class)
public class WishlistToCartTest {

	@Test(groups="regression")
	public void wishlistToCartTest() throws IOException {
		
		FileUtils fLib = new FileUtils();
	    ExcelUtils eLib = new ExcelUtils();
	    WebDriverUtils wLib = new WebDriverUtils();
		
		// get common data from property file
		String UURL = fLib.readData("uurl");
	    String UUSERNAME = fLib.readData("uun");
		String UPASSWORD = fLib.readData("upwd");
			    
			    //get Test data from excel file
			    String searchPro = eLib.readDataFromExcel("search", 0, 0);
			    String pro_name = eLib.readDataFromExcel("search", 0, 1);
			  	
			    //launch browser
			    WebDriver driver = new ChromeDriver();
			 
			    //maximize the browser
			    wLib.maximize(driver);
			    
			  	//enter url
			  	driver.get(UURL);
			  	
			  	//wait page load statement
			  	wLib.waitForPageLoad(driver, 10);
			  	
			  	//login to application
			  	UserLoginPage ulp=new UserLoginPage(driver);
				ulp.loginAsUser(UUSERNAME, UPASSWORD);
			  	
			  	//search product, add it to wishlist, click on add to cart
				UserHomePage uhp=new UserHomePage(driver);
				uhp.searchProduct(searchPro);
				uhp.addProductToWishlist(driver, pro_name);
				uhp.getMyCartLink().click();
				
				//place order by choosing cod
				MyCartPage mcp=new MyCartPage(driver);
				mcp.placeOrder(driver,pro_name);
	
				//logout
				uhp.logoutUser();
				driver.quit();
	}
}
