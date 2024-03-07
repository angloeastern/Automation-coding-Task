package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrewPage {
	
	
	WebDriver driver;
	@FindBy(xpath = "//H3[@title='Last Crew Change']/following-sibling::*[1]")
	public
	WebElement LastCrewChange;
	
	@FindBy(xpath = "//H3[@title='Last Crew Change']/following-sibling::*[2]")
	public
	WebElement LastCrewChangeDate;
	
	@FindBy(xpath = "//H3[@title='Total Crew Onboard']/following-sibling::*[1]")
	public
	WebElement TotalCrewOnboard;
	
	@FindBy(xpath = "//*[@title='Total Crew Onboard']/../div[2]/div/div")
	public
	WebElement comparedtobudgeted;
	
	@FindBy(xpath = "//H3[@title='Planned Off-Signers']/following-sibling::*[1]")
	public
	WebElement PlannedOffSigners;
	
	@FindBy(xpath = "//H3[@title='Overdue Crew']/following-sibling::*[1]")
	public
	WebElement OverdueCrew;
	
	@FindBy(xpath = "//h3[@title='Crew Budget Variance ($)' or @title='Crew Budget Variance (-)']/../div[1]")
	public
	WebElement CrewBudgetVariance;
	
	@FindBy(xpath = "//h3[@title='Crew Budget Variance ($)' or @title='Crew Budget Variance (-)']/../div[2]/div/div")
	public
	WebElement CrewVarianceBudget;
	
	@FindBy(xpath="//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr")
	public List<WebElement> crewlist;

	@FindBy(xpath="//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]")
	public WebElement crewStatus;
	
	@FindBy(xpath="//div[@data-testid='profile' or @aria-label='profile']/div/div[1]")
	public WebElement pRank;
	
	@FindBy(xpath="//div[@data-testid='profile' or @aria-label='profile']/div/div[2]")
	public WebElement pName;
	
	@FindBy(xpath="//div[@data-testid='profile' or @aria-label='profile']/div/div[3]")
	public WebElement pStaff;
	
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
		
	//*[@data-icon='compass']
	@FindBy(xpath = "//*[text()='Crew Bio']")
	public
	WebElement CrewBio;
	
	@FindBy(xpath = "//*[@data-testid='bio-tab' or @aria-label='bio-tab']/div[1]/div[1]/div[2]")
	public
	WebElement Nationality;
	
	@FindBy(xpath = "//*[@data-testid='bio-tab' or @aria-label='bio-tab']/div[1]/div[2]/div[2]")
	public
	WebElement Age;
	
	@FindBy(xpath = "//*[@data-testid='bio-tab' or @aria-label='bio-tab']/div[2]/div[1]/div")
	public
	WebElement ContectUPDATE;
	
	@FindBy(xpath = "//*[@data-testid='bio-tab' or @aria-label='bio-tab']/div[2]/div[2]/div[2]")
	public
	WebElement Status;
	
	@FindBy(xpath = "//*[@data-testid='bio-tab' or @aria-label='bio-tab']/div[2]/div[3]/div[2]")
	public
	WebElement SignOnDate;
	
	@FindBy(xpath = "//li[@aria-label='Documents']/div[1]")
	public
	WebElement Documents;
	
	@FindBy(xpath = "//*[@data-testid='doc-tab' or @aria-label='doc-tab']/div[1]/div[3]/div[1]")
	public
	WebElement License;
	
	@FindBy(xpath = "//*[@id='view-body']/div[6]/div/div[1]/h3")
	public
	WebElement Text;
	
	@FindBy(xpath = "//*[@data-icon='download']")
	public
	WebElement download;
	
	@FindBy(xpath = "(//*[@data-icon='xmark'])[2]")
	public
	WebElement xmark;
			
			
	@FindBy(xpath = "//*[@data-testid='doc-tab' or @aria-label='doc-tab']/div[2]/div[2]/div[1]")
	public
	WebElement Certificates;
	
	@FindBy(xpath = " //li[@aria-label='Past Experience']/div[1]")
	public
	WebElement PastExperience;
	
	@FindBy(xpath = "//*[@id='view-body']/div[4]/div/div")
	public
	WebElement NoRecords;
	
	public CrewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
