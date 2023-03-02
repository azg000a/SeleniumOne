package selenium.basicss;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		
		//driver.quit(); //this closes all tabs opened by webdriver
		
		WebDriverManager.chromedriver().setup();		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);
		
		
		driver.navigate().to("https://tekschool.us/");
		String title2 = driver.getTitle();
		System.out.println("The title of the second page is: "+ title2);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.close();   //this closes only the single window open by webdriver
		
		
		
		
		
	}

}
