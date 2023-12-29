package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AEResources {
WebDriver driver;
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	public AEResources(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
