package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject{

	private By dropdown = By.id("dropdown");
	
	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	//Select an option from a Select dropdown
	public void selectOption(int option){
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement); 
		dropdown.selectByIndex(option);
		
	}
	
	//Get the text from an option selected in the dropdown
	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}
	
}
