package loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestUtilities;
import pages.LoginPage;
import pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

	@Test
	public void invalidLogin() {
		log.info("Starting invalid login:");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		loginPage.negativeLogIn("invalid", "user");
		
		loginPage.waitForErrorMessage();
	
		String expectedMessage = "Your username is invalid!";
		String currentMessage = loginPage.getInvalidLoginMessageText();
		Assert.assertTrue(currentMessage.contains(expectedMessage), "Message not found!");
	}
	
}
