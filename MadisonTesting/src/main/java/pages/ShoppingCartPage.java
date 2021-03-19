package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.UtilClass;

public class ShoppingCartPage {
	private WebDriver driver = null;
	@FindBy(xpath = "//select[@id='country']")
	private WebElement countryBy;
	@FindBy(xpath = "//input[@id='region']")
	private WebElement regionBy;
	@FindBy(xpath = "//input[@id='city']")
	private WebElement cityBy;
	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement pincodeBy;
	@FindBy(xpath = "(//button[@class='button btn-proceed-checkout btn-checkout'])[2]")
	private WebElement checkoutbuttonBy;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setAddress(String country, String region, String city, String pin) {
		try {
			UtilClass.dropdown(countryBy, country);
			regionBy.sendKeys(region);
			cityBy.sendKeys(city);
			pincodeBy.sendKeys(pin);
			checkoutbuttonBy.click();
		} catch (NoSuchElementException exception) {
			System.out.println(exception.getStackTrace());
		}
	}

	public void setregionBy(String region) {
		regionBy.sendKeys(region);
	}

	public void setcityBy(String city) {
		cityBy.sendKeys(city);
	}

	public void setpincodeBy(String pin) {
		pincodeBy.sendKeys(pin);
	}

	public void click_checkoutbuttonBy() {
		checkoutbuttonBy.click();
	}
}
