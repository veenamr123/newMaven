package PracticePackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RmgYantraSelectQueryTest {

	public static void main(String[] args) throws InterruptedException,SQLException {
		 Connection con=null;
		 Random r=new Random();
		 int random = r.nextInt(100);
		 String project_name = "zeel_shopee_"+random;
		 try {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://rmgtestingserver:8084/");
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[.='Sign in']")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//a[.='Projects']")).click();
		 driver.findElement(By.xpath("//span[.='Create Project']")).click();
		 driver.findElement(By.name("projectName")).sendKeys(project_name);
		 driver.findElement(By.name("createdBy")).sendKeys("deepak");
		 WebElement ele = driver.findElement(By.xpath("//option[.='Select Value']/.."));
		 Select s=new Select(ele);
		 s.selectByVisibleText("Created");
		 driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		 
		 //validate the data
		 //step1: register driver
		 
		    Driver driver1	=new Driver();
	        DriverManager.registerDriver(driver1);
	        
	        //step2: get connected to db
	        con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	        
		    //step3: create statement
	        Statement state = con.createStatement();
		    String query = "select * from project where lower(project_name)='"+project_name+"';";
		    
		    //step4: execute query
		     ResultSet res = state.executeQuery(query);
		    
		    Boolean flag=false;
		    while(res.next())
		    {
		    	String actual = res.getString(4);//res.getMetaData();
		    	if(project_name.contains(actual))
		    	{
		    		flag=true;
		    		break;
		    	}
		    	
		    }
		    
		    if(flag)
		       System.out.println("project created successfully");
		    else
		    	System.err.println("project not created");  
		 }
		 catch(Exception e) { }
		 finally {
			 con.close();
		 }	 
	}
}
