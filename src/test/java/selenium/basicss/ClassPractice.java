package selenium.basicss;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassPractice {

	public static void main(String[] args) {

		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();

		driver.get("https://tek-retail-ui.azurewebsites.net/");

		WebElement signIn = driver.findElement(By.id("signinLink"));
		signIn.click();
		
		WebElement createAccount = driver.findElement(By.id("newAccountBtn"));
		createAccount.click();

		WebElement inputName = driver.findElement(By.id("nameInput"));
		inputName.sendKeys("John A");

		WebElement inputEmail = driver.findElement(By.id("emailInput"));
		inputEmail.sendKeys("JohnA@tekschool.us");

		WebElement inputPassword = driver.findElement(By.id("passwordInput"));
		inputPassword.sendKeys("Tek@23456");

		WebElement confirmPassword = driver.findElement(By.id("confirmPasswordInput"));
		confirmPassword.sendKeys("Tek@23456");

		WebElement signUp = driver.findElement(By.id("signupBtn"));
		signUp.click();

	}

}
