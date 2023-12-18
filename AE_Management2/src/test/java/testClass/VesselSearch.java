package testClass;

import java.io.IOException;
import java.text.ParseException;
import java.util.stream.IntStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.Base;
import pages.FinancePage;
import pages.NavigationPage;
import utilities.AzureBlobFileDownload;
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
	public static SoftAssert softAssert = new SoftAssert();
	static NavigationPage selection;
	static Logger log = LogManager.getLogger(VesselSearch.class.getName());

	@BeforeClass
	public void ProgramStart() throws InterruptedException, IOException {
		AELogin.Login();
		AzureBlobFileDownload.M();
		selection = new NavigationPage(driver);
		eWait(selection.dollarsign);
		selection.dollarsign.click();
		Thread.sleep(1000);
		iWait();
	}

	@Test(priority = 0, dataProvider = "Vesseldata")
	public static void OpEx_Report_Varification(String vasselCode, String vessel, String month, String readyForClient,
			String data, String data1, String data2, String data3, String data4, String data5)
	// public static void OpEx_Report_Verification(String vasselCode, String vessel,
	// String month,String readForClient)
					throws InterruptedException, ParseException, IOException {
		try {
			System.out.println(vessel + "******************");
			// Vessel Selection
			iWait();
			Thread.sleep(700);
			eWait(selection.vesseldropdown);
			selection.vesseldropdown.click();
			eWait(selection.Vesselclear);
			selection.Vesselclear.clear();
			eWait(selection.Vesselclear);
			selection.Vesselclear.click();
			eWait(selection.Vesselclear);
			selection.Vesselclear.sendKeys(vessel);
			boolean exists = driver.findElements(By.xpath("//div[text()='" + vessel + "']")).size() != 0;
			if (exists) {
				WebElement vessels = driver.findElement(By.xpath("//div[text()='" + vessel + "']"));
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
		// eWait(selection.dollarsign);
		// selection.dollarsign.click();
		// Thread.sleep(1000);
		iWait();
		FinancePage selection = new FinancePage(driver);
		eWait(selection.VesselOwnerName);
		System.out.println(row);
		System.out.println("Vessel Owner Name: " + getPageText(selection.VesselOwnerName));
		softAssert.assertEquals(getPageText(selection.VesselOwnerName), ownerName);
		System.out.println("Vessel Code: " + getPageText(selection.VesselCode));
		String vasselcode = getPageText(selection.VesselCode);
		String vc[] = vasselcode.split(":");
		softAssert.assertEquals(vc[1].trim(), vasselCode.trim(), vessel + " Vessel Code Not Matched");
		System.out.println("Financial Overview: " + getPageText(selection.FinancialOverview));
		eWait(selection.FinancialMonth);
		String myAEmonth = getPageText(selection.FinancialMonth);
		System.out.println("Financial Month: " + getPageText(selection.FinancialMonth));
		ReadExcelFile.setData(0, row, 4, myAEmonth,IndexedColors.BLACK.getIndex());
		if (month.equalsIgnoreCase(myAEmonth)) {
			ReadExcelFile.setData(0, row, 5,"Yes",IndexedColors.GREEN.getIndex());
			log.info("Financial Month Matched");
		} else {
			ReadExcelFile.setData(0, row, 5, "No",IndexedColors.RED.getIndex());
			log.info("Financial Month Not Matched");
		}
		softAssert.assertEquals(getPageText(selection.FinancialMonth), month, vessel + " Financial Month Not Matched");
		if (getPageText(selection.TotalBudget).equals("-")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Financial Header Not Load");
			ReadExcelFile.setData(0, row, 6, "Not Loading",IndexedColors.RED.getIndex());
			log.info("Financial Header Not Loading");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + "Financial Load");
			ReadExcelFile.setData(0, row, 6, "Loading",IndexedColors.GREEN.getIndex());
			log.info("Financial Header Loading");
		}
		System.out.println("Total Budget: " + getPageText(selection.TotalBudget));
		// System.out.println("Actual: "+ getPageText(selection.Actual));
		// System.out.println("Budget: "+ getPageText(selection.Budget));
		// System.out.println("Variance: "+ getPageText(selection.Variance));
		if (getPageText(selection.Variance).equals("-")) {
			System.out.println(ANSI_RED_BACKGROUND + vessel + " Financial Not Loading" + ANSI_RESET);
			log.info("Variance Not Loading");
		} else {
			System.out.println("Variance Budget: " + getPageText(selection.VarianceBudget));
			log.info("Variance Loading");
		}
		if (getPageText(selection.VarianceYTD).equals("-")) {
			log.info("VarianceYTD Not Loading");
		} else {
			System.out.println("VarianceYTD Budget: " + getPageText(selection.VarianceYTDBudget));
			log.info("VarianceYTD Loading");
		}
		eWait(selection.OPEXReport);
		selection.OPEXReport.click();
		Thread.sleep(1000);
		System.out.println("Operating Expenses Budget: " + getPageText(selection.OperatingExpenses));
		if (getPageText(selection.OperatingExpenses).contains("is not yet published")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Opex Report is not yet published");
			ReadExcelFile.setData(0, row, 8, "Not published",IndexedColors.RED.getIndex());
			log.info("Opex Report is not yet published");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + " Opex Report published");
			ReadExcelFile.setData(0, row, 8, "Published",IndexedColors.GREEN.getIndex());
			log.info("Opex Report published");
		}
		eWait(selection.inculdecheckbox);
		selection.inculdecheckbox.click();
		Thread.sleep(1000);

		if (getPageText(selection.TotalBudget).equals("-") && getPageText(selection.Actual).equals("-")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Financial Header Not Load");
			ReadExcelFile.setData(0, row, 7, "Not Loading",IndexedColors.RED.getIndex());
			log.info("Financial Header Not Loading");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + "Financial Load");
			ReadExcelFile.setData(0, row, 7, "Loading",IndexedColors.GREEN.getIndex());
			log.info("Financial Header Loading");
		}
		System.out.println("Total Budget: " + getPageText(selection.TotalBudget));
		// System.out.println("Actual: "+ getPageText(selection.Actual));
		// System.out.println("Budget: "+ getPageText(selection.Budget));
		// System.out.println("Variance: "+ getPageText(selection.Variance));

		if (getPageText(selection.Variance).equals("-")) {
			System.out.println(ANSI_RED_BACKGROUND + vessel + " Financial Not Loading" + ANSI_RESET);

		} else {
			System.out.println("Variance Budget: " + getPageText(selection.VarianceBudget));
			// System.out.println("color is: "+selection.color.getCssValue("color"));
		}
		// System.out.println("Variance Budget: "+
		// getPageText(selection.VarianceBudget));

		// System.out.println("ActualYTD: "+ getPageText(selection.ActualYTD));
		// System.out.println("BudgetYTD: "+ getPageText(selection.BudgetYTD));
		// System.out.println("VarianceYTD: "+ getPageText(selection.VarianceYTD));
		if (getPageText(selection.VarianceYTD).equals("-")) {
		} else {
			System.out.println("VarianceYTD Budget: " + getPageText(selection.VarianceYTDBudget));
			// System.out.println("color YTD is: "+selection.colorYTD.getCssValue("color"));
		}
		// System.out.println("VarianceYTD Budget: "+
		// getPageText(selection.VarianceYTDBudget));
		eWait(selection.OPEXReport);
		selection.OPEXReport.click();
		Thread.sleep(1000);
		System.out.println("Operating Expenses Budget: " + getPageText(selection.OperatingExpenses));
		if (getPageText(selection.OperatingExpenses).contains("is not yet published")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Opex Report is not yet published");
			ReadExcelFile.setData(0, row, 9, "Not published",IndexedColors.RED.getIndex());
			log.info("Opex Report is not yet published");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + " Opex Report published");
			ReadExcelFile.setData(0, row, 9, "Published",IndexedColors.GREEN.getIndex());
			log.info("Opex Report published");
		}
	}

	@AfterMethod
	public void AfterMethod() throws IOException, InterruptedException {
		row++;
		softAssert.assertTrue(true);
	}

	// DataProvider
	@DataProvider(name = "Vesseldata")
	public Object[][] testDataExample() throws IOException {
		// ReadExcelFile configuration = new
		// ReadExcelFile(System.getProperty("user.dir") +
		// "/src/main/resources/Data/ready.xlsx");
		ReadExcelFile configuration = new ReadExcelFile("D:\\WorkInno\\Poonam\\New folder\\QaExceptionReport.xls");
		int rows = configuration.getRowCount(0);
		int cells = configuration.getcellCount(0, rows);
		System.out.println(rows + "rows");
		System.out.println(cells + "cells");
		/* Object[][] signin_credentials = new Object[rows][cells];
		 *
		 * for (int i = 0; i < rows; i++) { for (int j = 0; j < cells; j++) {
		 * signin_credentials[i][j] = configuration.getData(0, i + 1, j); } }
		 */

		String[][] signin_credentials = new String[rows][cells];

		IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
				.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
		return signin_credentials;
	}

	@AfterClass
	public void endTest() throws IOException, InterruptedException {
		softAssert.assertAll();
		driver.close();
		log.info("Browser closed successfully");

	}
}
