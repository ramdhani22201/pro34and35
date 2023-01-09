package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccount {

	WebDriver driver;
	public RegisterAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath =  "//a[contains(text(),'login page')]")
	WebElement loginPageLink;
	public WebElement loginPageLink(){return loginPageLink;}
	
	@FindBy(id = "input-firstname")
	WebElement firstNameField;
	public WebElement firstNameField(){ return firstNameField;}
	
	@FindBy(id = "input-lastname")
	WebElement lastNameField;
	public WebElement lastNameField(){return lastNameField;}
	
	@FindBy(id = "input-email")
	WebElement emailField;
	public WebElement emailField (){return emailField;}
	
	@FindBy(id = "input-telephone")
	WebElement telphoneField;
	public WebElement telphoneField(){return telphoneField;}
	
	@FindBy(id = "input-password")
	WebElement passwordFeild;
	public WebElement passwordFeild(){return passwordFeild;}
	
	@FindBy(id = "input-confirm")
	WebElement confirmpasswordFeild;
	public WebElement confirmpasswordFeild(){return confirmpasswordFeild;}
	
	@FindBy(name = "agree")
	WebElement policyCheckbox;
	public WebElement policyCheckbox(){return policyCheckbox;}
	
	@FindBy(xpath = "//input[@type ='submit']")
	WebElement continueButton;
	public WebElement continueButton() {return continueButton;}
	
	
	
}
