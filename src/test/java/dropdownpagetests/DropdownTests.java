package dropdownpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestUtilities;
import pages.DropdownPage;
import pages.WelcomePage;

public class DropdownTests extends TestUtilities{

	@Test
	public void selectOptionOneTest() {
		log.info("Starting Select Option One Test case:");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		DropdownPage dropdownPage = welcomePage.clickDropdownLink();
		
		dropdownPage.selectOption(1);
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals("Option 1"), "Option 1 not selected!");
	}
	
}
