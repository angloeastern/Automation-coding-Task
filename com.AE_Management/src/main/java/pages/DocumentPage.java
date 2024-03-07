package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	//div[@data-testid='vessel-dropdown']/div/div[1]/div[2]
	
	@FindBy(xpath = "//div[@aria-label='vessel-dropdown' or @data-testid='vessel-dropdown']/div/div[1]/div[2]")
	public WebElement orgDropdown;

	@FindBy(xpath = "//div[@aria-label='vessel-dropdown' or @data-testid='vessel-dropdown']/div/div[2]/div/div/input")
	public WebElement orgclear;

	@FindBy(xpath = "//div[@aria-label='map-sidebox' or @data-testid='map-sidebox']/div/div/h4")
	public WebElement OwnerName;

	@FindBy(xpath = "//div[@aria-label='map-sidebox' or @data-testid='map-sidebox']/div/div/h3")
	public WebElement vesselName;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div")
	public WebElement RecordDpl;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/table/tbody")
	public WebElement table;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement OK;
	
	public DocumentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}