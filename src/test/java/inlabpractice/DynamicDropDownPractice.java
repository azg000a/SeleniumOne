package inlabpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDownPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.aa.com/");

		WebElement oneWayRadioButton = driver.findElement(By.xpath("(//span[contains(@class,'control')])[3]"));
		if (!oneWayRadioButton.isSelected()) {
			oneWayRadioButton.click();
		}
		Thread.sleep(2000);

		WebElement fromCity = driver
				.findElement(By.xpath("//input[contains(@id,'reservationFlightSearchForm.originAirport')]"));
		fromCity.clear();
		fromCity.sendKeys("New");
		Thread.sleep(2000);

		List<WebElement> deptCity = driver.findElements(By.xpath("//a[contains(@id,'ui-id')]"));

		for (WebElement city : deptCity) {
			if (city.getText().contentEquals("JFK - New York John F Kennedy Intl, NY")) {
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].click();", city);
			}
		}

		Thread.sleep(2000);

		WebElement arrival = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
		arrival.clear();
		arrival.sendKeys("Wash");
		Thread.sleep(5000);

		List<WebElement> arrivalCity = driver.findElements(By.xpath("//a[contains(@id,'ui-id')]"));
		for (WebElement arrCity : arrivalCity) {
			if (arrCity.getText().contentEquals("IAD - Washington Dulles Intl, DC")) {
				JavascriptExecutor js1 = ((JavascriptExecutor) driver);
				js1.executeScript("arguments[0].click();", arrCity);    //arguments[0].click() is a Javascript code that performs an action on the element
			}

		}
		
		WebElement passengers = driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
		Select select = new Select(passengers);
		
		select. selectByVisibleText("7");
		
		Thread.sleep(3000);
		
		
		
		WebElement date = driver.findElement(By.xpath("//input[contains(@id,'aa-leavingOn')]"));
		JavascriptExecutor js2 = ((JavascriptExecutor)driver);
		js2.executeScript("document.getElementById('aa-leavingOn').value='01-31-2023'");
		
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
		search.click();
		
		
		

	}

}
