package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AEResourcesPage {
WebDriver driver;
	
    @FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
    
    @FindBy(xpath = "//*[@data-icon='file-lines']")
	public
	WebElement filelines;
    
    @FindBy(xpath = "//*[@data-icon='bullhorn']")
	public WebElement compassdrafting;
  
    @FindBy(xpath = "//li[@aria-label='Lookout']")
	public
	WebElement Lookout;
  
    @FindBy(xpath = "//li[text()='PSC']")
	public
	WebElement PSC;
    
    @FindBy(xpath = "//*[@id='view-body']/div/div/div/div/div/div")
	public List<String> NoRecord;
	
	@FindBy(xpath = "//*[@id='view-body']/div/div/div/div/div/div")
	public WebElement NoRecords;
	
	  @FindBy(xpath = "//*[@id='view-body']/div/div/div/div[1]/div")
		public
		WebElement LookoutList;
	
	  @FindBy(xpath = "//*[@id='view-body']/div/div/div/div[1]/div")
		public
		WebElement PSCList;
	
	  @FindBy(xpath = "//*[@id='view-body']/div/div/div/div[1]/div/div[1]/div[2]/div[1]")
		public
		WebElement LD;
	  
	  @FindBy(xpath = "//*[@id='view-body']/div/div/div/div[3]/div/div[1]/h3")
		public
		WebElement Text;
		
		@FindBy(xpath = "//*[@data-icon='download']")
		public
		WebElement download;
		
		@FindBy(xpath = "(//*[@data-icon='xmark'])[2]")
		public
		WebElement xmark;
				
	
	public AEResourcesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
