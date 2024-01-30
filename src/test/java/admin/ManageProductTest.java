package admin;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.AdminHomePage;
import com.ObjectRepo.ManageProductsPage;
import com.genericUtility.BaseClass;
import java.io.IOException;
//@Listeners(com.genericUtility.ListenerImplenClass.class)
public class ManageProductTest extends BaseClass {
	@Test
	public void manageProductTest() throws IOException {
				//click on manage product
				AdminHomePage ahp=new AdminHomePage(driver);
				ahp.getManageProductsLink().click();
				
				//Assert.fail();       //used to take screenshot as it fails
				ManageProductsPage mpp=new ManageProductsPage(driver);
				mpp.manageProductPage();
	}

}
