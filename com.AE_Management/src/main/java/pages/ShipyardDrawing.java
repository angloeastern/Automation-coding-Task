package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipyardDrawing {
WebDriver driver;
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	@FindBy(xpath = "//li[@aria-label='Shipyard Drawings']")
	public
	WebElement ShipyardDrawing;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div/table/tbody")
	public WebElement list;
	
	@FindBy(xpath = "//li[@aria-label='Instruction Manuals']")
	public
	WebElement InstructionManuals;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div/div/div")
	public List<String> NoRecord;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div/div/div")
	public WebElement NoRecords;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement OK;
	
	//*[@id="root"]/div/div/div[1]/div/div[1]/text()[2]
	
	public ShipyardDrawing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
