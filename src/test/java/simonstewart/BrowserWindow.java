package simonstewart;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWindow {

	public static void main(String[] args) throws Exception
	{
				//Launch browser
				ChromeDriver driver = new ChromeDriver();
				//Maximize
				driver.manage().window().maximize();
				//Open site
				driver.get("https://the-internet.herokuapp.com/windows");
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click Here")));
				driver.findElement(By.linkText("Click Here")).click();
				Thread.sleep(5000);
				ArrayList<String> al=new ArrayList<String>(driver.getWindowHandles());
				//Set<String> a=driver.getWindowHandles();
				//ArrayList<String> al=new ArrayList<String>(a);
				int c=al.size();
				System.out.println("No of tabs opened are: "+c);
				for(int i=0;i<al.size();i++)
				{
					System.out.println("Browser tab "+(i+1)+" is "+al.get(i));
				}
				driver.switchTo().window(al.get(1));
				Thread.sleep(3000);
				driver.close();
				Thread.sleep(2000);
				driver.switchTo().window(al.get(0));
				Thread.sleep(3000);
				//close browser
				driver.quit();

	}

}
