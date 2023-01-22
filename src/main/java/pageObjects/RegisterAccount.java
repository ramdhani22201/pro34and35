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
	private WebElement loginPageLink;
	public WebElement loginPageLink(){return loginPageLink;}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	public WebElement firstNameField(){ return firstNameField;}
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	public WebElement lastNameField(){return lastNameField;}
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	public WebElement emailField (){return emailField;}
	
	@FindBy(id = "input-telephone")
	private WebElement telphoneField;
	public WebElement telphoneField(){return telphoneField;}
	
	@FindBy(id = "input-password")
	private WebElement passwordFeild;
	public WebElement passwordFeild(){return passwordFeild;}
	
	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordFeild;
	public WebElement confirmpasswordFeild(){return confirmpasswordFeild;}
	
	@FindBy(name = "agree")
	private WebElement policyCheckbox;
	public WebElement policyCheckbox(){return policyCheckbox;}
	
	@FindBy(xpath = "//input[@type ='submit']")
	private WebElement continueButton;
	public WebElement continueButton() {return continueButton;}	
}
