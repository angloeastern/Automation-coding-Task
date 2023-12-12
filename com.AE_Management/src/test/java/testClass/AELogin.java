package testClass;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.LoginPage;

public class AELogin extends Base {
	public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_BACKGROUND = "\u001B[42m";
@Test
	public static void Login() throws InterruptedException, IOException {

		Initialize("chrome");
		driver.get(getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SoftAssert softAssert = new SoftAssert();
		LoginPage page= new LoginPage(driver);
		page.clickUM();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage.MyAELogin(getProperty("UserName"), getProperty("Password"));
		Thread.sleep(20000);
		// driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		// System.out.println(driver.getTitle());
		String text = getPageText(page.SelectVessel);
		softAssert.assertEquals("Select Vessel", text);
		System.out.println(ANSI_BACKGROUND+"Login successful"+ANSI_RESET);
		softAssert.assertAll();
		
		
	}

}

