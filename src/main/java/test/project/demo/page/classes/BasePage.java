package test.project.demo.page.classes;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public static Logger logger;
	
	public BasePage(WebDriver driver) {
		super(driver);
		logger=Logger.getLogger("demoProject");
		PropertyConfigurator.configure("log4j.properties");

	}

	@Override
	public String getPageTitle() {

		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {

		return getWebElement(locator).getText();
	}

	@Override
	public WebElement getWebElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;

		} catch (Exception e) {
			logger.info("some exception occured"+ locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForWeblEmentPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		} catch (Exception e) {
		
			logger.info("some exception occured"+ locator.toString());
			e.printStackTrace();

		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			logger.info("some exception occured"+ title);
			e.printStackTrace();
		}

	}

}
