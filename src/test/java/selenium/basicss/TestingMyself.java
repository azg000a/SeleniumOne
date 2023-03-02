package selenium.basicss;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingMyself {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();

		driver.get("https://tek-retail-ui.azurewebsites.net/");
		
		Thread.sleep(3000);

		driver.navigate().to("https://www.amazon.com/");
		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(2000);

		driver.navigate().back();

		Thread.sleep(2000);

		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.id("signinLink"));
		action.click(element).perform();

		WebElement email = driver.findElement(By.id("email"));
		action.sendKeys(email, "Ahmad.ghafoor@tekschool.us").perform();

		WebElement password = driver.findElement(By.id("password"));
		action.sendKeys(password, "Afghan1!").perform();

		WebElement login = driver.findElement(By.id("loginBtn"));
		
		action.click(login).perform();
		Thread.sleep(1000);
		WebElement logout = driver.findElement(By.id("logoutBtn"));
		action.click(logout).perform();

	}

}
