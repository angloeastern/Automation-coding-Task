package testClass;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.FinancePage;
import utilities.ReadExcelFile;

public class FinanceTest extends VesselSearch {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_Y_BACKGROUND = "\u001B[43m";
	public static final String ANSI_G_BACKGROUND = "\u001B[42m";
	public static final String ANSI_G = "\u001B[32m";
	public static SoftAssert softAssert = new SoftAssert();
	static int row = 1;

	@Test
	public static void FinanceRecords(String month, String vasselCode, String ownerName, String vessel)
			throws InterruptedException, ParseException, IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FinancePage selection = new FinancePage(driver);
		Thread.sleep(2000);
		System.out.println(row);
		System.out.println("Vessel Owner Name: " + getPageText(selection.VesselOwnerName));
		softAssert.assertEquals(getPageText(selection.VesselOwnerName), ownerName);
		System.out.println("Vessel Code: " + getPageText(selection.VesselCode));
		String vasselcode = getPageText(selection.VesselCode);
		String vc[] = vasselcode.split(":");

		softAssert.assertEquals(vc[1].trim(), vasselCode.trim(), vessel + " Vessel Code Not Matched");

		System.out.println("Financial Overview: " + getPageText(selection.FinancialOverview));
		Thread.sleep(2000);

		String myAEmonth = getPageText(selection.FinancialMonth);
		System.out.println("Financial Month: " + getPageText(selection.FinancialMonth));
		ReadExcelFile.setData(0, row, 3, myAEmonth);

		if (month.equalsIgnoreCase(myAEmonth)) {
			ReadExcelFile.setData(0, row, 4, "Matched");
		} else {
			ReadExcelFile.setData(0, row, 4, "Period Not Matched");
		}

		softAssert.assertEquals(getPageText(selection.FinancialMonth), month, vessel + " Financial Month Not Matched");

		if (getPageText(selection.TotalBudget).equals("-")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Financial Header Not Load");
			ReadExcelFile.setData(0, row, 5, "Financial Header Not Loading");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + "Financial Load");
			ReadExcelFile.setData(0, row, 5, "Financial Header Load");
		}
		System.out.println("Total Budget: " + getPageText(selection.TotalBudget));
		// System.out.println("Actual: "+ getPageText(selection.Actual));
		// System.out.println("Budget: "+ getPageText(selection.Budget));
		// System.out.println("Variance: "+ getPageText(selection.Variance));
		Thread.sleep(2000);
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
		Thread.sleep(2000);

		selection.OPEXReport.click();
		Thread.sleep(2000);

		System.out.println("Operating Expenses Budget: " + getPageText(selection.OperatingExpenses));

		if (getPageText(selection.OperatingExpenses).contains("is not yet published")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Opex Report is not yet published");
			ReadExcelFile.setData(0, row, 6, "Opex Report is not yet published");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + " Opex Report published");
			ReadExcelFile.setData(0, row, 6, "Opex Report published");
		}

		Thread.sleep(2000);
		selection.inculdecheckbox.click();
		Thread.sleep(2000);

		if (getPageText(selection.TotalBudget).equals("-")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Financial Header Not Load");
			ReadExcelFile.setData(0, row, 7, "Financial Header Not Loading");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + "Financial Load");
			ReadExcelFile.setData(0, row, 7, "Financial Header Load");
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
		Thread.sleep(2000);

		selection.OPEXReport.click();
		Thread.sleep(2000);

		System.out.println("Operating Expenses Budget: " + getPageText(selection.OperatingExpenses));

		if (getPageText(selection.OperatingExpenses).contains("is not yet published")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Opex Report is not yet published");
			ReadExcelFile.setData(0, row, 8, "Opex Report is not yet published");
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + " Opex Report published");
			ReadExcelFile.setData(0, row, 8, "Opex Report published");
		}

		Thread.sleep(2000);
		row++;
		selection.compass.click();

		softAssert.assertAll();
	}

}