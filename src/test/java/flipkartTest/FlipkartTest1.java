package flipkartTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest1 {

		@Test
		public void addHeaterToCart() {
	//configuration
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//navigate to flipkart	
		driver.get("https://www.flipkart.com/");
	//close the login pop-up	
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	//search the data & click on go	
		driver.findElement(By.name("q")).sendKeys("winter heater",Keys.ENTER);
	//click on 1st element	
		driver.findElement(By.xpath("(//a[@class='s1Q9rs'])[1]")).click();
	//get all window ids	
		Set<String> allwindowIds = driver.getWindowHandles();
		//System.out.println(allwindowIds);
	//switching to required window by using window-id
		for (String str : allwindowIds) {
			
			driver.switchTo().window(str);
			if (driver.getTitle().contains("DARSHANAM WORLD")) {
				break;
			}
		}
	//add product to cart	
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	//validation		
		if (driver.getPageSource().contains("DARSHANAM WORLD")) {
			System.out.println("product added to cart successfully");
		}
		else {
			System.out.println("no such product in cart..");
		}
		driver.close();
	}
}
