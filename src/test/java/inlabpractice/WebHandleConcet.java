package inlabpractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebHandleConcet {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://tek-retail-ui.azurewebsites.net/selenium/links");

		String originalWindow = driver.getWindowHandle();

		WebElement newTab = driver.findElement(By.xpath("//*[contains(text(),'new tab with html')]"));
		newTab.click();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!originalWindow.contentEquals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}

		String htmlTitle = driver.getTitle();
		System.out.println("Html window Title: " + htmlTitle);

		driver.close();

		driver.switchTo().window(originalWindow);
		Thread.sleep(5000);

		WebElement jsTab = driver.findElement(By.xpath("//*[contains(text(),'new window with js')]"));
		jsTab.click();

		for (String handle2 : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(handle2)) {
				driver.switchTo().window(handle2);
				break;
			}
		}
		String jsTitle = driver.getTitle();
		System.out.println("JS window Title: " + jsTitle);

		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(originalWindow);
		Thread.sleep(5000);
		driver.quit();

	}

}
