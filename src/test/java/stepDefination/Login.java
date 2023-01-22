package stepDefination;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPageVari;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import testScript.LoginTest;
import resources.Base;
public class Login extends Base{

	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPageVari accountPageVari;
	Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	@Given("^Open any Browser$")
    public void open_any_browser() throws Throwable {
		driver = intializeDrive();
		log.debug("Browser got launched");
    }
	
	@And("^Navigate to Login page$")
	public void navigate_to_login_page() throws Throwable {
		driver.get(prop.getProperty("url"));
		log.debug("Navigate to application");
		
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		log.debug("Click on My Account DropDown");
		landingPage.loginOption().click();
		log.debug("Click on Login Option");
	}

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password) throws Throwable {
    	loginPage = new LoginPage(driver);
		loginPage.emailTextField().sendKeys(email);
		log.debug("Enter email id");
		loginPage.passwordTextField().sendKeys(password);
		log.debug("Enter Password");
		
    }
    
    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() throws Throwable {
    	loginPage.loginButton().click();
		log.debug("Click on Login Button");
    }

    @Then("^verify user is able to susscessfully login$")
    public void verify_user_is_able_to_susscessfully_login() throws Throwable {
    	accountPageVari = new AccountPageVari(driver);
    	//assert.assertTrue(accountPageVari.myAccountPage().isDisplayed(), true);
    	Assert.assertTrue(accountPageVari.myAccountPage().isDisplayed());
//    	String actualResult =null;
//		try
//		{
//			if(accountPageVari.myAccountPage().isDisplayed())
//			{
//			actualResult = "Successfull";
//			log.debug("Logged in User");
//			}
//		}
//		catch(Exception e)
//		{
//			actualResult = "Failure";
//			log.debug("Login Failed");
//		}
//		Assert.assertEquals(actualResult,expected);
    	
    }
    @After
    public void closeBrowser()
    {
    	driver.close();
    }


}
