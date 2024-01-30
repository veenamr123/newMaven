package PracticePackage;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IccDemo1Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//enter Url
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/t20i");
		Thread.sleep(3000);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='si-table-body']/div/div[2] | //div[@class='si-table-body']/div/div[3] | //div[@class='si-table-body']/div/div[5]"));
		for(WebElement e:ele)
		{
			   
              System.out.println(e.getText());
		}
	}

}
