package test.project.demo.tests.classes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import test.project.demo.page.classes.BasePage;
import test.project.demo.page.classes.Page;
import test.project.demo.utility.ConfigReader;

public class BaseTest {

	public WebDriver driver;
	public Page page;
	public static Logger logger;
	ConfigReader config=new ConfigReader();

	@BeforeClass
	@Parameters(value = { "browser" })
	public void setupTest(String browser) {

		logger = Logger.getLogger("demoProject");
		PropertyConfigurator.configure("log4j.properties");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("No browser defined !!!");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(config.getBaseApplicationUrl());
		
		page = new BasePage(driver);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
