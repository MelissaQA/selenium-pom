package loginpagetests;

import org.testng.annotations.Test;
import org.testng.Assert;

import base.TestUtilities;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void loginTest() {
		log.info("Starting valid login test: ");
	
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
		
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
	
}
