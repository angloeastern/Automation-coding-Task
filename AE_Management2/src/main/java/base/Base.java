package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base {

	static Properties props;
	protected static WebDriver driver;
	
	
	
	public static void Initialize(String browser) throws IOException
	{
		
	    props = new Properties();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
		props.load(reader);
				
		if (browser.equalsIgnoreCase("chrome"))
		{
	   // System.setProperty("webdriver.chrome.driver", "D:\\WorkInno\\Poonam\\Tasks\\AE Automation\\AEShip_UI_Management\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();	
		}
	}
	
	public static String getScreenShot(String string) throws IOException {
	  //  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = string;
	    File finalDestination = new File(destination);
	    FileUtils.copyFile(source, finalDestination);
	    return destination;
	}
	
	public static String getDateTimeStamp() {
		Date oDate;
		String[] sDatePart;
		String sDateStamp;
		oDate = new Date();
		System.out.println(oDate.toString());
		sDatePart = oDate.toString().split(" ");
		sDateStamp = sDatePart[5] + "_" + sDatePart[1] + "_" + sDatePart[2] + "_" + sDatePart[3];
		sDateStamp = sDateStamp.replace(":", "_");
		//System.out.println(sDateStamp);
		return sDateStamp;
	}
	
	public static String getDateStamp() {
		Date oDate;
		String[] sDatePart;
		String sDateStamp;
		oDate = new Date();
		System.out.println(oDate.toString());
		sDatePart = oDate.toString().split(" ");
		sDateStamp = sDatePart[5] + "_" + sDatePart[1] + "_" + sDatePart[2] ;
		sDateStamp = sDateStamp.replace(":", "_");
		//System.out.println(sDateStamp);
		return sDateStamp;
	}

	public static void click(WebElement click) {
		click.click();
	}

	public static void text(WebElement sendKeys, String text) {
		sendKeys.sendKeys(text);
	}

	public static void iWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyBasePageTitle() {
		String expectedPageTitle = "Google";
		return getPageTitle().contains(expectedPageTitle);
	}
    public static String getProperty(String test)
    {
    	return props.getProperty(test);
    }
    
    public static String getPageText(WebElement getPageText) {
		return getPageText.getText();
		
	}
    
    public static void eWait(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void visibilityOfElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
    public static void invisibilityOfElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        }
  
    
}
