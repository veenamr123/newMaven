package PracticePackage;

	import java.util.Set;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

	public class Close7window10Test {
		
			public static void main(String[] args) {
				WebDriver driver = new ChromeDriver();
				String id = null;
				for (int i = 1; i < 10; i++) {
					driver.switchTo().newWindow(WindowType.WINDOW);
					if (i == 6) {
						id = driver.getWindowHandle();
					}
				}
				Set<String> allwin = driver.getWindowHandles();
				for (String s : allwin) {
					driver.switchTo().window(id);
					if (id.equals(s)) {
						break;
					}
				}
				driver.quit();
			}
		

	}


