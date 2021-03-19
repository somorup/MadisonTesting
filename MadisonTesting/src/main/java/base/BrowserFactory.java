package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Constants.constants;


public class BrowserFactory {
	

	public static WebDriver setWebDriver(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(constants.CHROME_PROPERTY, constants.CHROME_PATH);
			driver = new ChromeDriver();
		}
		/*else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(constants.GECKO_PROPERTY, constants.GECKO_PATH);
			driver = new FirefoxDriver();
		}*/
		else
			System.out.println("Enter Browser properly");
		return driver;

	}
}
