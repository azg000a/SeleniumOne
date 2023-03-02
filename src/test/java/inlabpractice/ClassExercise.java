package inlabpractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassExercise {

	
	public static void main(String[] args) throws InterruptedException, IOException {

		
		
		WebDriver driver = null;
		String url = "https://tek-retail-ui.azurewebsites.net/";
		String browserType = "chrome";
		
		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement signIn = driver.findElement(By.id("signinLink"));		
		signIn.click();
		
		WebElement email = driver.findElement(By.xpath("//input[contains(@type,'email')]"));
		email.sendKeys("Ahmad.ghafoor@tekschool.us");

		WebElement password = driver.findElement(By.xpath("//input[contains(@id,'password')]"));
		password.sendKeys("Afghan1!");


		WebElement login = driver.findElement(By.xpath("//button[contains(@id,'loginBtn')]"));
		login.click();
		

		WebElement account = driver.findElement(By.id("accountLink"));
		account.click();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div.main-container div.bg-gray-100 div.account div:nth-child(3) div.account__address-grid:nth-child(2) div.account__address-new div.account__address-new-wrapper > p:nth-child(2)"))));
		
WebElement addAddress = driver.findElement(By.cssSelector("div.main-container div.bg-gray-100 div.account div:nth-child(3) div.account__address-grid:nth-child(2) div.account__address-new div.account__address-new-wrapper > p:nth-child(2)"));
		Actions action = new Actions(driver).moveToElement(addAddress);
		
		addAddress.click();
		
		
		takeScreenShot("fillingBeforeAddress",driver);
		
		
		WebElement countryDrop = driver.findElement(By.id("countryDropdown"));
		selectDropDown(countryDrop, "United Kingdom");
		
		WebElement fullName = driver.findElement(By.cssSelector("#fullNameInput"));
		fullName.sendKeys("transformer test");
		
		WebElement phoneNumber = driver.findElement(By.cssSelector("#phoneNumberInput"));
		phoneNumber.sendKeys("7038569879");
		
		WebElement street = driver.findElement(By.xpath("//*[contains(@id,'streetInput')]"));
		street.sendKeys("Shad Gul Lane");
		
		WebElement city = driver.findElement(By.xpath("//*[contains(@id,'cityInput')]"));
		city.sendKeys("kabul");
		
		WebElement stateDrop = driver.findElement(By.xpath("(//*[contains(@class,'account__address-new-dropdown')])[2]"));
		
		selectDropDown(stateDrop,"Barnet");
		
		WebElement zip = driver.findElement(By.xpath("//*[contains(@id,'zipCodeInput')]"));
		zip.sendKeys("06116");
		
		
		takeScreenShot("After Filling", driver);

		
		
		WebElement addYourAddress= driver.findElement(By.xpath("//*[contains(@id,'addressBtn')]"));
		addYourAddress.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Add Your Address']")));
		

		
		driver.quit();
		
	}

	public static void takeScreenShot(String name,WebDriver driver) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./output/"+name+ ".png"));
		
		
	}
	
	public static void selectDropDown(WebElement element, String value) {
		Select select = new Select(element);
		
		select.selectByVisibleText(value);
		
	}
	
	
	
}
