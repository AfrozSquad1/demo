package test.project.demo.page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 20);

	}
	//use of abstractions
	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getWebElement(By locator);

	public abstract void waitForWeblEmentPresent(By locator);

	public abstract void waitForPageTitle(String title);
	//To make it more generic, utilized generic feature.
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {

		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
