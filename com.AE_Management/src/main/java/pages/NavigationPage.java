package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {

	// Vessel Selection
	WebDriver driver;
	@FindBy(xpath = "//*[@data-testid='vessel-dropdown']")
	public WebElement vesseldropdown;

	@FindBy(xpath = "//div[text()='Select Vessel']")
	public WebElement SelectVessel;

	@FindBy(xpath = "//input[@placeholder='Select Vessel']")
	public WebElement VesselSelect;

	@FindBy(xpath = "//*[@id='root']/div/div/div[3]/nav/div[2]/div/div[1]/div/div[2]/div/div/input")
	public WebElement Vesselclear;// *[@id="root"]/div/div/div[3]/nav/div[2]/div/div[1]/div/div[2]/div/div/input

	@FindBy(xpath = "//div[@data-testid='map-sidebox']/div/div/h4")
	public WebElement OwnerName;

	@FindBy(xpath = "//div[@data-testid='map-sidebox']/div/div/h3")
	public WebElement vesselName;

	// Voyage Snapshot
	@FindBy(xpath = "//h3[text()='Voyage Snapshot']")
	public WebElement VoyageSnapshot;

	@FindBy(xpath = "//*[@id='root']/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/h3")
	public WebElement port;

	@FindBy(xpath = "//h3[text()='Voyage Snapshot']/../../div[2]")
	public WebElement VoyageSnapshot1;

	@FindBy(xpath = "//h3[text()='In Port']/../div")
	public WebElement portName;

	@FindBy(xpath = "//h3[text()='In Port']/../div[2]")
	public WebElement portOn;

	@FindBy(xpath = "//h3[text()='Last Port']/../div")
	public WebElement LastPort;

	@FindBy(xpath = "//h3[text()='Last Port']/../div[2]")
	public WebElement LastPorton;

	@FindBy(xpath = "//h3[text()='Next Port']/../div")
	public WebElement NextPort;

	// Crew Info
	@FindBy(xpath = "//h3[text()='Crew Info']")
	public WebElement CrewInfo;

	@FindBy(xpath = "//h3[text()='Crew Info']/../../div[2]")
	public WebElement CrewUpdateOn;

	@FindBy(xpath = "//h3[@title='Total Crew Onboard']/../div")
	public WebElement TotalCrewOnboard;

	@FindBy(xpath = "//*[@id='root']/div/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[1]")
	public WebElement ChiefEng;

	@FindBy(xpath = "//*[@id='root']/div/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]")
	public WebElement Master;

	@FindBy(xpath = "//*[@data-icon='circle-arrow-right']")
	public WebElement Crew;

	// Financial
	@FindBy(xpath = "//h3[text()='Financial']")
	public WebElement Financial;

	@FindBy(xpath = "//h3[text()='Financial']/../../div[2]")
	public WebElement FinancialUpdateOn;

	@FindBy(xpath = "//h3[text()='Financial']/../div")
	public WebElement Currency;

	@FindBy(xpath = "//h3[@title='Daily Running Cost ($)' or @title='Daily Running Cost (-)']/../div[1]")
	public WebElement DailyRunningCost;

	@FindBy(xpath = "//*[@title='Daily Running Cost ($)' or @title='Daily Running Cost (-)']/../div[2]/div/div")
	public WebElement DailyBudget;

	@FindBy(xpath = "//*[@title='Daily Running Cost ($)' or @title='Daily Running Cost (-)']/../div[2]/div/div/span")
	public WebElement color;

	@FindBy(xpath = "//h3[@title='Total Variance ($)' or @title='Total Variance (-)']/../div[1]")
	public WebElement TotalVariance;

	@FindBy(xpath = "//*[@title='Daily Running Cost ($)' or @title='Daily Running Cost (-)']/../div[2]/div/div")
	public WebElement TotalBudget;

	@FindBy(xpath = "//*[@data-icon='dollar-sign']")
	public WebElement dollarsign;

	// Vessel Particulars
	@FindBy(xpath = "//h3[text()='Vessel Particulars']")
	public WebElement VesselParticulars;

	@FindBy(xpath = "//div[text()='Flag']/../div[2]")
	public WebElement Flag;

	@FindBy(xpath = "//div[text()='Port of Registry']/../div[2]")
	public WebElement PortofRegistry;

	@FindBy(xpath = "//div[text()='Call Sign']/../div[2]")
	public WebElement CallSign;

	@FindBy(xpath = "//div[text()='Official Number']/../div[2]")
	public WebElement OfficialNumber;

	@FindBy(xpath = "//div[text()='IMO Number']/../div[2]")
	public WebElement IMONumber;

	@FindBy(xpath = "//div[text()='Class']/../div[2]")
	public WebElement Class;

	@FindBy(xpath = "//div[text()='VSAT Tel']/../div[2]")
	public WebElement VSATTel;

	// Certificates
	@FindBy(xpath = "//*[@data-icon='file-certificate']")
	public WebElement certificate;

	@FindBy(xpath = "//li[text()='All Certificates']")
	public WebElement AllCertificates;

	// Reports
	@FindBy(xpath = "//*[@data-icon='file-chart-pie']")
	public WebElement Reports;

	// Vessel Drawings / Shipyard Drawings
	@FindBy(xpath = "//*[@data-icon='compass-drafting']")
	public WebElement VesselDrawings;

	// AE Resources
	@FindBy(xpath = "//*[@data-icon='bullhorn']")
	public WebElement compassdrafting;

	public NavigationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
