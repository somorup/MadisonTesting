package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilClass;

public class HomePage {
	private WebDriver driver = null;
	@FindBy(xpath = "//div[@class='block-content']//ul//li[@class='current']//a//strong")
	private WebElement dashboardBy;
	@FindBy(xpath = "//div[@class='welcome-msg']//p[@class='hello']//strong")
	private WebElement assertcheckBy;
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchproducts;
	@FindBy(xpath = "//button[@class='button search-button']")
	private WebElement clicksearch;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Home_Page(String search) {
		try {
			UtilClass.Explicit_wait(dashboardBy, driver);
			dashboardBy.click();
			searchproducts.click();
			searchproducts.sendKeys(search);
			clicksearch.click();
		} catch (NoSuchElementException exception) {
			System.out.println(exception.getStackTrace());
		}
	}

	public WebDriver driver() {
		return driver;
	}

	public String assert_login() {
		return assertcheckBy.getText();

	}
}
