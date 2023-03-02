package inlabpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWork {

	public static void main(String[] args) throws InterruptedException {

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
		Thread.sleep(1000);

		WebElement signIn = driver.findElement(By.id("signinLink"));		
		signIn.click();
		
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.xpath("//input[contains(@type,'email')]"));
		email.sendKeys("Ahmad.ghafoor@tekschool.us");
				Thread.sleep(1000);

		WebElement password = driver.findElement(By.xpath("//input[contains(@id,'password')]"));
		password.sendKeys("Afghan1!");

		Thread.sleep(1000);

		WebElement login = driver.findElement(By.xpath("//button[contains(@id,'loginBtn')]"));
		login.click();
		
		Thread.sleep(1000);

		WebElement account = driver.findElement(By.id("accountLink"));
		account.click();
		
		Thread.sleep(1000);

		
		WebElement cardNumber = driver.findElement(By.name("cardNumber"));
		WebElement cardName = driver.findElement(By.id ("nameOnCardInput"));
		WebElement expireMonth = driver.findElement(By.id ("expirationMonthInput"));
		WebElement expireYear = driver.findElement(By.id("expirationYearInput"));
		WebElement securityCode = driver.findElement(By.xpath("//input[contains(@id,'securityCodeInput')]"));
		WebElement addCard = driver.findElement(By.xpath("//button[contains(@id,'paymentSubmitBtn')]"));
		Select selectMonth = new Select(expireMonth);
		Select selectYear = new Select(expireYear);
		cardNumber.sendKeys("8976543810025879");
		cardName.sendKeys("Shad Gul");
		selectMonth.selectByValue("5");
		selectYear.selectByVisibleText("2026");
		securityCode.sendKeys("234");

		Thread.sleep(1000);

		addCard.click();
		
		Thread.sleep(5000);
		
		WebElement addAddress = driver.findElement(By.xpath("//*[contains(@class,'account__address-new')]"));
		addAddress.click();
		
Thread.sleep(1000);

		WebElement country = driver.findElement(By.xpath("//select[contains(@id,'countryDropdown')]"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("United States");
		
		WebElement fullName = driver.findElement(By.id("fullNameInput"));
		fullName.sendKeys("Shad Gul");

		WebElement phoneNumber = driver.findElement(By.id("phoneNumberInput"));
		phoneNumber.sendKeys("5716548598");

		WebElement address = driver.findElement(By.xpath("//input[contains(@id,'streetInput')]"));
		address.sendKeys("45 Chantilly Shopping Center");

		WebElement city = driver.findElement(By.xpath("//input[contains(@id,'cityInput')]"));
		city.sendKeys("Trumbull");

		WebElement state = driver.findElement(By.xpath("(//select[contains(@class,'account__address-new-dropdown')])[2]"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Virginia");
		
		WebElement zipCode = driver.findElement(By.xpath("//input[contains(@id,'zipCode')]"));
		zipCode.sendKeys("06706");

		Thread.sleep(1000);
		WebElement addYourAddress = driver.findElement(By.xpath("(//button[contains(@class,'account__btn-submit')])[4]"));
		
		
		addYourAddress.click();
		
		Thread.sleep(1000);
		
		driver.close();
		
		
		
		
		
		
		
		
		
	}

}
