 package inlabpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeAgainAgain {

	public static void main(String[] args) throws InterruptedException {

		
		
		
		WebDriver driver = null;
		String browserType = "chrome";
		String url = "https://tek-retail-ui.azurewebsites.net/";
		
		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		
		Actions action = new Actions(driver);
		
		WebElement signIn = driver.findElement(By.id("signinLink"));		
		Thread.sleep(2000);
		
		signIn.click();
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement logIn = driver.findElement(By.id("loginBtn"));
		

		email.sendKeys("Ahmad.Ghafoor@tekschool.us");
		password.sendKeys("Afghan1!");
		Thread.sleep(2000);
		action.click(logIn).perform();
		
		WebElement dropDown = driver.findElement(By.xpath("//*[contains(@id,'search')]"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("Electronics");
		
		
		
		List <WebElement> games = driver.findElements(By.tagName("img"));
		for(WebElement x : games) {
			if(x.getAttribute("alt").equals("Amazon Fire TV ")){
				x.click();
			}
			
		}
		
		
		
		
		
		
		
		
	}

}
