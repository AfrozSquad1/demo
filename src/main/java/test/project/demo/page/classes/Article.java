package test.project.demo.page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Article extends BasePage {

	public Article(WebDriver driver) {
		super(driver);
		
	}

	
	//Page Locators
	BasePage bPage=new BasePage(driver);
	private By articleComment=By.xpath("//textarea[@placeholder='Write a comment...']");
	private By postCommentBtn=By.xpath("//button[@class='btn btn-sm btn-primary']");
	private By articleLink=By.xpath("//h1[text()='TestArcticle']");
	private By postedArticleText=By.xpath("//p[text()='Test...!!!']");
	
	public WebElement getArticleComment() {
		return getWebElement(articleComment);
	}
	
	public WebElement getPostCommentBtn() {
		return  getWebElement(postCommentBtn);
	}
	
	public WebElement getArticleLink() {
		return getWebElement(articleLink);
	}
	
	public WebElement getPostedArticleText() {
		return getWebElement(postedArticleText);
	}
	
	public  String getPostedArticle(){
		bPage.waitForWeblEmentPresent(postedArticleText);
		return getPostedArticleText().getText();
		
	}
	

	public String getArticlePageTitle() {
		return getPageTitle(); //TestArticle - Conduit
		
	}
	
	public String getArticlePageHeader() {
		return getPageHeader(articleLink);
	}
	
	public String doPostArticle(String articleComment){
		getArticleComment().sendKeys(articleComment);
		getPostCommentBtn().click();
		return getPostedArticle();
		
		
	}
	
	

	
	
	
	
}
