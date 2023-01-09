package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	WebElement emailTextField;
	public WebElement emailTextField()
	{
		return emailTextField;
	}
	
	@FindBy(id = "input-password")
	WebElement passwordTextField;
	public WebElement passwordTextField()
	{
		return passwordTextField;
	}
	
	@FindBy(xpath = "//input[@type ='submit']")
	WebElement loginButton;
	public WebElement loginButton()
	{
		return loginButton;
	}
}
