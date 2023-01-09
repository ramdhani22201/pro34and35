package testDemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class MouseAction extends Base{

	WebDriver driver;
	//Properties prop;
	@BeforeMethod
	public void lunchApplication() throws IOException
	{
		driver = intializeDrive();
		driver.get("http://omayo.blogspot.com/");
	}
	
	
	
	@Test
	public void testMoveToElement() throws InterruptedException
	{
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.id("blogsmenu"));
		Thread.sleep(2000);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void testDoubleClick()
	{
		Actions act = new Actions(driver);
		WebElement elementDoubleClick = driver.findElement(By.xpath("//button[contains(text(), 'Double click Here')]"));
		act.doubleClick(elementDoubleClick).perform();
	}
	
	@Test
	public void testRightClick()
	{
		Actions act = new Actions(driver);
		WebElement menuElement = driver.findElement(By.id("blogsmenu"));
		act.contextClick(menuElement).perform();
	};
	
	@Test
	public void testWindowScrollupAndDown() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-800)");
	}
	
	@Test
	public void testWindowScrollHight()
	{
		//bottom of the window screen browser
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}
	
    @Test
    public void testScrollonParticularElement()
    {
    	WebElement eleButton = driver.findElement(By.xpath("//button[contains(text(),'Check this')]"));
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	jse.executeScript("arguments[0].scrollIntoView()",eleButton);
    }
 	@AfterMethod
	public void appClosuer() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
