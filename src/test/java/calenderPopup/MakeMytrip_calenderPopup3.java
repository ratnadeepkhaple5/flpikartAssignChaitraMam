package calenderPopup;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMytrip_calenderPopup3 {

	public static void main(String[] args) throws InterruptedException {
		Date d=new Date();
		//	System.out.println(date);//Wed Sep 28 23:34:57 IST 2022
			
			//Mon Oct 03 2022          <-required format present in DOM
			//Wed Sep 28 23:34:57 IST 2022
			// 0   1   2     3     4   5
		//override	
			String datestr = d.toString();
		//	remove spaces so it will not included in array
			String[] strArr = datestr.split(" ");
			//split() -> empty strings are therefore not included in the resulting array.
		
			String day = strArr[0];
			String month = strArr[1];
			String date = strArr[2];
			String year=strArr[5];
			String travelDate = day+" "+month+" "+date+" "+year;
			System.out.println(travelDate);
			
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
			
		//navigate to desired date in calender
			Thread.sleep(1000);
			
		//write dynamic xpath works runtime get date runtime
			driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
		
	}

}
