package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {
		
	private String pageUrl = "http://the-internet.herokuapp.com/";
	
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkboxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver,log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Open LoginPageObject by clicking on Form Authentication Link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
	
	/** Open LoginPageObject by clicking on Form Authentication Link */
	public CheckboxesPage clickCheckboxesLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}
	
	//Click on dropDown page link
	public DropdownPage clickDropdownLink() {
		log.info("Selecting dropdown page...");
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}
}
