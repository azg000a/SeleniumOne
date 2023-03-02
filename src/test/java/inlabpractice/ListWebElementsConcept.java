package inlabpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWebElementsConcept {

	public static void main(String[] args) throws InterruptedException {


	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
	driver.get("https://tek-retail-ui.azurewebsites.net/products");
	
	WebElement allIcon = driver.findElement(By.xpath("//button[contains(@id,'hamburgerBtn')]"));
	allIcon.click();
	Thread.sleep(2000);

	WebElement electronics = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
	electronics.click();
	Thread.sleep(2000);

	WebElement videoGames = driver.findElement(By.xpath("//span[contains(text(),'Video Games')]"));
	videoGames.click();
	
	Thread.sleep(2000);
	
	List<WebElement> products = driver.findElements(By.tagName("img"));
System.out.println(	products.size());
	for (WebElement x : products) {
		System.out.println(x.getAttribute("alt"));
			if(x.getAttribute("alt").equals("NPET K10 Gaming Keyboard")) {
				x.click();
				break;
	}
	
	}
	WebElement addQty = driver.findElement(By.xpath("//select[@class='product__select']"));
	
	Select select = new Select(addQty);
	select.selectByValue("5");
	
	WebElement addCart = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
	System.out.println(addCart.isEnabled());
	}

}
