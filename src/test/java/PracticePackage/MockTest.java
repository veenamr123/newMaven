package PracticePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MockTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
	    WebElement ele = driver.findElement(By.xpath("//span[.='Fashion']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		 List<WebElement> subele = driver.findElements(By.xpath("//a[contains(@class,'_1BJVlg')]"));
		for(WebElement pro:subele)
		{
			a.moveToElement(pro).perform();
			List<WebElement> elelst = driver.findElements(By.xpath("//a[contains(@class,'_3490ry')]"));
			for(WebElement prolst:elelst)
			{
				System.out.println(prolst.getText());
			}
		}
		
	}

}
