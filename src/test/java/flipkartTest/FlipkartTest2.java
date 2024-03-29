package flipkartTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest2 {

	@Test
	public void sort4gbRedmiPhones() {
	//configuration	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//navigate to flipkart	
		driver.get("https://www.flipkart.com/");
	//close the login pop-up
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	//search the data & click on go		
		driver.findElement(By.name("q")).sendKeys("redMi",Keys.ENTER);
	//identify the required data- (only 4gb redmi phones)
	List<WebElement> listOf4gb = driver.findElements(By.xpath
		("//li[contains(text(),'4 GB RAM')]/ancestor::div[@class='col col-7-12']/child::div[@class='_4rR01T']"));
		
		int count=0;
	//iterate using forEach to get the text and print it on console	
		for (WebElement webElements : listOf4gb) {
			
			System.out.println(webElements.getText());
			count++;
		}
		System.out.println("total 4 gb redMi phones in list: "+count++);
		
		driver.close();
	}
}
/*
 * output of program:-
 * 
 * REDMI 10 (Midnight Black, 64 GB)
REDMI 10 (Caribbean Green, 64 GB)
REDMI 10 (Pacific Blue, 64 GB)
REDMI 9i Sport (Coral Green, 64 GB)
REDMI 9i Sport (Metallic Blue, 64 GB)
REDMI 9i Sport (Carbon Black, 64 GB)
REDMI Note 10T 5G (Metallic Blue, 64 GB)
REDMI Note 10T 5G (Graphite Black, 64 GB)
REDMI 10 Prime 2022 (Bifrost Blue, 64 GB)
total 4 gb redMi phones in list: 9
PASSED: sort4gbRedmiPhones

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================


 */

