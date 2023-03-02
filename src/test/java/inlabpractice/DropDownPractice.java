package inlabpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		
		WebElement computers = driver.findElement(By.xpath("//select[@id = 'search']"));
		Select select = new Select(computers);
		
		select.selectByVisibleText("Computers");
		
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//input[@id ='searchInput']"));
		search.click();
		search.sendKeys("Amazon eero mesh Wifi router");
		Thread.sleep(1000);
		WebElement clickSearch = driver.findElement(By.xpath("//button[@id='searchBtn']"));
		clickSearch.click();
		Thread.sleep(1000);
		WebElement photo = driver.findElement(By.xpath("//img[contains(@alt,'Amazon eero')]"));
		photo.click();
		
		Thread.sleep(1000);
		WebElement qty = driver.findElement(By.xpath("//select[contains(@class,'product__select')]"));
		
		Select select1 = new Select(qty);
		select1.selectByVisibleText("5");
		Thread.sleep(1000);
		
		driver.close();
		
	}

}
