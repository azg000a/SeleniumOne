package inlabpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LabPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.manage().deleteAllCookies();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		
		WebElement signIn = driver.findElement(By.xpath("//*[@id=\"signinLink\"]"));
		signIn.click();
		Thread.sleep(2000);
		WebElement sellSomething= driver.findElement(By.id("newCompanyAccount"));
		sellSomething.click();

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("JohnP@gmail.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Afghan2@");

		WebElement companyName = driver.findElement(By.id("nameInput"));
		companyName.sendKeys("TekSchool");

		WebElement description = driver.findElement(By.id("descriptionInput"));
		description.sendKeys("Voila");
		Thread.sleep(3000);
		WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"signupAsSellerBtn\"]"));
		
		createAccount.click();
		Thread.sleep(5000);
		
		driver.close();
	}

}
