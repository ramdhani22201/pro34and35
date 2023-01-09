package testScript;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPageVari;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	WebDriver driver;
	Logger log;  
	
	@BeforeMethod
	public void startUp() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = intializeDrive();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigate to application");
	}
	@Test(dataProvider = "getLoginData")
	public void login(String email,String pass, String expected) throws IOException, InterruptedException
	{
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		log.debug("Click on My Account DropDown");
		landingPage.loginOption().click();
		log.debug("Click on Login Option");
		
		//Thread.sleep(1000);
		//login credential page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailTextField().sendKeys(email);
		log.debug("Enter eamil id");
		loginPage.passwordTextField().sendKeys(pass);
		log.debug("Enter Password");
		loginPage.loginButton().click();
		log.debug("Click on Login Button");
		
		//Nevigate on Account Page
		AccountPageVari accountPageVari = new AccountPageVari(driver);
		//Verification 
		String actualResult =null;
		try
		{
			if(accountPageVari.myAccountPage().isDisplayed())
			{
			actualResult = "Successfull";
			log.debug("Logged in User");
			}
		}
		catch(Exception e)
		{
			actualResult = "Failure";
			log.debug("Login Failed");
		}
		Assert.assertEquals(actualResult,expected);
		//Thread.sleep(1000);
		
		
		
		
	}
	

	
	@DataProvider
	public Object [][] getLoginData()
	{
		Object [][] data = {{"ramdhani222222@gmail.com","Ram@123","Successfull"},{"ramdhani222@gmail.com","Ram@123","Failure"}};
		
		return data;
		
		
	}
		
	
	@AfterMethod
	public void closure()
	{
		driver.quit();
		log.debug("Browser Closed");
	}
}
