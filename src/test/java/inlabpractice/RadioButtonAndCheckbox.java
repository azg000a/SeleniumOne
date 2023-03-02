package inlabpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonAndCheckbox {

	public static void main(String[] args) throws InterruptedException {


		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tek-retail-ui.azurewebsites.net/selenium/checkbox");
		
	Thread.sleep(2000);
		
		WebElement javaCheckbox = driver.findElement(By.id("javaInput"));
		System.out.println("Java Checkbox is selected: " + javaCheckbox.isSelected());
		if(!javaCheckbox.isSelected()) {
			javaCheckbox.click();
		}
		System.out.println("Java Checkbox is selected: " + javaCheckbox.isSelected());
	
	
	
	
	WebElement radioButtonLink = driver.findElement(By.linkText("Radio Button"));
	
	radioButtonLink.click();
	
	List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
	System.out.println(radioButtons.size() + " this is the size of the list");

	
	for(WebElement buttons : radioButtons) {
		if(buttons.getAttribute("value").equals("CSS")) {
		if(!buttons.isSelected()) {
				buttons.click();
				break;
			}
		}
	}
	
	
	}

}
