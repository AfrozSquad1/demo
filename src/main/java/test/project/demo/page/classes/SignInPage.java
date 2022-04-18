package test.project.demo.page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage{

	public SignInPage(WebDriver driver) {
		super(driver);
		
	}
		BasePage bPage=new BasePage(driver);
		//Page Locators
		private By signInLink=By.xpath("//a[@class='nav-link' and @href='#/login']");
		private By emailText=By.xpath("//input[@type='email']");
		private By passwordText=By.xpath("//input[@type='password']");
		private By signInBtn=By.xpath("//button[@type='submit']");
		private By needAnAccountLink=By.xpath("//a[@ng-show=\\\"$ctrl.authType === 'register'\\\" and @href='#/login'] ");
		private By signInPageHeader=By.xpath("//h1[text()='Sign in']");
		private By signOutBtn=By.xpath("//button[@class='btn btn-outline-danger']");
		private By settingsLink=By.xpath("//a[@class='nav-link active']");
		private By chkLogoutText=By.xpath("//p[text()='A place to share your knowledge.']");
		
		
		public WebElement getChkLogoutText() {
			return getWebElement(chkLogoutText);
		}



		public WebElement getSignOutBtn() {
			return getWebElement(signOutBtn);
		}



		public WebElement getSettingsLink() {
			return getWebElement(settingsLink);
		}



		public WebElement getSignInLink() {
			return getWebElement(signInLink);
		}

	

		public WebElement getEmailText() {
			return getWebElement(emailText);
		}

	

		public WebElement getPasswordText() {
			return getWebElement(passwordText);
		}

		

		public WebElement getSignInBtn() {
			return getWebElement(signInBtn);
		}

		
		public WebElement getHaveAnAccountLink() {
			return getWebElement(needAnAccountLink);
		}

		

		public String getSignInPageHeader() {
			return getPageHeader(signInPageHeader);
		}

		

		public String getSignInPageTitle() {
			return getPageTitle(); //"Sign in - Conduit"
			
		}
		
		
		
		public HomePage doSignIn(String userEmail,String userPassword) {
			getSignInLink().click();
			bPage.waitForWeblEmentPresent(emailText);
			getEmailText().sendKeys(userEmail);
			getPasswordText().sendKeys(userPassword);
			getSignInBtn().click();
			return getInstance(HomePage.class);
		}
		
		//Negative scenario
		public void doSignIn() {
			getEmailText().sendKeys("");
			getPasswordText().sendKeys("");
			getSignInBtn().click();
			
		}
		
		
		public String doSignOut() {
			getSettingsLink().click();
			getSignOutBtn().click();
			bPage.waitForWeblEmentPresent(chkLogoutText);
			return getChkLogoutText().getText();
			
		}
		


}
