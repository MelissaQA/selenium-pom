package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

	private String expectedUrl = "http://the-internet.herokuapp.com/secure";
	private By logoutButtoLocator = By.xpath("/html/body/div[2]/div/div/a/i");
	private By expectedMessage = By.id("flash-messages");
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public String getPageUrl() {
		return expectedUrl;
	}
	
	public boolean isLogOutButtonVisible() {
		return find(logoutButtoLocator).isDisplayed();
	}

	public String getSuccessMessage() {
		return find(expectedMessage).getText();
	}
	
}
