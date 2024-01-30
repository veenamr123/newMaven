package admin;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.AdminHomePage;
import com.ObjectRepo.CategoryPage;
import com.ObjectRepo.InsertProductPage;
import com.ObjectRepo.ManageProductsPage;
import com.ObjectRepo.SubCategoryPage;
import com.genericUtility.BaseClass;

//@Listeners(com.genericUtility.ListenerImplenClass.class)
public class ManageProductsTest extends BaseClass {

	@Test(groups="regression")
	public void manageProductsTest() throws IOException {
		
	    int ran=jLib.getRandomNo();
	    
	  //fetch common data from property file
		String IMG= fLib.readData("img");
		
		//fetch test data from excel file
		
		 String catname = eLib.readDataFromExcel("category", 0, 1)+ran;
		 String desc = eLib.readDataFromExcel("category", 1, 1);
		 String subcatname = eLib.readDataFromExcel("category", 2, 1);
		
		//click on category
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getCreateCategoryLink().click();

		//enter category name,description and save
		CategoryPage cp=new CategoryPage(driver);
		cp.createCategory(catname, desc);
		
		//enter sub-category
		ahp.getSubCategoryLink().click();
		
		//enter category name,sub-category name and save
		SubCategoryPage scp=new SubCategoryPage(driver);
		scp.createSubCategory(catname, subcatname);
		
	    //click on insert product
		ahp.getInsertProductLink().click();
		InsertProductPage ipp=new InsertProductPage(driver);
		ipp.createProduct(catname, subcatname, "In Stock", driver, eLib.hashMapData("insertproduct", 0) ,IMG);
		
				//click on manage products
		        ahp.getManageProductsLink().click();
				
				//search for a random product and delete it
		        ManageProductsPage mpp=new ManageProductsPage(driver);
		        mpp.removeProduct(driver, catname);
				
	}
}
