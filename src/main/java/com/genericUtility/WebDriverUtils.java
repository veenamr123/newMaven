package com.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtils {
	
	/**
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
 
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	public  WebDriverWait waitObj(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		return wait;
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void waitUntilEleTobeVisible(WebDriver driver,int sec,WebElement ele)
	{
		waitObj(driver,sec).until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 */
	public void waitUntilAlertisPresent(WebDriver driver,int sec)
	{
		waitObj(driver,sec).until(ExpectedConditions.alertIsPresent());
		
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @param t
	 */
	public void waitUntilTitleIs(WebDriver driver,int sec,String t)
	{
		waitObj(driver,sec).until(ExpectedConditions.titleIs(t));
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void waitUntilEleClickable(WebDriver driver,int sec,WebElement ele)
	{
		waitObj(driver,sec).until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void waitUntilElemTObeSelected(WebDriver driver,int sec,WebElement ele)
	{
		waitObj(driver,sec).until(ExpectedConditions.elementToBeSelected(ele));
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @param url
	 */
	public void waitUntilUrlTobe(WebDriver driver,int sec,String url)
	{
		waitObj(driver,sec).until(ExpectedConditions.urlToBe(url));
	}
	
	/**
	 * 
	 * @param ele
	 * @param index
	 */
	public void selectIndex(WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 * 
	 * @param ele
	 * @param text
	 */
	public void dropDownText(WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	
	/**
	 * 
	 * @param value
	 * @param ele
	 */
	public void selectValue(String value,WebElement ele)
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mousehover(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void moveTo(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.click(ele).perform();
	}
	
	/** 
	 * 
	 * @param driver
	 * @param src
	 * @param tar
	 */
	public void dragDrop(WebDriver driver,WebElement src,WebElement tar)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, tar).perform();
	}
	
	public void doubleClickele(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	/**
	 * this method is used
	 * @author RAGHAVENDRA
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void rightClickEle(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	
	public void pressEnter(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * 
	 * 
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void releaseEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameById(WebDriver driver,String nameRId)
	{
		driver.switchTo().frame(nameRId);
	}
	
	public void switchToFrameByAdd(WebDriver driver,WebElement addr)
	{
		driver.switchTo().frame(addr);
	}
	
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver,String title)
	{
		//step1:use getWindowhandles to capture all window ids
		Set<String> allwin = driver.getWindowHandles();
		for(String wh:allwin)
		{
			 String gtitle = driver.switchTo().window(wh).getTitle();
			if(gtitle.contains(title))
			{
				driver.switchTo().window(wh);
				break;
			}
		}
	}
	

	public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		JavaUtils jLib=new JavaUtils();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+jLib.getSystemDateInFormat()+".png";
		File dst = new File(path);
		String res = dst.getAbsolutePath();
		FileUtils.copyFile(src,dst);
		return res;
	}
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500", "");
	}
	
    public void scrollAction(WebDriver driver,WebElement ele)
    {
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	int y=ele.getLocation().getY();
    	js.executeScript("window.scrollBy(0,"+y+")", ele);
    }
    
    public void openNewTab(WebDriver driver)
    {
    	driver.switchTo().newWindow(WindowType.TAB);
    }
    
    public void openNewWindow(WebDriver driver)
    {
    	driver.switchTo().newWindow(WindowType.WINDOW);
    }
}
