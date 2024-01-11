package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificatePage {
WebDriver driver;
	@FindBy(xpath = "//*[@data-icon='compass']")
	public
	WebElement compass;
	
	@FindBy(xpath = "//div[@id='view-body']/div/div/div/div/div/div/div[2]/table/tbody/tr")
	public
	List<WebElement> CertificatesList;
	
	public CertificatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
