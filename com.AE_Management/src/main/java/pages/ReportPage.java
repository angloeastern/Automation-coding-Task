package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	@FindBy(xpath = "//li[@aria-label='External Inspections']")
	public
	WebElement ExternalInspections;
	
	@FindBy(xpath = "//li[@aria-label='Internal Inspections']")
	public
	WebElement InternalInspections;
	
	@FindBy(xpath = "//li[@aria-label='Dry-Dock']")
	public
	WebElement DryDock;
	
	@FindBy(xpath = "//li[@aria-label='Claims']")
	public
	WebElement Claims;
	
	@FindBy(xpath = "//li[@aria-label='Commercial']")
	public
	WebElement Commercial;
	
	@FindBy(xpath = "//li[@aria-label='Gallery']")
	public
	WebElement Gallery;
	
	@FindBy(xpath = "//li[@aria-label='Other Reports']")
	public
	WebElement OtherReports;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/table/tbody")
	public WebElement table;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div/table/tbody")
	public WebElement table1;
	

	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div/div/div")
	public List<String> NoRecord;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div/div/div")
	public WebElement NoRecords;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement OK;
	
	public ReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
