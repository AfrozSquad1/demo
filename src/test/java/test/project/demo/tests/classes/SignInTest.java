package test.project.demo.tests.classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import test.project.demo.page.classes.HomePage;
import test.project.demo.page.classes.SignInPage;
import test.project.demo.utility.ConfigReader;

public class SignInTest extends BaseTest{
	
	ConfigReader config=new ConfigReader();
	
	@Test(priority=1)
	public void doLogInTest() {
		logger.info("Verifying SignIn functionality and post loging Home page header !!!");
		HomePage homePage=page.getInstance(SignInPage.class).doSignIn(config.getUserEmail(), config.getPassword());
		String pageHeader=homePage.getHomePageHeader();
		logger.info("HomePage Header: "+pageHeader);
		Assert.assertEquals(pageHeader,"conduit");
		
	}
	
	@Test(priority=2,enabled=true)
	public void verifyLoginPageTitleTest() {
		logger.info("Verifying SignIn Page Page Haeder !!!");
		String pageTitle=page.getInstance(SignInPage.class).getSignInPageTitle();
		logger.info("Sign In  Page Title:"+pageTitle);
		Assert.assertEquals(pageTitle, "Sign in — Conduit");
	}

	@Test(priority=3,enabled=true)
	public void verifyLoginPageHeaderTest() {
		logger.info("Verifying SignIn Page  Header !!!");
		String pageHeader=page.getInstance(SignInPage.class).getSignInPageHeader();
		logger.info("Sign In Page Header :"+pageHeader);
		Assert.assertEquals(pageHeader, "Sign in");
	}
	
	@Test(priority=4,enabled=true)
	public void doLogoutTest() {
		logger.info("Logging Out !!!");
		String logOutText=page.getInstance(SignInPage.class).doSignOut();
		
		logger.info("Post succesfull log out.. Validating text :"+logOutText);
		Assert.assertEquals(logOutText, "A place to share your knowledge.");
	}
}
