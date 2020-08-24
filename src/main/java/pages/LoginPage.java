package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/login";
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.tagName("button");
	private By invalidLoginMessageLocator = By.id("flash");
	
	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public SecureAreaPage logIn(String username, String password) {
		log.info("Executing login with username [" + username +"] and password ["+password+"]");
		type(usernameLocator, username);
		type(passwordLocator, password);
		click(loginButtonLocator);
		return new SecureAreaPage(driver, log);
	}
	
	public void negativeLogIn(String username, String password) {
		log.info("Executing negative login with username [" + username +"] and password ["+password+"]");
		type(usernameLocator, username);
		type(passwordLocator, password);
		click(loginButtonLocator);
	}
	
	public void waitForErrorMessage() {
		waitForVisibilityOf(invalidLoginMessageLocator, 5);
	}
	
	public String getInvalidLoginMessageText(){
		return find(invalidLoginMessageLocator).getText();
	}
}
