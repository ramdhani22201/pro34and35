package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPageVari {

	WebDriver driver;
	public AccountPageVari(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	private WebElement  myAccountPage;
	public WebElement myAccountPage()
	{
		return myAccountPage;
	}
	
}
