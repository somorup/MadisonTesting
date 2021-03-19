package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {
	private WebDriver driver = null;
	@FindBy(xpath = "(//a[@title='Silver Desert Necklace'])[2]")
	private WebElement productBy;

	public ProductsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectproductBy() {
		try {
			productBy.click();
		} catch (NoSuchElementException exception) {
			System.out.println(exception.getStackTrace());
		}
	}
}
