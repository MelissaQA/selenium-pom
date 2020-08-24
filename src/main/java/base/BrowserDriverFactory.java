package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	
	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser;
		this.log = log;
	}
	
	public WebDriver createDriver() {
		log.info("Creating driver: "+ this.browser);
		
		switch(this.browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		default:
			System.out.println("Starting chrome as default browser...");
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		
		return driver.get();
	}
}
