package inlabpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeMySelf {

	public static void main(String[] args) throws InterruptedException {

		
		//a[contains(@target,'_top' and @text(),'Images')]
		
		WebDriver driver = null;
		String url = "https://tek-retail-ui.azurewebsites.net/";
		String browserType = "firefox";
		
		
		if (browserType.equalsIgnoreCase("chrome")){
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
		
		Actions action = new Actions(driver);
		
		Thread.sleep(1500);
		
		
		WebElement signIn= driver.findElement(By.xpath("//a[contains(@id,'signinLink')]"));
		signIn.click();
		
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		email.click();
		email.sendKeys("Ahmad.ghafoor@tekschool.us");
		
		WebElement password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		password.click();
		password.sendKeys("Afghan1!");
		
		Thread.sleep(1000);
		
		
		WebElement login = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
		login.click();
		
		Thread.sleep(1000);
		
		WebElement electronics = driver.findElement(By.xpath("//select[contains(@id,'search')]"));
		electronics.click();
		Thread.sleep(1500);
		WebElement electronics2 = driver.findElement(By.xpath("//option[contains(text(),'Electronics')]"));
		electronics2.click();
		
		Thread.sleep(1000);		
		

		
		
		WebElement search = driver.findElement(By.xpath("//input[contains(@id,'search')]"));
		search.click();
		search.sendKeys("keyboard");
		Thread.sleep(1500);
		WebElement searchEnter = driver.findElement(By.xpath("//button[contains(@class,'search__')]"));
		searchEnter.click();
		
		WebElement keyboard = driver.findElement(By.xpath("//img[contains(@alt,'NPET K10')]"));
		keyboard.click();
Thread.sleep(1500);

	WebElement changeQty = driver.findElement(By.xpath("//select[contains(@class,'product__sele')]"));
	changeQty.click();
	changeQty.sendKeys("3");
	Thread.sleep(1000);
	WebElement addQty = driver.findElement(By.xpath("//span[contains(text(),'Add to ')]"));
	addQty.click();
	Thread.sleep(1000);
	
	WebElement checkCart= driver.findElement(By.xpath("//div[contains(@id,'cartBtn')]"));
	checkCart.click();
	
	Thread.sleep(2000);
	
	WebElement checkout = driver.findElement(By.xpath("//button[contains(@id,'proceedBtn')]"));
	checkout.click();
	Thread.sleep(1000);
	WebElement placeOrder = driver.findElement(By.xpath("//button[contains(@id,'placeOrder')]"));
	placeOrder.click();
	
	Thread.sleep(5000);
	
	driver.quit();
	



	}

}
