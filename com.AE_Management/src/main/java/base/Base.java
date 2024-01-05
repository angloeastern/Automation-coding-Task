package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	    System.setProperty("webdriver.chrome.driver", "D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\Driver\\chromedriver.exe");
		//driver=new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePref = new HashMap<>();
		chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
		options.setExperimentalOption("prefs", chromePref);
		driver = new ChromeDriver(options);
		
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
    public static void eWaitClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,50);
    	wait.until(ExpectedConditions.elementToBeClickable(element)).click();;
        }
    public static String eWaitText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,50);
    	return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
        }
    public static void eWaitClear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,50);
    	wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        }
    public static void visibilityOfElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
    public static void invisibilityOfElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        }
    public static void downlaodFileChecker(String fileName) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
	String tmpFolderPath = System.getProperty("java.io.tmpdir");
	//String tmpFolderPath = "C:\\Users\\Poonam\\AppData\\Local\\Temp\\";
	String expectedFileName = fileName;
	File file = new File(tmpFolderPath + expectedFileName+ ".pdf");
	System.out.println(file);
	wait.until((ExpectedCondition<Boolean>) webDriver -> file.exists());
	if (file.exists())
	{
		System.out.println(file + " is present");
	}
	else
	{
		System.out.println(file + " is not present");
	}
    }

	public static void downlaodFileChecker1(String file) {
		File folder = new File(System.getProperty("user.dir"));
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		// Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File " + listOfFile.getName());
				if (fileName.matches(file)) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		Assert.assertTrue(found, "Downloaded document is not found");
		f.deleteOnExit();
	}
}
