package PracticePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class MmtTest {

	public static void main(String[] args) throws InterruptedException {
		//open browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait or wait for page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//enter url
		driver.get("https://www.makemytrip.com/");
		
		//click on flight
		driver.findElement(By.xpath("//div[@class='chHeaderWrapper navOnly']/div/nav/ul/li/span/a/span[text()='Flights']")).click();
		
		//click on one way radio button
		driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
		
		//select from location
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.switchTo().activeElement().sendKeys("mum");
		Thread.sleep(5000);
		
		WebElement fromloc = driver.findElement(By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(fromloc).click().perform();
		
		//select to location
		driver.findElement(By.id("toCity")).sendKeys("delhi");
		
		WebElement toloc = driver.findElement(By.xpath("//p[text()='New Delhi, India']"));
		act.moveToElement(toloc).click().perform();
        
		//click on date
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Dec 27 2023']")).click();
		
		//click on search
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		//driver.quit();
		
		//click on booknow button
		
		driver.findElement(By.id("listingFilterCheckbox")).click();
		driver.findElement(By.xpath("//span[text()='BOOK NOW']")).click();
	}

}
