package test.project.demo.page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SignUpPage extends BasePage {
		
	public SignUpPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	BasePage bPage=new BasePage(driver);
	//Page Locators
	private By signUpLink=By.xpath("//a[@href='#/register']");
	private By userNameText=By.xpath("//input[@placeholder='Username']");
	private By userEmailText=By.xpath("//input[@placeholder='Email']");
	private By userPasswordText=By.xpath("//input[@placeholder='Password' and @type='password']");
	private By userSignUpBtn=By.xpath("//button[@type='submit']");
	private By haveAnAccountLink=By.xpath("//a[@ng-show=\"$ctrl.authType === 'register'\" and @href='#/login']");
	private By signUpPageHeader=By.xpath("//h1[text()='Sign up']");
	
	
	public WebElement getSignUpLink() {
		return getWebElement(signUpLink);
	}

	public WebElement getUserNameText() {
		return getWebElement(userNameText) ;
	}
	public WebElement getUserEmailText() {
		return getWebElement(userEmailText);
	}
	public WebElement getUserPasswordText() {
		return getWebElement(userPasswordText);
	}
	public WebElement getUserSignUpBtn() {
		return getWebElement(userSignUpBtn);
	}
	public WebElement getHaveAnAccountLink() {
		return getWebElement(haveAnAccountLink);
	}
	public WebElement getHeader() {
		return getWebElement(signUpPageHeader);
	}
	
	public String getSignUpPageTitle() {
		return getPageTitle();
		
	}
	
	public String getSignupPageHeader() {
		return getPageHeader(signUpPageHeader);
	}
	
	public HomePage doSignUp(String userName,String emailId,String password) {
		bPage.waitForWeblEmentPresent(userNameText);
		getUserNameText().sendKeys(userName);
		getUserEmailText().sendKeys(emailId);
		getUserPasswordText().sendKeys(password);
		getUserSignUpBtn().click();
		return getInstance(HomePage.class);
		
		
	}
	
	//Overloaded method for negative Scenario
	public void doSignUp() {
		getUserNameText().sendKeys("");
		getUserEmailText().sendKeys("");
		getUserPasswordText().sendKeys("");
		getUserSignUpBtn().click();
		
		
	}
	
	
	
}

