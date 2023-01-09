package testDemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.Base;

public class BrokenLinkTest extends Base {
	
	@Test
	public void TestTwo() throws IOException, InterruptedException
	{
		WebDriver driver;
		driver = intializeDrive();
		driver.get(prop.getProperty("url"));
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			//System.out.println(url);
			//System.out.println(url.length());
			if(url == null || url.isEmpty())
			{
				System.out.println("This url is Empty");
				continue;
			}
			try
			{
				URL siteUrl =new URL(url);
				
				HttpURLConnection huc = (HttpURLConnection) siteUrl.openConnection();
				huc.connect();
				if(huc.getResponseCode() >= 400)
				{
					System.out.println(url + "  is broken");
				}
				else
				{
					System.out.println(url + "  is valid");
				}
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
		}
		
		
		
		Thread.sleep(2000);
		driver.close();
	}

}
