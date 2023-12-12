package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(xpath = "//div[text()=\"Use Your Client Portal Account\"]")
	static
	WebElement umScreen;

	@FindBy(xpath = "//div[text()='Select Vessel']")
	public
	WebElement SelectVessel;
	
	@FindBy(id = "Email")
	static
	WebElement userName;

	@FindBy(name = "Password")
	static
	WebElement password;

	@FindBy(name = "button")
	static
	WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static void MyAELogin(String strUserName,String strPassword) {
		
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		login.click();
	}


	public void clickUM() {
		try {
			umScreen.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
