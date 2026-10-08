package simonstewart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserNotificationChrome {

	public static void main(String[] args) throws Exception
	{
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		
		System.out.println("STEP 1 - Before browser");
		//Launch browser
		ChromeDriver driver=new ChromeDriver(co);
		System.out.println("STEP 2 - Browser started");
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://in.bookmyshow.com/");
		System.out.println("STEP 3 - Page opened");
		String x = driver.getTitle();
		System.out.println("Title" + x);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='View All Cities']")));
		Thread.sleep(5000);
		//Close site
		driver.close();
		System.out.println("STEP 4 - Browser closed");

	}

}
