package selenium.basicss;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InClassLocators {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = null;
		String url = "https://www.amazon.com/";
		String browserType = "chrome";
		
		
		
		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		Thread.sleep(2000);
		
		WebElement clinic = driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']"));
	clinic.click();
	
		Thread.sleep(2000);
		
		
		
		WebElement birthControl = driver.findElement(By.xpath("//img[@alt='Birth control']"));
		birthControl.click();
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
