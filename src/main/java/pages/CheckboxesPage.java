package pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject{

	private By checkboxesLocator = By.tagName("input");
	
	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	//Selecting all checkboxes from a page
	public void selectAllCheckboxes() {
		log.info("Selecting both checkboxes");
		List<WebElement> checkboxes = findAll(checkboxesLocator);
		for(WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
			
		}
	}
	
	public boolean areAllCheckboxesSelected() {
		log.info("Verifying if all checkboxes are selected:");
		List<WebElement> checkboxes = findAll(checkboxesLocator);
		for(WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				return false;
			}
		}
		return true;
	}
}
