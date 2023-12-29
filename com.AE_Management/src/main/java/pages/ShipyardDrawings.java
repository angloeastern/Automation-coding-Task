package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipyardDrawings {
WebDriver driver;
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	public ShipyardDrawings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
