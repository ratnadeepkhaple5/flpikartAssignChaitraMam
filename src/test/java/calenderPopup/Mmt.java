package calenderPopup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mmt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(1000);
		
		//to avoid popup click anywhere
		Actions ac=new Actions(driver);
		ac.moveByOffset(10, 10).click().perform();
		
Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		
		driver.findElement(By.xpath("//*[.='DEPARTURE']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Mon Oct 03 2022']")).click();
		
	}

}
