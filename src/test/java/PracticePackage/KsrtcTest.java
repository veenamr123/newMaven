package PracticePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KsrtcTest {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath("//a[.=]")).click();

	}

}
