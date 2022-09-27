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
	List<WebElement> listOf4gb = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM')]/ancestor::div[@class='col col-7-12']/child::div[@class='_4rR01T']"));
		
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
