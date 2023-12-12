package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[3]/div/div/div[1]/div[2]/div/div[1]/div[1]")
	public
	WebElement VesselOwnerName;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div[1]/div[2]/div/div[1]/div[3]")
	public
	WebElement VesselCode;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div[1]/div[1]/h1")
	public
	WebElement FinancialOverview;
	
	
	@FindBy(xpath = "//h3[@title='Total Budget ($)' or @title='Total Budget (-)']/following-sibling::*[1]")
	public
	WebElement TotalBudget;
	
	@FindBy(xpath = "//H3[@title='Actual ($)' or @title='Actual (-)']/following-sibling::*[1]")
	public
	WebElement Actual;
	
	@FindBy(xpath = "//H3[@title='Budget ($)' or @title='Budget (-)']/following-sibling::*[1]")
	public
	WebElement Budget;
	
	@FindBy(xpath = "//H3[@title='Variance ($)' or @title='Variance (-)']/following-sibling::*[1]")
	public
	WebElement Variance;
	
	@FindBy(xpath = "//h3[@title='Variance ($)' or @title='Variance (-)']/../div[2]/div/div")
	public
	WebElement VarianceBudget;

	@FindBy(xpath = "//*[@title='Variance ($)' or @title='Variance (-)]/../div[2]/div/div/span")
	public
	WebElement color;
	
	@FindBy(xpath = "//H3[@title='Actual YTD ($)']/following-sibling::*[1]")
	public
	WebElement ActualYTD;
	
	@FindBy(xpath = "//H3[@title='Budget YTD ($)' or @title='Budget YTD (-)']/following-sibling::*[1]")
	public
	WebElement BudgetYTD;
	
	@FindBy(xpath = "//H3[@title='Variance YTD ($)' or @title='Variance YTD (-)']/following-sibling::*[1]")
	public
	WebElement VarianceYTD;
	
	@FindBy(xpath = "//H3[@title='Variance YTD ($)' @title='Variance YTD (-)']/../div[2]/div/div")
	public
	WebElement VarianceYTDBudget;

	@FindBy(xpath = "//*[@title='Variance YTD ($)' or @title='Variance YTD (-)']/../div[2]/div/div/span")
	public
	WebElement colorYTD;
	
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	public FinancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
