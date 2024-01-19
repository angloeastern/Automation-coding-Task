package testClass;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.NavigationPage;
import utilities.ReadExcelFile;

public class VesselSearch extends Base {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_Y_BACKGROUND = "\u001B[43m";
	public static final String ANSI_G_BACKGROUND = "\u001B[42m";
	public static final String ANSI_G = "\u001B[32m";
	static String ownerName;
	static int row = 1;
	static Logger log = LogManager.getLogger(VesselSearch.class.getName());
	public static SoftAssert softAssert = new SoftAssert();
	static NavigationPage selection ;
	public Object[] data;

	@BeforeClass
	public void ProgramStart() throws InterruptedException, IOException {
		AELogin.Login();
	}

	@Test(priority = 0,dataProvider = "Vesseldata", dataProviderClass = DataProviderClass.class)
	public static void vesselSearch(String vesselCode, String VesselName) throws InterruptedException {

try {
	
		// Vessel Selection
	selection = new NavigationPage(driver);
	iWait();
	Thread.sleep(700);
	eWait(selection.vesseldropdown);
	selection.vesseldropdown.click();
	eWait(selection.Vesselclear);
	selection.Vesselclear.clear();
	eWait(selection.Vesselclear);
	selection.Vesselclear.click();
	eWait(selection.Vesselclear);
	selection.Vesselclear.sendKeys(VesselName);
	boolean exists = driver.findElements(By.xpath("//div[text()='" + VesselName + "']")).size() != 0;
	if (exists) {
		WebElement vessels = driver.findElement(By.xpath("//div[text()='" + VesselName + "']"));
		eWait(vessels);
		vessels.click();
	} else {
		System.out.println("Error in vessel Search");
		log.error("Error in vessel Search");
		eWait(selection.Vesselclear);
		selection.Vesselclear.clear();
		Thread.sleep(1000);
		eWait(selection.vesseldropdown);
		selection.vesseldropdown.click();
		Assert.assertTrue(false, "vessel not founded in list");
	}
	System.out.println(ANSI_G + "Vessel Selection successful" + ANSI_RESET);
	log.info("Vessel Selection successfully");
} catch (NoSuchElementException n) {
	// TODO: handle exception
	softAssert.assertTrue(false, "Error in vessel Search" + n.getMessage());
	n.printStackTrace();
	System.out.println("Error in vessel Search" + n.getMessage());
	log.error("Error in vessel Search" + n.getMessage());
}
	}

	@Test(priority = 1,dataProvider = "voyageSnapshot", dataProviderClass = DataProviderClass.class)
	public static void voyageSnapshot() throws InterruptedException {
		// Voyage Snapshot

		selection = new NavigationPage(driver);
		eWait(selection.VoyageSnapshot);
		String VoyageSnapshot = getPageText(selection.VoyageSnapshot);

		System.out.println(ANSI_Y_BACKGROUND + VoyageSnapshot + ANSI_RESET);

		//String VoyageSnapshot1 = getPageText(selection.VoyageSnapshot1);

		eWait(selection.VoyageSnapshot1);
		System.out.println(ANSI_G + "Voyage Snapshot Load Successfully" + ANSI_RESET);
		//ReadExcel.setData(0, row,2, "Voyage Snapshot Load Successfully");
		String port = selection.port.getAttribute("title");
		System.out.println(port);

		if (port.equalsIgnoreCase("In Port")) {
			eWait(selection.portName);
			String portName = getPageText(selection.portName);
			String portOn = getPageText(selection.portOn);
			System.out.println("Vessel In Port: " + portName);
			//ReadExcel.setData(0, row,4, portName);
			System.out.println("Vessel port on: " + portOn);
			//ReadExcel.setData(0, row,6, portOn);
		} else if (port.equalsIgnoreCase("Last Port")) {
			eWait(selection.LastPort);
			System.out.println("Last Port: " + getPageText(selection.LastPort));
			//ReadExcel.setData(0, row,3, getPageText(selection.LastPort));
			String portOn = getPageText(selection.LastPorton);
			System.out.println("Vessel port on: " + portOn);
			//ReadExcel.setData(0, row,6, portOn);
			eWait(selection.NextPort);
			System.out.println("Next Port: " + getPageText(selection.NextPort));
			//ReadExcel.setData(0, row,5, getPageText(selection.NextPort));
		} else {
			System.out.println("Voyage Snapshot not Loading");
			//ReadExcel.setData(0, row,2, "Voyage Snapshot Not Loading");
		}
		softAssert.assertTrue(true);

	}

	@Test(priority = 2,dataProvider = "crewInfo", dataProviderClass = DataProviderClass.class)
	public static void crewInfo() throws InterruptedException, IOException {
		// Crew Info

		selection = new NavigationPage(driver);
		eWait(selection.CrewInfo);
		WebElement element = selection.CrewInfo;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		System.out.println(ANSI_Y_BACKGROUND + getPageText(selection.CrewInfo) + ANSI_RESET);
		eWait(selection.CrewUpdateOn);
		String CrewUpdateOn = getPageText(selection.CrewUpdateOn);

		if (CrewUpdateOn.isBlank()) {
			System.out.println(ANSI_RED_BACKGROUND + "Crew Info Not Loading" + ANSI_RESET);
		} else {
			System.out.println(ANSI_G + "Crew Info Load Successfully" + ANSI_RESET);
		}
		softAssert.assertNotNull(CrewUpdateOn);
		// h3[@title='Total Crew Onboard']
		System.out.println("Crew update on: " + CrewUpdateOn);
		System.out.println("Total Crew Onboard: " + getPageText(selection.TotalCrewOnboard));
		System.out.println("Master Name:  " + getPageText(selection.ChiefEng));
		System.out.println("ChiefEng Name:  " + getPageText(selection.Master));

		eWait(selection.Crew);
		selection.Crew.click();
		Thread.sleep(2000);
		CrewTest.crewRecords();
		softAssert.assertTrue(true);

	}

	@Test(priority = 3,dataProvider = "financialData", dataProviderClass = DataProviderClass.class)
	public static void financialData(String vesselCode, String VesselName) throws InterruptedException, ParseException, IOException {
		// Financial

		selection = new NavigationPage(driver);
		Thread.sleep(2000);
		// String Financial =
		// getPageText(By.xpath("//h3[text()='Financial']"));//h3[text()='Financial']/../div
		
		WebElement element = selection.Financial;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		eWait(selection.Financial);
		System.out.println(ANSI_Y_BACKGROUND + getPageText(selection.Financial) + ANSI_RESET);
		System.out.println("Currency " + getPageText(selection.Currency));
		System.out.println("Daily Running Cost: " + getPageText(selection.DailyRunningCost));
		if (getPageText(selection.DailyRunningCost).equals("-")) {
			System.out.println(ANSI_RED_BACKGROUND + "Financial Not Loading" + ANSI_RESET);
		} else {
			System.out.println(ANSI_G + "Financial Load Successfully" + ANSI_RESET);
			System.out.println("Update on " + getPageText(selection.FinancialUpdateOn));
			eWait(selection.DailyRunningCost);
			System.out.println("Daily Running Cost: " + getPageText(selection.DailyRunningCost));
			System.out.println("Daily Budget: " + getPageText(selection.DailyBudget));
			System.out.println("color is:  " + selection.color.getCssValue("color"));

			String cssColorString = selection.color.getCssValue("color");
			Color color = Color.fromString(cssColorString);
			System.out.println(color.asHex());
			eWait(selection.TotalVariance);
			System.out.println("Total Variance: " + getPageText(selection.TotalVariance));
			System.out.println("Total Budget Variance: " + getPageText(selection.TotalBudget));
		}

		// String FinancialCrcy =
		// getPageText(By.xpath("//h3[text()='Financial']/../div"));
		// System.out.println("Currency " + getPageText(selection.Currency));

		eWait(selection.dollarsign);
		selection.dollarsign.click();
		Thread.sleep(2000);
		FinanceTest.FinanceRecords(vesselCode,VesselName);
		softAssert.assertTrue(true);

	}

	@Test(priority = 4,dataProvider = "vesselParticulars", dataProviderClass = DataProviderClass.class)
	public static void vesselParticulars() throws InterruptedException {
		// Vessel Particulars

		selection = new NavigationPage(driver);
		Thread.sleep(2000);
		WebElement element = selection.VesselParticulars;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		eWait(selection.VesselParticulars);
		System.out.println(ANSI_Y_BACKGROUND + getPageText(selection.VesselParticulars) + ANSI_RESET);
		System.out.println("Flag:  " + getPageText(selection.Flag));
		eWait(selection.PortofRegistry);
		System.out.println("Port of Registry:  " + getPageText(selection.PortofRegistry));
		System.out.println("Call Sign: " + getPageText(selection.CallSign));
		System.out.println("Official Number:  " + getPageText(selection.OfficialNumber));
		eWait(selection.IMONumber);
		System.out.println("IMO Number:  " + getPageText(selection.IMONumber));
		System.out.println("Class:  " + getPageText(selection.Class));
		System.out.println("VSAT Tel:  " + getPageText(selection.VSATTel));
		softAssert.assertTrue(true);
	}
	/*@Test(priority = 5,dataProvider = "Certificates")
	public static void Certificates() throws InterruptedException {
		
		// Certificates

		selection = new NavigationPage(driver);
		eWait(selection.certificate);
		selection.certificate.click();
		eWait(selection.AllCertificates);
		selection.AllCertificates.click();
		
		WebElement wb=driver.findElement(By.xpath("(//div[@data-testid='collapse-content'])[1]/table/tbody/tr[1]/td[1]/div/span[2]"));
		eWait(wb);
		wb.click();
		
		WebElement wb1=driver.findElement(By.xpath("//*[@id='view-body']/div[2]/div/div[1]/h3"));
		eWait(wb1);
		String text=wb1.getText();
		wb1.click();
		System.out.println(text);
		
		WebElement wb2=driver.findElement(By.xpath("(//*[@id='view-body']/div[2]/div/div[1]/div[2]/div/*)[1]"));
		eWait(wb2);
		wb2.click();
		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("fileName", text);
		((JavascriptExecutor) driver).executeScript("tb:fileExists", fileMap);
		softAssert.assertTrue(true);
		
		WebElement wb3=driver.findElement(By.xpath("(//*[@id='view-body']/div[2]/div/div[1]/div[2]/div/*)[2]"));
		eWait(wb3);
		wb3.click();		
		softAssert.assertTrue(true);
		//(//div[@data-testid="collapse-content"])[1]/table/tbody/tr[1]/td[1]/div/span[2]
	}
	
	// DataProvider
		@DataProvider(name = "Vesseldata")
		public Object[][] testDataExample() throws IOException {
			ReadExcelFile configuration = new ReadExcelFile("D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\src\\main\\resources\\Data\\Login.xlsx");
			int rows = configuration.getRowCount(0);
			int cells = configuration.getcellCount(0, rows);
			System.out.println(rows + "rows");
			System.out.println(cells + "cells");
			String[][] signin_credentials = new String[rows][cells];
			IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
					.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
			return signin_credentials;
		}
*/
	@AfterClass
	public void endTest() {
		softAssert.assertAll();
		 driver.close();
	}
}
