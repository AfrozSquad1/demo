package test.project.demo.tests.classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import test.project.demo.page.classes.HomePage;
import test.project.demo.page.classes.SignUpPage;
import test.project.demo.utility.ConfigReader;

public class SignUpTest extends BaseTest {
	
	ConfigReader configReader= new ConfigReader();
	
	
	@Test(priority=1)
	public void doSignUpTest(){
		logger.info("Sign Up process is in Progress...!!!");
		HomePage homePage=page.getInstance(SignUpPage.class).doSignUp(configReader.getUsername(), configReader.getUserEmail(),configReader.getPassword());
		logger.info("Sign Up process Completed!!!");
		String homePageTitle=homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home-Conduit");
	}

}
