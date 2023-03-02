package selenium.basicss;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SigninTest {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		
		WebElement element = driver.findElement(By.id("signinLink"));
		
		
		
		Actions action = new Actions(driver);
		action.click(element).perform();

		WebElement email = driver.findElement(By.id("email"));

		
	action.sendKeys(email, "ahmad.ghafoor@tekschool.us").perform();
	
	WebElement password = driver.findElement(By.id("password"));

	action.sendKeys(password, "Afghan1!").perform();	
	
	WebElement loginbutton = driver.findElement(By.id("loginBtn"));
	
	action.click(loginbutton).perform();
	
	}

}
