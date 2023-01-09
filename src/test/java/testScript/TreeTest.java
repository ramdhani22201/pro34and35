package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class TreeTest extends Base {

	WebDriver driver;
	@BeforeMethod
	public void lunchBrowser() throws IOException
	{
		driver = intializeDrive();
		
	}
	@Test
	public void TestTree()
	{
		driver.get(prop.getProperty("url"));
		System.out.println("TestTree");
	}
	
	@AfterMethod
	public void closuer()
	{
		driver.close();
	}
}
