package inlabpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		String browserType = "chrome";
		String url = "https://www.aa.com/homePage.do";
		
		
		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		WebElement closeCookie = driver.findElement(By.id("cookieBannerClose"));
		closeCookie.click();
		
		
		WebElement radioButton = driver.findElement(By.xpath("(//span[contains(@class,'control')])[3]"));
		if(!radioButton.isSelected()) {
			radioButton.click();
		}
		
		
		WebElement fromSearch = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
		fromSearch.clear();
		fromSearch.sendKeys("Dubai");
		
		Thread.sleep(3000);
		
		List <WebElement> fromCity = driver.findElements(By.xpath("//a[contains(@id,'ui-id')]"));
		for(WebElement city :fromCity) {
			if(city.getText().contentEquals("DXB - Dubai, United Arab Emirates")) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();",city);
		}
			
		}
		

		WebElement toSearch = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
		toSearch.clear();
		toSearch.sendKeys("ger");
		
		Thread.sleep(4000);
		
		List<WebElement> toCity = driver.findElements(By.xpath("//a[contains(@id,'ui-id')]"));
		for(WebElement citi : toCity) {
			if(citi.getText().contentEquals("FRA - Frankfurt International, Germany")) {
				JavascriptExecutor js1 = ((JavascriptExecutor)driver);
				js1.executeScript("arguments[0].click();", citi);
			}
		}
		
		
		WebElement passengers = driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
		Select select = new Select(passengers);
		select.selectByVisibleText("8");
		
		
		WebElement date = driver.findElement(By.id("aa-leavingOn"));
		JavascriptExecutor js2 = ((JavascriptExecutor)driver);
		js2.executeScript("document.getElementById('aa-leavingOn').value='2023-02-15'");
		
		
		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
		search.click();
		
		
		
		
		
		
	}

}
