package myAE_testClass;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ConsoleColors;
import pages.FinancePage;
import utilities.ReadExcelFile;

public class FinanceTest extends VesselSearchOLD {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_Y_BACKGROUND = "\u001B[43m";
	public static final String ANSI_G_BACKGROUND = "\u001B[42m";
	public static final String ANSI_G = "\u001B[32m";
	public static SoftAssert softAssert = new SoftAssert();
	static final short red = IndexedColors.RED.getIndex();
	static final short black = IndexedColors.BLACK.getIndex();
	static final short green = IndexedColors.GREEN.getIndex();
	static String type;
	static FinancePage selection;
	@Test
	public static void FinanceRecords(String vasselCode, String vessel)
		{
		
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		selection = new FinancePage(driver);
		Thread.sleep(2000);
		System.out.println("Vessel Owner Name: " + eWaitText(selection.VesselOwnerName));
		// softAssert.assertEquals(getPageText(selection.VesselOwnerName), ownerName);
		System.out.println("Vessel Code: " + eWaitText(selection.VesselCode));
		String vasselcode = eWaitText(selection.VesselCode);
		String vc[] = vasselcode.split(":");

		softAssert.assertEquals(vc[1].trim(), vasselCode.trim(), vessel + " Vessel Code Not Matched");

	    System.out.println("Financial Overview: " + eWaitText(selection.FinancialOverview));
		Thread.sleep(2000);

		String myAEmonth = getPageText(selection.FinancialMonth);
		System.out.println("Financial Month: " + eWaitText(selection.FinancialMonth));
		ReadExcelFile.setData(2, row, 4, myAEmonth, black);

		// if (month.equalsIgnoreCase(myAEmonth)) {
		// ReadExcelFile.setData(0, row, 4, "Matched",red);
		// } else {
		// ReadExcelFile.setData(0, row, 4, "Period Not Matched",red);
		// }

		// softAssert.assertEquals(getPageText(selection.FinancialMonth), month, vessel
		// + " Financial Month Not Matched");

		if (getPageText(selection.TotalBudget).equals("-")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Financial Header Not Load");
			ReadExcelFile.setData(2, row, 6, "Financial Header Not Loading", red);
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + "Financial Load");
			ReadExcelFile.setData(2, row, 6, "Financial Header Load", green);
		}
		System.out.println("Total Budget: " + eWaitText(selection.TotalBudget));
		System.out.println("Actual: " + eWaitText(selection.Actual));
		// System.out.println("Actual: "+ eWaitText(selection.TableActual));
		System.out.println("Budget: " + eWaitText(selection.Budget));
		System.out.println("Variance: " + eWaitText(selection.Variance));

		if (eWaitText(selection.Variance).equals("-")) {
			System.out.println(ANSI_RED_BACKGROUND + vessel + " Financial Not Loading" + ANSI_RESET);

		} else {
			System.out.println("Variance Budget: " + eWaitText(selection.VarianceBudget));
			System.out.println("color is: " + selection.color.getCssValue("color"));
		}
		System.out.println("ActualYTD: " + eWaitText(selection.ActualYTD));
		System.out.println("BudgetYTD: " + eWaitText(selection.BudgetYTD));
		System.out.println("VarianceYTD: " + eWaitText(selection.VarianceYTD));
		if (eWaitText(selection.VarianceYTD).equals("-")) {
		} else {
			System.out.println("VarianceYTD Budget: " + eWaitText(selection.VarianceYTDBudget));
			System.out.println("color YTD is: " + selection.colorYTD.getCssValue("color"));
		}

		/*
		 * getScreenShotAs(System.getProperty("user.dir") + "\\" +
		 * "\\ScreenShotsDetails\\" + Base.getDateTimeStamp() + ".png",
		 * selection.BUDGETACTUALMONTH); Thread.sleep(2000);
		 * getScreenShotAs(System.getProperty("user.dir") + "\\" +
		 * "\\ScreenShotsDetails\\" + Base.getDateTimeStamp() + ".png",
		 * selection.AVERAGEDAILY); Thread.sleep(2000);
		 * getScreenShotAs(System.getProperty("user.dir") + "\\" +
		 * "\\ScreenShotsDetails\\" + Base.getDateTimeStamp() + ".png",
		 * selection.BUDGETACTUALYEAR);
		 */
		Thread.sleep(2000);
		selection.OPEXReport.click();
		Thread.sleep(2000);

		System.out.println("Operating Expenses Budget: " + getPageText(selection.OperatingExpenses));

		if (getPageText(selection.OperatingExpenses).contains("is not yet published")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Opex Report is not yet published");
			ReadExcelFile.setData(2, row, 8, "Opex Report is not yet published", red);
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + " Opex Report published");
			ReadExcelFile.setData(2, row, 8, "Opex Report published", green);

			softAssert.assertEquals(eWaitText(selection.Actual), eWaitText(selection.TableActual));
			softAssert.assertEquals(eWaitText(selection.Budget), eWaitText(selection.TableBudget));
			softAssert.assertEquals(eWaitText(selection.Variance), eWaitText(selection.TableVariance));

			softAssert.assertEquals(eWaitText(selection.ActualYTD), eWaitText(selection.TableActualYTD));
			softAssert.assertEquals(eWaitText(selection.BudgetYTD), eWaitText(selection.TableBudgetYTD));
			softAssert.assertEquals(eWaitText(selection.VarianceYTD), eWaitText(selection.TableVarianceYTD));
		}

		Thread.sleep(2000);
		selection.inculdecheckbox.click();
		Thread.sleep(2000);

		if (eWaitText(selection.TotalBudget).equals("-")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Financial Header Not Load");
			ReadExcelFile.setData(2, row, 7, "Financial Header Not Loading", red);
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + "Financial Load");
			ReadExcelFile.setData(2, row, 7, "Financial Header Load", green);
		}
		System.out.println("Total Budget: " + eWaitText(selection.TotalBudget));
		System.out.println("Actual: " + eWaitText(selection.Actual));
		System.out.println("Budget: " + eWaitText(selection.Budget));
		System.out.println("Variance: " + eWaitText(selection.Variance));

		if (eWaitText(selection.Variance).equals("-")) {
			System.out.println(ANSI_RED_BACKGROUND + vessel + " Financial Not Loading" + ANSI_RESET);

		} else {
			System.out.println("Variance Budget: " + eWaitText(selection.VarianceBudget));
			System.out.println("color is: " + selection.color.getCssValue("color"));
		}

		System.out.println("ActualYTD: " + eWaitText(selection.ActualYTD));
		System.out.println("BudgetYTD: " + eWaitText(selection.BudgetYTD));
		System.out.println("VarianceYTD: " + eWaitText(selection.VarianceYTD));
		if (eWaitText(selection.VarianceYTD).equals("-")) {
		} else {
			System.out.println("VarianceYTD Budget: " + eWaitText(selection.VarianceYTDBudget));
			System.out.println("color YTD is: " + selection.colorYTD.getCssValue("color"));
		}

		Thread.sleep(2000);
		selection.OPEXReport.click();
		Thread.sleep(2000);

		System.out.println("Operating Expenses Budget: " + getPageText(selection.OperatingExpenses));

		if (getPageText(selection.OperatingExpenses).contains("is not yet published")) {
			softAssert.assertTrue(false, vasselCode + " " + vessel + " Opex Report is not yet published");
			ReadExcelFile.setData(2, row, 9, "Opex Report is not yet published", red);
		} else {
			softAssert.assertTrue(true, vasselCode + " " + vessel + " Opex Report published");
			ReadExcelFile.setData(2, row, 9, "Opex Report published", green);

			softAssert.assertEquals(eWaitText(selection.Actual), eWaitText(selection.TotalActual));
			softAssert.assertEquals(eWaitText(selection.Budget), eWaitText(selection.TotalBudgett));
			softAssert.assertEquals(eWaitText(selection.Variance), eWaitText(selection.TotalVariance));

			softAssert.assertEquals(eWaitText(selection.ActualYTD), eWaitText(selection.TotalActualYTD));
			softAssert.assertEquals(eWaitText(selection.BudgetYTD), eWaitText(selection.TotalBudgetYTD));
			softAssert.assertEquals(eWaitText(selection.VarianceYTD), eWaitText(selection.TotalVarianceYTD));

		}
		
     	Thread.sleep(2000);
		// Other Reports (Vessels)
		eWaitClick(selection.OtherReportsVessels);
		System.out.println(ConsoleColors.YELLOW_BOLD + "Other Reports (Vessels)" + ANSI_RESET);
		Thread.sleep(2000);
		
		boolean RecordORV = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.evaluate(\"//div[contains(text(),'No record to display')]\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");

		if (RecordORV) {
			System.out.println(ANSI_RED + "Other Reports: " + eWaitText(selection.noRecords) + ANSI_RESET);
			ReadExcelFile.setData(2, row, 10, "No record to display", red);
		} else {
			if(!(boolean) ((JavascriptExecutor) driver).executeScript(
	                "return document.evaluate(\"//*[@id='view-body']/div[3]/div/div/div/table/tbody\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;")) {
				System.out.println(ANSI_RED+"Other Reports: No record to display"+ANSI_RESET);
				ReadExcelFile.setData(2, row, 10, "No record to display", red);
			}
			else{
			ReadExcelFile.setData(2, row, 10, "record display", green);
			int ListSizeSII = selection.table.findElements(By.tagName("tr")).size();
			System.out.println("Total Other Reports List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By
								.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y + "Name: " + ANSI_RESET + port);
				System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
				System.out.println();
			}

			if (type.equalsIgnoreCase("Folder")) {
				driver.findElement(By.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[1]/td[5]/div"))
						.click();
				boolean popup = (boolean) ((JavascriptExecutor) driver).executeScript(
		                "return document.evaluate(\"//button[text()='OK']\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");
			 
				//Boolean popup= selection.OKKk.size() != 0;
				if (popup) {
					System.out.println(ANSI_Y + "You will receive an e-mail with a download link shortly" + ANSI_RESET);
					ReadExcelFile.setData(4, row, 7, "Download", IndexedColors.GREEN.getIndex());
					eWaitClick(selection.OK);
				} else {
					System.out.println(ANSI_Y + "Download Popup Not shown" + ANSI_RESET);
					ReadExcelFile.setData(4, row, 7, "Download Popup Not shown", IndexedColors.RED.getIndex());
					eWaitClick(selection.OK);
				}
			} else {

				String text = driver
						.findElement(By.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[1]/td[1]/span"))
						.getText();
				driver.findElement(By.xpath("//*[text()='" + text + "']/../../td[5]/div")).click();
				downlaodFileCheckerType(text);
			}
		}}

		Thread.sleep(2000);
		// Other Reports (Fleet)
		eWaitClick(selection.OtherReportsFleet);
		System.out.println(ConsoleColors.YELLOW_BOLD + "Other Reports (Fleet)" + ANSI_RESET);
		
		Thread.sleep(2000);
		boolean RecordORF = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.evaluate(\"//div[contains(text(),'No record to display')]\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");

		if (RecordORF) {
			System.out.println(ANSI_RED + "Other Reports: " + eWaitText(selection.noRecords) + ANSI_RESET);
			ReadExcelFile.setData(2, row, 11, "No record to display", red);
		} else {
			if(!(boolean) ((JavascriptExecutor) driver).executeScript(
	                "return document.evaluate(\"//*[@id='view-body']/div[3]/div/div/div/table/tbody\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;")) {
				System.out.println(ANSI_RED+"Other Reports: No record to display"+ANSI_RESET);
				ReadExcelFile.setData(2, row, 11, "No record to display", red);
			}
			else{
			ReadExcelFile.setData(2, row, 11, "record display", green);
			int ListSizeSII = selection.table.findElements(By.tagName("tr")).size();
			System.out.println("Total Other Reports List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By
								.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y + "Name: " + ANSI_RESET + port);
				System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
				System.out.println();
			}
			if (type.equalsIgnoreCase("Folder")) {
				driver.findElement(By.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[1]/td[5]/div"))
						.click();
				boolean popup = (boolean) ((JavascriptExecutor) driver).executeScript(
		                "return document.evaluate(\"//button[text()='OK']\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");
			 
				//Boolean popup= selection.OKKk.size() != 0;
				//int popup = driver.findElements(By.xpath("//div[@class='sc-hRnpUl hMOnCD']")).size();
				System.out.println(popup);
				if (popup) {
					System.out.println(ANSI_Y + "You will receive an e-mail with a download link shortly" + ANSI_RESET);
					ReadExcelFile.setData(4, row, 7, "Download", IndexedColors.GREEN.getIndex());
					eWaitClick(selection.OK);
				} else {
					System.out.println(ANSI_Y + "Download Popup Not shown" + ANSI_RESET);
					ReadExcelFile.setData(4, row, 7, "Download Popup Not shown", IndexedColors.RED.getIndex());
					eWaitClick(selection.OK);
				}
			} else {

				String text = driver
						.findElement(By.xpath("//*[@id='view-body']/div[3]/div/div/div/table/tbody/tr[1]/td[1]/span"))
						.getText();
				driver.findElement(By.xpath("//*[text()='" + text + "']/../../td[5]/div")).click();
				downlaodFileCheckerType(text);
			}
			
		}}

		//driver.findElement(By.xpath("//div[@role='button']/button"));
		//eWaitClick(selection.OK);
		
		Thread.sleep(2000);
		selection.compass.click();
	}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error("Finance Records"+e.getMessage());
			selection.compass.click();
			
		}
	}
	

}