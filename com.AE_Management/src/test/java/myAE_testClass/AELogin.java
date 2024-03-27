package myAE_testClass;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.LoginPage;

public class AELogin extends Base {
	public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_BACKGROUND = "\u001B[42m";
    static Logger log = LogManager.getLogger(AELogin.class.getName());
    
@Test
	public static void Login() throws InterruptedException, IOException {
	PropertyConfigurator.configure("D:\\WorkInno\\Poonam\\Tasks\\AE Automation\\AE_Management\\src\\main\\java\\config\\log4j.properties");
		Initialize("chrome");
		driver.get(getProperty("URL"));
		iWait();
		SoftAssert softAssert = new SoftAssert();
		LoginPage page= new LoginPage(driver);
		page.clickUM();
		LoginPage.MyAELogin(getProperty("UserName"), getProperty("Password"));
	    eWait(page.SelectVessel);
	//	Thread.sleep(5000);
		// driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		// System.out.println(driver.getTitle());
		String text = eWaitText(page.SelectVessel);
		softAssert.assertEquals("Select Vessel", text);
		softAssert.assertAll();
		System.out.println(ANSI_BACKGROUND+"Login successful"+ANSI_RESET);
		log.info("Login successful");
		
		
		
	}

}

