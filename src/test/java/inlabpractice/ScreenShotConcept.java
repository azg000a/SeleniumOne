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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotConcept {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(130));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(130));
		
		driver.get("https://tekschool.us/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("img")));
		
		Actions action = new Actions(driver);
		
		WebElement scrollDown = driver.findElement(By.xpath("//body[contains(@class,'home page-template-default page page-id-1167 wp-custom-logo wp-embed-responsive tribe-js edubin-front-page page-two-column title-tagline-hidden colors-light elementor-default elementor-kit-14 elementor-page elementor-page-1167 e--ua-blink e--ua-chrome e--ua-webkit')]"));
		action.moveToElement(scrollDown).perform();
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./output/image.png"));
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
