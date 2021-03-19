package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {

	protected static WebDriver driver;

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	public static void dropdown(WebElement path,String value) {
		Select drop = new Select(path);
		drop.selectByValue(value);
	}

	public static void Explicit_wait(WebElement element, WebDriver explicitdriver) {
		try {
			WebDriverWait wait = new WebDriverWait(explicitdriver, 30);
			if (!element.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(element));
			}
		} catch (NoSuchElementException no) {
			no.printStackTrace();
		}
	}
}
