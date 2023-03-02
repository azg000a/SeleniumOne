package selenium.basicss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorTest {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		Actions action = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a"));
		
		action.click(element).perform();
		
		
		
		
		
		
	}

}
