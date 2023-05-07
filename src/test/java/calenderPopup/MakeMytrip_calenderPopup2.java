package calenderPopup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMytrip_calenderPopup2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Chennai");
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		
		driver.findElement(By.xpath("//*[.='DEPARTURE']")).click();
		
	//navigate to required date in calendar which is not present in current DOM	
		Thread.sleep(1000);
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='Sat Dec 03 2022']")).click();
				break;
				
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}	
		}
		
		
	}

}
