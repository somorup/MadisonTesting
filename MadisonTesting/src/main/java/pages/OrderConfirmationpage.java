package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationpage {
	private WebDriver driver=null;
	@FindBy(xpath="//div[@class='page-title']")
	private WebElement chechouttitle;
	
	public OrderConfirmationpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String assert_chechouttitle() {
		return chechouttitle.getText();
	}
}