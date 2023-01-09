package testScript;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountSuccessPage;
import pageObjects.LandingPage;
import pageObjects.LandingRegister;
import pageObjects.RegisterAccount;
import resources.Base;

public class RegisterTest extends Base {
	WebDriver driver;

	@BeforeMethod
	public void startUp() throws IOException {
		driver = intializeDrive();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "dp")
	public void textRegister(String data) throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();

		LandingRegister landingRegister = new LandingRegister(driver);
		landingRegister.registerOption().click();

		String actual_Title = driver.getTitle();
		String expected_Title = "Register Account";
		Assert.assertEquals(actual_Title, expected_Title);

		
		 String regAcc [] = data.split(","); RegisterAccount registerAccount = new
		 RegisterAccount(driver);
		 registerAccount.firstNameField().sendKeys(regAcc[0]);
		 registerAccount.lastNameField().sendKeys(regAcc[1]);
		 registerAccount.emailField().sendKeys(regAcc[2]);
		 registerAccount.telphoneField().sendKeys(regAcc[3]);
		 registerAccount.passwordFeild().sendKeys(regAcc[4]);
		 registerAccount.confirmpasswordFeild().sendKeys(regAcc[5]);
		 registerAccount.policyCheckbox().click(); Thread.sleep(2000);
		 registerAccount.continueButton().click();
		  
		 AccountSuccessPage accSuccess = new AccountSuccessPage(driver);
		 boolean bsuccess = accSuccess.successMessage().isDisplayed();
		 Assert.assertTrue(bsuccess);
		Thread.sleep(2000);
	}

	@DataProvider(name = "dp")
	public String[] readJson() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\jsonFiles\\registerTestData.json");

		Object obj = jsonParser.parse(reader);
		JSONObject userregisterJsonObject = (JSONObject) obj;
		JSONArray userregisterArray = (JSONArray) userregisterJsonObject.get("userregister");

		String arr[] = new String[userregisterArray.size()];

		for (int i = 0; i < userregisterArray.size(); i++) {
			JSONObject registers = (JSONObject) userregisterArray.get(i);

			String firstname = (String) registers.get("firstname");
			String lasename = (String) registers.get("lasename");
			String emailid = (String) registers.get("emailid");
			String telephone = (String) registers.get("telephone");
			String password = (String) registers.get("password");
			String confirmpassword = (String) registers.get("confirmpassword");

			arr[i] = firstname + "," + lasename + "," + emailid + "," + telephone + "," + password + ","
					+ confirmpassword;

		}

		return arr;

	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}

}
