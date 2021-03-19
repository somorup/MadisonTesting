package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilClass;

public class Registration {
	protected WebDriver driver = null;
	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement accountBy;
	@FindBy(xpath = "//div[@id='header-account']//div//ul//li//a[@title='Register']")
	private WebElement registerBy;
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstnameBy;
	@FindBy(xpath = "//input[@id='middlename']")
	private WebElement middlenameBy;
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastnameBy;
	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement emailidBy;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordBy;
	@FindBy(xpath = "//input[@id='confirmation']")
	private WebElement confirmpasswordBy;
	@FindBy(xpath = "//button[@class='button']")
	private WebElement registerbuttonBy;
	@FindBy(xpath = "//span[contains(text(),'Thank you for registering with Madison Island.')]")
	private WebElement assertcheckBy;

	public Registration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Registration_To_Page(String firstname, String middlename, String lastname, String emailid,
			String password, String confirmpassword) {
		try {
			UtilClass.Explicit_wait(accountBy, driver);
			accountBy.click();
			registerBy.click();
			firstnameBy.sendKeys(firstname);
			middlenameBy.sendKeys(middlename);
			lastnameBy.sendKeys(lastname);
			emailidBy.sendKeys(emailid);
			passwordBy.sendKeys(password);
			confirmpasswordBy.sendKeys(confirmpassword);
			registerbuttonBy.click();
		} catch (NoSuchElementException exception) {
			System.out.println(exception.getStackTrace());
		}

	}

	public String assertcheckBy() {
		return assertcheckBy.getText();
	}

}
