package inlabpractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertConcepts {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		driver.get("https://tek-retail-ui.azurewebsites.net/selenium/javascript-alerts");
		
		WebElement alertButton = driver.findElement(By.id("alertBtn"));
		alertButton.click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText + "This is alert from text");
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		
		WebElement confirmAlert = driver.findElement(By.id("confirmBtn"));
		confirmAlert.click();
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(3000);
		
		WebElement promptAlert = driver.findElement(By.id("promptBtn"));
		promptAlert.click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("This is some value");
		alert.accept();
		
		
		driver.navigate().to("https://tek-retail-ui.azurewebsites.net/selenium/alert");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
