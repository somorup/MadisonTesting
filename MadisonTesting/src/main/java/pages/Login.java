package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilClass;

public class Login {

	protected WebDriver driver = null;

	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement accountBy;
	@FindBy(xpath = "//div[@class='links']//ul//li[@class=' last']//a")
	private WebElement loginBy;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailidBy;
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement passwordBy;
	@FindBy(xpath = "//button[@id='send2']")
	private WebElement loginbuttonBy;
	@FindBy(xpath = "//a[@title='Log Out']")
	private WebElement logoutbuttonBy;
	@FindBy(xpath = "//div[@class='welcome-msg']//p[@class='hello']//strong")
	private WebElement assertcheckBy;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login_To_Page(String email, String password) {
		try {
			UtilClass.Explicit_wait(accountBy, driver);
			accountBy.click();
			loginBy.click();
			emailidBy.sendKeys(email);
			passwordBy.sendKeys(password);
			loginbuttonBy.click();
		} catch (NoSuchElementException exception) {
			System.out.println(exception.getStackTrace());
		}

	}

	public WebDriver returndriver() {
		return driver;
	}

	public String Assert_Login() {
		return assertcheckBy.getText();
	}

	public void Logout() {
		accountBy.click();
		logoutbuttonBy.click();
	}

}
