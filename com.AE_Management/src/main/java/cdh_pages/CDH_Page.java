package cdh_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDH_Page {
WebDriver driver;
	
    @FindBy(xpath = "//*[@title='Financial Reports' and @id='QuicklinksItemTitle']")
	public
	WebElement FinancialReports;
    
    @FindBy(xpath = "//*[@title='Vessel Reports & Documents' and @id='QuicklinksItemTitle']")
	public
	WebElement VesselReports;
    
    @FindBy(xpath = "//*[@title='Ships Drawings' and @id='QuicklinksItemTitle']")
	public WebElement ShipsDrawings;
  
    @FindBy(xpath = "//input[@name='loginfmt']")
	public
	WebElement email;
    
    @FindBy(xpath = "//input[@type='submit']")
	public
	WebElement next;
    
    @FindBy(xpath = "//input[@name='passwd']")
	public
	WebElement password;
    
    @FindBy(xpath = "//input[@data-report-event='Signin_Submit']")
	public
	WebElement submit;
    
    @FindBy(xpath = "(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)[1]")
	public
	WebElement name;
    
    @FindBy(xpath = "(//div[@data-automationid='DetailsRowFields']/div[7]/div)[1]")
   	public
   	WebElement fileSize;
    
    @FindBy(xpath = "//input[@placeholder='Search this library']")
   	public
   	WebElement searchBox;
 			
    @FindBy(xpath = "//button[@title='Search']")
   	public
   	WebElement searchButton;
	
	public CDH_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
