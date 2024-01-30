package demoV;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ObjectRepo.UserHomePage;
import com.ObjectRepo.UserLoginPage;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

@Listeners(com.genericUtility.ListenerImplenClass.class)

public class AssertTest {
	
	@Test(groups="smoke")
	public void orderHistoryTest() throws IOException {
		
		FileUtils fLib = new FileUtils();
	    WebDriverUtils wLib = new WebDriverUtils();
		
	    // get common data from property file
				String UURL = fLib.readData("uurl");
				String UUSERNAME = fLib.readData("uun");
			    String UPASSWORD = fLib.readData("upwd");
					    
				//launch browser
			    WebDriver driver = new ChromeDriver();
					 
				//maximize the browser
			    wLib.maximize(driver);
					  		
				//enter url
				driver.get(UURL);
					  	
				//wait pageload statement
				wLib.waitForPageLoad(driver, 10);;
					  	
			  	//login to application
				UserLoginPage ulp=new UserLoginPage(driver);
				ulp.loginAsUser(UUSERNAME, UPASSWORD);
					  	
				//click on my account link
				UserHomePage uhp=new UserHomePage(driver);
				uhp.getMyAccLink().click();
			  	
			  	//click on order history
			  	uhp.getOrderHistoryLink().click();
			  	 String res = uhp.getShoppingCart().getText();
			  	 SoftAssert sa=new SoftAssert();
			  	 sa.assertEquals(res,"Shopping Cart", "not same page");
			  	 
			    //logout application
			  	uhp.logoutUser();
					  	
			  	//close driver
			  	driver.quit();
			  	sa.assertAll();
	}
}
