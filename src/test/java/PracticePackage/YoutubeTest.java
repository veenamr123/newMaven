package PracticePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.youtube.com/");

		WebElement ele = driver.findElement(By.xpath("//input[@id='search']"));
		ele.sendKeys("song");
		ele.sendKeys(" ");
		List<WebElement> autoSugg = driver.findElements(By.cssSelector("[class*=sbqs_c]>b"));
		for(WebElement e:autoSugg) {
			if(e.getText().contains("new")) {
				e.click();
				break;
			}
		}
	}



}
