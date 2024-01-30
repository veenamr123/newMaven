package PracticePackage;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageOrdersSmokeTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		Thread.sleep(1000);
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		driver.findElement(By.xpath("//a[.='Manage Products ']")).click();
		

	}

}
