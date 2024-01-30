package PracticePackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks1Test {

	public static void main(String[] args) throws Throwable  {
		//launch browser, maximize,include implicitly wait
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//enter Url
		driver.get("https://www.irctc.co.in/");
		Thread.sleep(5000);
		
		//to find all links on home page
		List<WebElement> alllinks = driver.findElements(By.xpath("//a|//link"));
		  for(WebElement link:alllinks)
		  {
			String l = link.getAttribute("href");
			int statusCode=0;
			 try {
				 URL url= new URL(l);
				 HttpURLConnection httpCon=(HttpURLConnection) url.openConnection();
				statusCode = httpCon.getResponseCode();
				if(statusCode<=400 && l!=null)
					System.out.println(l+"-->"+statusCode);
			 }
			 catch(IOException e) { 
				 System.out.println(l+"-->"+statusCode);
		  }

	}

	}
}
