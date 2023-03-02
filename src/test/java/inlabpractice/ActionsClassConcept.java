package inlabpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		driver.get("https://tek-retail-ui.azurewebsites.net/selenium/drag-drop");
		
		
		// source is where you are getting item from and target is where you will drop it!
		
		
		
		
		Actions action = new Actions(driver);
	
		
		WebElement source = driver.findElement(By.xpath("//div[contains(text(),'Payment should not accept')]"));
		
		WebElement target = driver.findElement(By.xpath("(//div[contains(@class,' w-60 p-2 h-96 bg-gray-100')])[2]"));
	
		WebElement source2 = driver.findElement(By.xpath("//*[contains(text(),'After Item is')]"));
		
WebElement target3 = driver.findElement(By.xpath("((//*[contains(@class,' w-60 p-2 h-96 bg-gray-100')])[3]"));

action.dragAndDrop(source, target).perform();
		
		Thread.sleep(2000);
		
		action.dragAndDrop(source2, target).perform();
		
		//Thread.sleep(2000);
		//action.dragAndDrop(source, target3).perform();
		Thread.sleep(2000);
		
		action.dragAndDrop(source2, target3).perform();
		
		
		
		
		
	}

}
