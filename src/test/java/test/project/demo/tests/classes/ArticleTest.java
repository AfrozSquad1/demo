package test.project.demo.tests.classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import test.project.demo.page.classes.Article;

import test.project.demo.page.classes.SignInPage;

public class ArticleTest extends BaseTest{
	
	
	
	@Test(priority=1, enabled=true)
	public void verifyPostedArticle()
	{
		page.getInstance(SignInPage.class).doSignIn(config.getUserEmail(), config.getPassword());
		String postedArticle=page.getInstance(Article.class).doPostArticle("Please Share your Thoughts !!!");
		Assert.assertEquals(postedArticle, "Please Share your Thoughts !!!");
	}
}
