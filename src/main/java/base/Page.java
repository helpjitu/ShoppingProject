package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilities.ExcelReader;
import utilities.Utilities;

public class Page {
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger();
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");

	public static void initConfiguration() {
		if (Constants.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver");
			driver = new ChromeDriver();
			log.debug("Launching Chrome");

		}
		driver.get(Constants.testSiteUrl);
		driver.manage().window().maximize();
//		driver.switchTo().defaultContent();
		Actions actions = new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.click().sendKeys(Keys.ESCAPE);

	}

	public static void clickElement(WebElement element) {
		element.click();
		log.info("Clicking on an Element: " + element);
	}

	public static void type(WebElement element, String value) {
		element.sendKeys(value);
		log.info("Entering the value as: " + value + " for the element: " + element);
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
