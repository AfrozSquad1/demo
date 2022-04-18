package test.project.demo.tests.classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.project.demo.page.classes.Article;
import test.project.demo.page.classes.HomePage;
import test.project.demo.page.classes.SignInPage;
import test.project.demo.utility.ConfigReader;
import test.project.demo.utility.DataProviderClass;

public class HomePageTest extends BaseTest {
	
	ConfigReader config=new ConfigReader();
	
	@DataProvider
	public Object [][] getArticleData() throws IOException{
		Object [][] testData =DataProviderClass.getData("testData");
		return testData;
		
		
	}
	
	
	@Test(priority=1, dataProvider = "getArticleData")
	public void doPostNewArticleTest(String artTitle, String artAbout,String artContent, String tag){
		HomePage homePage=page.getInstance(SignInPage.class).doSignIn(config.getUserEmail(), config.getPassword());
		Article artObj=homePage.doPostNewArticle(artTitle, artAbout, artContent, tag);
		String postedArticle=artObj.getPostedArticle();
		Assert.assertEquals(postedArticle, "Test Article !!!");
		
	
	}
	
	@Test(priority=2)
	public void postCommentOnArticle(){
		HomePage homePage=page.getInstance(SignInPage.class).doSignIn(config.getUserEmail(), config.getPassword());
		String commentedText=homePage.postedCommentOnArticle("Test 4321!!!");
		Assert.assertEquals(commentedText, "Test 4321!!!");

	}
	
	@Test(priority=3)
	public void makeArticleFavorateTest(){
		HomePage homePage=page.getInstance(SignInPage.class).doSignIn(config.getUserEmail(), config.getPassword());
		Assert.assertTrue(homePage.makeArticleFavorate());
		
	}
	
	@Test(priority=4)
	public void doFollowArticleTest(){
		HomePage homePage=page.getInstance(SignInPage.class).doSignIn(config.getUserEmail(), config.getPassword());
		Assert.assertTrue(homePage.doFollowArticle());
		
	}
}
