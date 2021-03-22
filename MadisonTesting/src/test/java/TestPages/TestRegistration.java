package TestPages;

import org.testng.annotations.Test;

import org.testng.Assert;
import java.io.IOException;
import java.util.Map;

import base.TestBase;

import pages.Registration;
import utility.ScreenShot;

public class TestRegistration extends TestBase {
	ScreenShot screenshot = new ScreenShot();

	@Test(dataProviderClass = utility.Data_Provider.class, dataProvider = "Madison")
	public void Valid_And_Invalid_Registration(Map<String, String> mapData) throws IOException, InterruptedException {

		Registration registration = new Registration(this.driver);

		registration.Registration_To_Page(mapData.get("firstname"), mapData.get("middlename"), mapData.get("lastname"),
				mapData.get("emailid"), mapData.get("password"), mapData.get("confirmpassword"));
		registration.getWelcomemessage();
		Assert.assertEquals(registration.getWelcomemessage(), "Thank you for registering with Madison Island.");
		//ScreenShot.screenShot(driver, constants.SCREENSHOT_PASS);
		//login.Logout();

	}
}
