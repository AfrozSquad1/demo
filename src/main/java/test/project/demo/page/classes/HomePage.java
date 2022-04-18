package test.project.demo.page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	
	BasePage bPage=new BasePage(driver);
	// PIntentionally not using @FindBy and PageFactory.initelements. 
	private By newArticle = By.xpath("//a[@href='#/editor/']");
	private By articleTitle = By.xpath("//input[@placeholder='Article Title']");
	private By articleAbout = By.xpath("//input[@ng-model='$ctrl.article.description']");
	private By writeYourArcticle = By.xpath("//textarea[@ng-model='$ctrl.article.body']");
	private By tags = By.xpath("//input[@placeholder='Enter tags']");
	private By publishArticleBtn = By.xpath("//button[@ng-click='$ctrl.submit()']");
	private By yourFeed = By.xpath("//div[@class='feed-toggle']/ul/li[1]/a[1]");
	private By globalFeed = By.xpath("//div[@class='feed-toggle']/ul/li[2]/a[1]");
	private By articleNewImplementation = By
			.xpath("//h1[@class='ng-binding' and text()='Create a new implementation']");
	private By favArticle = By.xpath(
			"//div[@class='article-actions']/article-actions/article-meta/div/ng-transclude/span[2]/favorite-btn/button");
	private By followBtn = By.xpath(
			"//div[@class='article-actions']/article-actions/article-meta/div/ng-transclude/span[2]/follow-btn/button");
	private By writeCommentOnArticle = By.xpath("//textarea[@placeholder='Write a comment...']");
	private By postCommentBtn = By.xpath("//button[@class='btn btn-sm btn-primary']");
	private By existingArticleLink = By.xpath("//h1[text()='TestArcticle']");
	private By homePageHeaderText=By.xpath("//a[@class='navbar-brand ng-binding' and text()='conduit']");
	private By posttedCommentText=By.xpath("//p[text()='Test 4321!!!']");

	

	public WebElement getPosttedCommentText() {
		return getWebElement(posttedCommentText);
	}
	
	public WebElement getWriteCommentOnArticle() {
		return getWebElement(writeCommentOnArticle);
	}

	public WebElement getPostCommentBtn() {
		return getWebElement(postCommentBtn);
	}

	public WebElement getNewArcticle() {
		return getWebElement(newArticle);

	}

	public WebElement getArticleTitle() {
		return getWebElement(articleTitle);

	}

	public WebElement getArticleAbout() {
		return getWebElement(articleAbout);

	}

	public WebElement getWriteYourArcticle() {
		return getWebElement(writeYourArcticle);

	}

	public WebElement getTags() {
		return getWebElement(tags);

	}

	public WebElement getPublishArticleBtn() {
		return getWebElement(publishArticleBtn);

	}

	public WebElement getYourFeed() {
		return getWebElement(yourFeed);

	}

	public WebElement getGlobalFeed() {
		return getWebElement(globalFeed);

	}

	public WebElement getArticleNewImplementation() {
		return getWebElement(articleNewImplementation);

	}

	public WebElement getFavArticle() {
		return getWebElement(favArticle);

	}

	public WebElement getFollowBtn() {
		return getWebElement(followBtn);

	}

	public WebElement getExistingArticleLink() {
		return getWebElement(existingArticleLink);

	}
	
	public WebElement getHomePageHeaderText() {
		return getWebElement(homePageHeaderText);
	}

	public Article doClickOnExistingArticleLink() {
		getExistingArticleLink().click();
		return getInstance(Article.class);
	}

	public void doClickOnNewArticleLink() {
		getNewArcticle().click(); // user will get editor form

	}

	public Article doPostNewArticle(String artTitle,String artAbout,String article,String artTag) {
		bPage.waitForWeblEmentPresent(newArticle);
		doClickOnNewArticleLink();
		bPage.waitForWeblEmentPresent(articleTitle);
		getArticleTitle().sendKeys(artTitle);
		getArticleAbout().sendKeys(artAbout);
		getWriteYourArcticle().sendKeys(article);
		getTags().sendKeys(artTag);
		getPublishArticleBtn().click();

		return getInstance(Article.class);

	}

	public void navigateToYourFeed() {
		getYourFeed().click();
	}

	public void navigateToGlobalFeed() {
		bPage.waitForWeblEmentPresent(globalFeed);
		getGlobalFeed().click();
	}

	public void navigateToExistingGlobalFeedArticle() {
		bPage.waitForWeblEmentPresent(articleNewImplementation);
		getArticleNewImplementation().click();
	}

	public boolean makeArticleFavorate() {
		boolean flag=false;
		navigateToGlobalFeed();
		navigateToExistingGlobalFeedArticle();
		if(!flag) {
			getFavArticle().click();
			logger.info("Article Marked as Favourate!!");
			flag=true;
		}
		
		
		return flag;
	}

	public boolean doFollowArticle() {
		boolean flag=false;
		navigateToGlobalFeed();
		navigateToExistingGlobalFeedArticle();
		if(!flag) {
			getFollowBtn().click();
			logger.info("Article followed!!");
			flag=true;
		}
		
		
		return flag;
	}

	public String postedCommentOnArticle(String artComment) {
		navigateToGlobalFeed();
		navigateToExistingGlobalFeedArticle();
		getWriteCommentOnArticle().sendKeys(artComment);
		getPostCommentBtn().click();
		return getPosttedCommentText().getText();
	}
	
	public String getHomePageTitle() {
		return getPageTitle(); //"Home - Conduit"
		
	}
	
	public String getHomePageHeader() {
		return getPageHeader(homePageHeaderText);
	}

}
