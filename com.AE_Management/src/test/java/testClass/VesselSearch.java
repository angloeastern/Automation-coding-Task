package testClass;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.IndexedColors;
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
import base.ConsoleColors;
import pages.NavigationPage;
import utilities.ReadExcelFile;

public class VesselSearch extends Base {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_Y_BACKGROUND = "\u001B[43m";
	public static final String ANSI_Y = "\u001B[33m";
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
		//public static void vesselSearch(String vesselCode, String VesselName, String DocumentName,String data1,String data2,String data3,String data4)
		public static void vesselSearch(String vesselCode, String VesselName,String DocumentName)
				throws InterruptedException, ParseException, IOException {
			try {
				// Vessel Selection
				selection = new NavigationPage(driver);
				iWait();
				Thread.sleep(700);
				eWaitClick(selection.vesseldropdown);
				eWaitClear(selection.Vesselclear);
				eWaitClick(selection.Vesselclear);
				eWait(selection.Vesselclear);
				selection.Vesselclear.sendKeys(VesselName);
				boolean exists = driver.findElements(By.xpath("//div[text()='" + VesselName + "']")).size() != 0;
				if (exists) {
					WebElement vessels = driver.findElement(By.xpath("//div[text()='" + VesselName + "']"));
					System.out.println(VesselName);
					eWaitClick(vessels);
					

				} else {
					System.out.println("Error in vessel Search");
					log.error("Error in vessel Search");
					eWaitClear(selection.Vesselclear);
					Thread.sleep(1000);
					eWaitClick(selection.vesseldropdown);
					Assert.assertTrue(false, "vessel not founded in list");
				}
				System.out.println(ConsoleColors.GREEN_BOLD+ "Vessel Selection successful" + ANSI_RESET);
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
			public static void voyageSnapshot() throws InterruptedException, IOException {
				// Voyage Snapshot
			if (getProperty("VoyageSnapshot").equalsIgnoreCase("Yes")) {
				// Voyage Snapshot
				selection = new NavigationPage(driver);
				String VoyageSnapshot = eWaitText(selection.VoyageSnapshot);
				System.out.println(ANSI_Y_BACKGROUND + VoyageSnapshot + ANSI_RESET);
				// String VoyageSnapshot1 = getPageText(selection.VoyageSnapshot1);
				eWait(selection.VoyageSnapshot1);
				System.out.println(ANSI_G + "Voyage Snapshot Load Successfully" + ANSI_RESET);
				ReadExcelFile.setData(0, row,3, "Voyage Snapshot Load Successfully",IndexedColors.GREEN.getIndex());
				String port = selection.port.getAttribute("title");
				System.out.println(port);

				if (port.equalsIgnoreCase("In Port")) {
					String portName = eWaitText(selection.portName);
					String portOn = eWaitText(selection.portOn);
					System.out.println("Vessel In Port: " + portName);
					// ReadExcel.setData(0, row,4, portName);
					System.out.println("Vessel port on: " + portOn);
					// ReadExcel.setData(0, row,6, portOn);
				} else if (port.equalsIgnoreCase("Last Port")) {
					System.out.println("Last Port: " + eWaitText(selection.LastPort));
					// ReadExcel.setData(0, row,3, getPageText(selection.LastPort));
					System.out.println("Vessel port on: " + eWaitText(selection.LastPorton));
					// ReadExcel.setData(0, row,6, portOn);
					System.out.println("Next Port: " + eWaitText(selection.NextPort));
					// ReadExcel.setData(0, row,5, getPageText(selection.NextPort));
				} else {
					System.out.println("Voyage Snapshot not Loading");
					ReadExcelFile.setData(0, row,3, "Voyage Snapshot Not Loading",IndexedColors.RED.getIndex());
				}
				softAssert.assertTrue(true);

			}
			}
			@Test(priority = 3,dataProvider = "MainContects", dataProviderClass = DataProviderClass.class)
			public static void MainContects(String vesselCode, String VesselName) throws InterruptedException, ParseException, IOException {
				// MainContects
			if (getProperty("MainContects").equalsIgnoreCase("Yes")) {
				// Main Contects
				selection = new NavigationPage(driver);
				eWaitClick(selection.Contects);
				System.out.println(ConsoleColors.YELLOW_BOLD + eWaitText(selection.MainContect) + ANSI_RESET);
				int count = driver.findElements(By.xpath("//*[@id='map']/div[4]/div/div[2]/div[2]/div")).size();
				if (count == 0) {
					System.out.println("No Contect deatils");
					ReadExcelFile.setData(0, row,7, "No Contect deatils",IndexedColors.RED.getIndex());
				} else {
					IntStream.rangeClosed(1, count).forEach(i -> {
						String contactName = driver
								.findElement(By
										.xpath("//*[@id='map']/div[4]/div/div[2]/div[2]/div[" + i + "]/div[1]/div/div[1]"))
								.getText();
						String contactDesignation = driver
								.findElement(By
										.xpath("//*[@id='map']/div[4]/div/div[2]/div[2]/div[" + i + "]/div[1]/div/div[2]"))
								.getText();
						System.out.print(ANSI_Y + "contact Name: " + ANSI_RESET + contactName);
						System.out.print(ANSI_Y + "  contact Designation: " + ANSI_RESET + contactDesignation);
						System.out.println();
					});
					ReadExcelFile.setData(0, row,7, "Contect deatils loading",IndexedColors.GREEN.getIndex());
				}
			}
			}
			@Test(priority = 4,dataProvider = "CrewInfo", dataProviderClass = DataProviderClass.class)
			public static void CrewInfo(String vesselCode, String VesselName) throws Exception {
				// CrewInfo
			if (getProperty("CrewInfo").equalsIgnoreCase("Yes")) {
				// Crew Info
				selection = new NavigationPage(driver);
				eWait(selection.CrewInfo);
				WebElement element = selection.CrewInfo;
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);
				System.out.println(ANSI_Y_BACKGROUND + getPageText(selection.CrewInfo) + ANSI_RESET);
		

				if (selection.CrewUpdate.size()==0) {
					System.out.println(ANSI_RED_BACKGROUND + "Crew Info Not Loading" + ANSI_RESET);
					ReadExcelFile.setData(0, row,4, "Crew Info Not Loading",IndexedColors.RED.getIndex());
				} else {
					System.out.println(ANSI_G + "Crew Info Load Successfully" + ANSI_RESET);
					ReadExcelFile.setData(0, row,4, "Crew Info Load Successfully",IndexedColors.GREEN.getIndex());
					String CrewUpdateOn=eWaitText(selection.CrewUpdateOn);
					softAssert.assertNotNull(CrewUpdateOn);
					// h3[@title='Total Crew Onboard']
				System.out.println("Crew update on: " + CrewUpdateOn);
				System.out.println("Total Crew Onboard: " + getPageText(selection.TotalCrewOnboard));
				System.out.println("Master Name:  " + getPageText(selection.ChiefEng));
				System.out.println("ChiefEng Name:  " + getPageText(selection.Master));
				}
				eWaitClick(selection.Crew);
				Thread.sleep(2000);
				CrewTest.crewRecords();
				softAssert.assertTrue(true);
			}
		}
		@Test(priority = 5,dataProvider = "financialData", dataProviderClass = DataProviderClass.class)
		public static void financialData(String vesselCode, String VesselName) throws InterruptedException, ParseException, IOException {
			// Financial
			if (getProperty("Financial").equalsIgnoreCase("Yes")) {
				// Financial
				selection = new NavigationPage(driver);
				Thread.sleep(2000);
				// String Financial =
				// getPageText(By.xpath("//h3[text()='Financial']"));//h3[text()='Financial']/../div
				WebElement element2 = selection.Financial;
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
				System.out.println(ANSI_Y_BACKGROUND + eWaitText(selection.Financial) + ANSI_RESET);
				System.out.println("Currency " + eWaitText(selection.Currency));
				System.out.println("Daily Running Cost: " + eWaitText(selection.DailyRunningCost));
				if (getPageText(selection.DailyRunningCost).equals("-")) {
					System.out.println(ANSI_RED_BACKGROUND + "Financial Not Loading" + ANSI_RESET);
					ReadExcelFile.setData(0, row,5, "Financial Not Loading",IndexedColors.RED.getIndex());
				} else {
					System.out.println(ANSI_G + "Financial Load Successfully" + ANSI_RESET);
					ReadExcelFile.setData(0, row,5, "Financial Load Successfully",IndexedColors.GREEN.getIndex());
					System.out.println("Update on " + eWaitText(selection.FinancialUpdateOn));
					System.out.println("Daily Running Cost: " + eWaitText(selection.DailyRunningCost));
					System.out.println("Daily Budget: " + eWaitText(selection.DailyBudget));
					System.out.println("color is:  " + selection.color.getCssValue("color"));

					String cssColorString = selection.color.getCssValue("color");
					Color color = Color.fromString(cssColorString);
					System.out.println(color.asHex());
					System.out.println("Total Variance: " + eWaitText(selection.TotalVariance));
					System.out.println("Total Budget Variance: " + eWaitText(selection.TotalBudget));
				}
				// String FinancialCrcy =
				// getPageText(By.xpath("//h3[text()='Financial']/../div"));
				// System.out.println("Currency " + getPageText(selection.Currency));
				eWaitClick(selection.dollarsign);
				Thread.sleep(2000);
				FinanceTest.FinanceRecords(vesselCode, VesselName);
				softAssert.assertTrue(true);
			}
		}


			@Test(priority = 6,dataProvider = "vesselParticulars", dataProviderClass = DataProviderClass.class)
			public static void vesselParticulars() throws InterruptedException, IOException {
				// Vessel Particulars

			if (getProperty("VesselParticulars").equalsIgnoreCase("Yes")) {
				// Vessel Particulars
				selection = new NavigationPage(driver);
				Thread.sleep(2000);
				WebElement element1 = selection.VesselParticulars;
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
				System.out.println(ANSI_Y_BACKGROUND + eWaitText(selection.VesselParticulars) + ANSI_RESET);
				System.out.println("Flag:  " + eWaitText(selection.Flag));
				System.out.println("Port of Registry:  " + eWaitText(selection.PortofRegistry));
				System.out.println("Call Sign: " + eWaitText(selection.CallSign));
				System.out.println("Official Number:  " + eWaitText(selection.OfficialNumber));
				System.out.println("IMO Number:  " + eWaitText(selection.IMONumber));
				System.out.println("Class:  " + eWaitText(selection.Class));
				System.out.println("VSAT Tel:  " + eWaitText(selection.VSATTel));
				softAssert.assertTrue(true);
				ReadExcelFile.setData(0, row,6, "Vessel Particulars Loading",IndexedColors.GREEN.getIndex());
			}
			}
			@Test(priority = 7,dataProvider = "vesselParticulars", dataProviderClass = DataProviderClass.class)
			public static void Certificates() throws InterruptedException, IOException {
				// Certificates
			if (getProperty("Certificates").equalsIgnoreCase("Yes")) {
				// Certificates
				selection = new NavigationPage(driver);
				System.out.println(ANSI_Y_BACKGROUND + "Certificates" + ANSI_RESET);
				Thread.sleep(500);
				eWaitClick(selection.certificate);
				Thread.sleep(500);
				eWaitClick(selection.AllCertificates);
				Thread.sleep(2000);
				Cartificates.allCertificate();
				softAssert.assertTrue(true);
			}
			}
			@Test(priority = 8,dataProvider = "vesselParticulars", dataProviderClass = DataProviderClass.class)
			public static void Reports() throws InterruptedException, IOException {
				// Reports
			if (getProperty("Reports").equalsIgnoreCase("Yes")) {
				// Reports
				selection = new NavigationPage(driver);
				System.out.println(ANSI_Y_BACKGROUND + "Reports" + ANSI_RESET);
				eWaitClick(selection.Reports);
				Thread.sleep(2000);
				Reports.reports();
				softAssert.assertTrue(true);
			}
			}
			@Test(priority = 9,dataProvider = "vesselParticulars", dataProviderClass = DataProviderClass.class)
			public static void Document(String vesselCode, String VesselName,String DocumentName) throws InterruptedException, IOException {
				// Document
			if (getProperty("Document").equalsIgnoreCase("Yes")) {
				// Documents
				selection = new NavigationPage(driver);
				System.out.println(ANSI_Y_BACKGROUND + "Documents" + ANSI_RESET);
				eWaitClick(selection.Document);
				Thread.sleep(2000);
				Document.document(DocumentName);
				softAssert.assertTrue(true);
			}
			}
			@Test(priority = 10,dataProvider = "vesselParticulars", dataProviderClass = DataProviderClass.class)
			public static void VesselDrawings() throws InterruptedException, IOException {
				// VesselDrawings
			if (getProperty("VesselDrawings").equalsIgnoreCase("Yes")) {
				// Vessel Drawings / Shipyard Drawings
				selection = new NavigationPage(driver);
				System.out.println(ANSI_Y_BACKGROUND + "Vessel Drawings / Shipyard Drawings" + ANSI_RESET);
				eWaitClick(selection.VesselDrawings);
				Thread.sleep(2000);
				ShipyardDrawings.shipyardDrawings();
				softAssert.assertTrue(true);
			}}
			@Test(priority = 4,dataProvider = "vesselParticulars", dataProviderClass = DataProviderClass.class)
			public static void AEResources() throws InterruptedException, IOException {
				// AEResources
			if (getProperty("AEResources").equalsIgnoreCase("Yes")) {
				// AE Resources
				selection = new NavigationPage(driver);
				System.out.println(ANSI_Y_BACKGROUND + "AE Resources" + ANSI_RESET);
				eWaitClick(selection.compassdrafting);
				Thread.sleep(2000);
				AEResource.aeResources();
				softAssert.assertTrue(true);
			}
		}
			
		@org.testng.annotations.AfterMethod
		public void AfterMethod() throws IOException, InterruptedException {
			row++;
			softAssert.assertTrue(true);
		}

		// DataProvider
		@DataProvider(name = "Vesseldata")
		public Object[][] testDataExample() throws IOException {
			ReadExcelFile configuration = new ReadExcelFile(
					"D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\src\\main\\resources\\Data\\Regrassion.xlsx");
			int rows = configuration.getRowCount(0);
			int cells = configuration.getcellCount(0, rows);
			System.out.println(rows + "rows");
			System.out.println(cells + "cells");
			String[][] signin_credentials = new String[rows][cells];
			IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
					.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
			return signin_credentials;
		}

		@AfterClass
		public void endTest() {
			softAssert.assertAll();
			driver.close();
		}
	}

