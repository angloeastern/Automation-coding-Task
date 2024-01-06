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
	
	@FindBy(xpath="//div[@data-testid='crew-list']/table/tbody/tr")
	public List<WebElement> crewlist;

	@FindBy(xpath="//div[@data-testid='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]")
	public WebElement crewStatus;
	
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	//*[@data-icon='compass']
	
	public CrewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
