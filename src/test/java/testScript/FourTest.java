package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base{

	public WebDriver driver;
	@BeforeMethod
	public void lunchBrowser() throws IOException
	{
		driver = intializeDrive();
		
	}
	@Test
	public void TestFour()
	{
		driver.get(prop.getProperty("url"));
		Assert.assertTrue(false);
		System.out.println("TestFour");
	}
	@AfterMethod
	public void closuer()
	{
		driver.close();
	}
}
