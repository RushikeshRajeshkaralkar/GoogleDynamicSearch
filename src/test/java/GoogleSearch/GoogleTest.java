package GoogleSearch;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GoogleTest {
	
	
//	@Test
//	public void GoogelSearch()
//	{
//		System.setProperty("webdriver.chrome.driver", "A:/chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.google.com");
//
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		// Entering the text in google search box...
//		driver.findElement(By.id("lst-ib")).sendKeys("seleni");
//		// waiting for the suggestions list
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		// locating the list
//		WebElement list = driver.findElement(By.xpath("//ul[@class='sbsb_b']"));
//		// Getting all the suggestions listed in list
//		List<WebElement> suggestions = list.findElements(By.tagName("li"));
//
//		System.out.println(suggestions.size());
//	}
//	
	
	@Test
	public void Search()
	{
		System.setProperty("webdriver.chrome.driver", "A:/chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("slenium");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		System.out.println(list.size());
		
		for(int i=0;i<=list.size();i++)
		{
			String value=list.get(i).getText();
			if(value.contains("selenium"))
			{
				list.get(i).click();
			}
		}
	}

}
