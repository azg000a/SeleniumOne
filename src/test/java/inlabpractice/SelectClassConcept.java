package inlabpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassConcept {

	public static void main(String[] args) {

	
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://tek-retail-ui.azurewebsites.net/selenium/dropdown");
	
	//to automate a static drop down (the tagname must be select to use Select class):
	
	// can do by SelectbyIndex, [[[SelectbyVisibleText--> this option is the most commonly used one*****]]]]] or selectbyValue!!!!
	
	
	
	WebElement programLan = driver.findElement(By.xpath("//select[contains(@name,'language')]"));
	
	Select select = new Select(programLan);
	
	select.selectByVisibleText("Python");
	
	WebElement country = driver.findElement(By.xpath("//select[@id='countrySelect']"));
	
	Select select1 = new Select(country);

	
	select1.selectByVisibleText("United States");
	
	WebElement webLanguage = driver.findElement(By.xpath("//select[@id='languageSelect']"));
	
	Select select2 = new Select(webLanguage);

	
	select2.selectByVisibleText("Pashto");
	
	
	
	
	
	
	
	
	
	
	
	}

}
