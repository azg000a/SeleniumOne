package seleniumowntimepractice;

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

public class ScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		
		WebDriver driver = null;
		String url = "https://tek-retail-ui.azurewebsites.net/";
		String browserType = "firefox";
		
		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
		Actions action = new Actions(driver);
		
		WebElement signIn = driver.findElement(By.id("signinLink"));
		signIn.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("Ahmad.Ghafoor@tekschool.us");
		
		WebElement password =driver.findElement(By.id("password"));
		password.sendKeys("Afghan1!");
		
		WebElement logIn = driver.findElement(By.xpath("//*[contains(@id,'loginBtn')]"));
		logIn.click();
		
		WebElement accountPage = driver.findElement(By.xpath("//a[contains(@id,'accountLink')]"));
		accountPage.click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@id,'profileImage')]")));
		
		//takeAScreenshot("account page", driver);
		
		

		
		
		driver.navigate().to("https://tek-retail-ui.azurewebsites.net/selenium/checkbox");
		
		WebElement java = driver.findElement(By.xpath("//input[contains(@id,'javaInput')]"));
		if(!java.isSelected()) {
			java.click();
		}
		
		WebElement codingBox = driver.findElement(By.xpath("//input[contains(@id,'codingInput')]"));
		if(!codingBox.isSelected()) {
			codingBox.click();
		}
		
		driver.navigate().to("https://tek-retail-ui.azurewebsites.net/selenium/drag-drop");
		
		WebElement payment = driver.findElement(By.xpath("//*[contains(text(),'After Item is removed from cart. total price must get reduced')]"));
		WebElement inProgress = driver.findElement(By.xpath("(//*[contains(@class,'w-60 p-2 h-96 bg-gray-100')])[3]"));
		
		action.dragAndDrop(payment, inProgress).perform();
		
		Thread.sleep(5000);
		
		driver.navigate().to("https://tek-retail-ui.azurewebsites.net/selenium/dropdown");
		
		WebElement progLang = driver.findElement(By.xpath("//*[contains(@id,'programmingLanguageSelect')]"));
		
		Select select = new Select(progLang);
		select.selectByVisibleText("Erlang");
		Thread.sleep(1000);
		WebElement selCountry = driver.findElement(By.id("countrySelect"));
		Select select1 = new Select(selCountry);
		select1.selectByVisibleText("Cuba");
		Thread.sleep(1000);
		
		WebElement webLang = driver.findElement(By.id("languageSelect"));
		Select select2 = new Select(webLang);
		select2.selectByVisibleText("German");
		
		
		
		driver.quit();
	}
	
	
	public static void takeAScreenshot(String name, WebDriver driver) throws IOException {
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("./output/" +name+ ".png"));
		
			
			
		}

	public static void selectDropDown(WebElement element, String value) {
			
		Select select = new Select(element);
		
		select.selectByVisibleText(value);
		
	}
	
	
}

