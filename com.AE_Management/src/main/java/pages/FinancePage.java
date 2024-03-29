package pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	
	@FindBy(xpath = "//*[@id='view-body']/div[2]/div[1]/div/div/div")
	public
	WebElement FinancialMonth;
	
	@FindBy(xpath = "//*[@aria-label='OPEX Report']")
	public
	WebElement OPEXReport;
	
	@FindBy(xpath = "//*[@aria-label='Other Reports (Vessels)']")
	public
	WebElement OtherReportsVessels;
	
	@FindBy(xpath = "//*[@aria-label='Other Reports (Fleet)']")
	public
	WebElement OtherReportsFleet;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/div/div/div/div")
	public
	WebElement noRecords;

	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/div/div/table/tbody")
	public
	WebElement table;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/div/div/div")
	public
	WebElement OperatingExpenses;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/div/div/div")
	public
	By OperatingExpenses1;
    
	
	@FindBy(xpath = "//h3[@title='Total Budget ($)' or @title='Total Budget (-)' or @title='Total Budget (₹)' or @title='Total Budget (€)' or @title='Total Budget (CA$)']/following-sibling::*[1]")
	public
	WebElement TotalBudget;
	
	@FindBy(xpath = "//h3[@title='Total Budget ($)' or @title='Total Budget (-)' or @title='Total Budget (₹)' or @title='Total Budget (€)' or @title='Total Budget (CA$)']/following-sibling::*[1]")
	public
	By TotalBudget1;
	
	@FindBy(xpath = "//H3[@title='Actual ($)' or @title='Actual (-)' or @title='Actual (₹)' or @title='Actual (€)' or @title='Actual (CA$)']/following-sibling::*[1]")
	public
	WebElement Actual;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tbody/tr[1]/td[2]/span")
	public
	WebElement TableActual;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tfoot/tr/th[2]")
	public
	WebElement TotalActual;
	
	@FindBy(xpath = "//H3[@title='Budget ($)' or @title='Budget (-)' or @title='Budget (₹)' or @title='Budget (€)']/following-sibling::*[1]")
	public
	WebElement Budget;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tbody/tr[1]/td[3]/span")
	public
	WebElement TableBudget;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tfoot/tr/th[3]")
	public
	WebElement TotalBudgett;
	
	@FindBy(xpath = "//H3[@title='Variance ($)' or @title='Variance (-)' or @title='Variance (₹)' or @title='Variance (€)']/following-sibling::*[1]")
	public
	WebElement Variance;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tbody/tr[1]/td[4]/span")
	public
	WebElement TableVariance;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tfoot/tr/th[4]")
	public
	WebElement TotalVariance;
	
	@FindBy(xpath = "//h3[@title='Variance ($)' or @title='Variance (-)' or @title='Variance (₹)' or @title='Variance (€)' or @title='Variance (CA$)']/../div[2]/div/div")
	public
	WebElement VarianceBudget;
	

	@FindBy(xpath = "//*[@title='Variance ($)' or @title='Variance (-)' or @title='Variance (₹)' or @title='Variance (€)']/../div[2]/div/div/span")
	public
	WebElement color;
	
	@FindBy(xpath = "//H3[@title='Actual YTD ($)' or @title='Actual YTD (-)' or @title='Actual YTD (₹)' or @title='Actual YTD (€)']/following-sibling::*[1]")
	public
	WebElement ActualYTD;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tbody/tr[1]/td[5]/span")
	public
	WebElement TableActualYTD;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tfoot/tr/th[5]")
	public
	WebElement TotalActualYTD;
	
	@FindBy(xpath = "//H3[@title='Budget YTD ($)' or @title='Budget YTD (-)' or @title='Budget YTD (₹)' or @title='Budget YTD (€)']/following-sibling::*[1]")
	public
	WebElement BudgetYTD;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tbody/tr[1]/td[6]/span")
	public
	WebElement TableBudgetYTD;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tfoot/tr/th[6]")
	public
	WebElement TotalBudgetYTD;
	
	@FindBy(xpath = "//H3[@title='Variance YTD ($)' or @title='Variance YTD (-)' or @title='Variance YTD (₹)' or @title='Variance YTD (€)' or @title='Variance YTD (CA$)']/following-sibling::*[1]")
	public
	WebElement VarianceYTD;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tbody/tr[1]/td[7]/span")
	public
	WebElement TableVarianceYTD;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/table/tfoot/tr/th[7]")
	public
	WebElement TotalVarianceYTD;
	
	@FindBy(xpath = "//H3[@title='Variance YTD ($)' or @title='Variance YTD (-)' or @title='Variance YTD (₹)' or @title='Variance YTD (€)']/../div[2]/div/div")
	public
	WebElement VarianceYTDBudget;

	@FindBy(xpath = "//*[@title='Variance YTD ($)' or @title='Variance YTD (-)' or @title='Variance YTD (₹)' or @title='Variance YTD (€)']/../div[2]/div/div/span")
	public
	WebElement colorYTD;
	
	@FindBy(xpath = "//input[@type='checkbox']/../div")
	public
	WebElement inculdecheckbox;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/div/div[1]/div/div[2]/canvas")
	public
	WebElement BUDGETACTUALMONTH;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/div/div[2]/div/div[2]/canvas")
	public
	WebElement AVERAGEDAILY;
	
	@FindBy(xpath = "//*[@id='view-body']/div[3]/div/div/div[3]/div/div[2]/canvas")
	public
	WebElement BUDGETACTUALYEAR;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement OK;
		
	@FindBy(xpath = "//div[@class='sc-ddCuvZ ekpXcI']/div/div[2]/button")
	public WebElement OKK;
	
	@FindBy(xpath = "//div[@class='sc-ddCuvZ ekpXcI']")
	
	public List<WebElement> OKKk;
	//div[@class='sc-ddCuvZ ekpXcI']/div/div[2]/button
	
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	public FinancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
