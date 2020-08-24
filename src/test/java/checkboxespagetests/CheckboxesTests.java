package checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestUtilities;
import pages.CheckboxesPage;
import pages.WelcomePage;

public class CheckboxesTests extends TestUtilities{

	@Test
	public void selectingTwoCheckboxesTest() {
		log.info("Starting checkboxes test:");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
		checkboxesPage.selectAllCheckboxes();
		
		Assert.assertTrue(checkboxesPage.areAllCheckboxesSelected(), "Not all checkboxes are selected!");
		
	}
	
}
