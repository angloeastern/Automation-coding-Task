package testClass;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.Base;
import pages.NavigationPage;
import utilities.ReadExcel;

public class VoyageData extends Base {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_Y_BACKGROUND = "\u001B[43m";
	public static final String ANSI_G_BACKGROUND = "\u001B[42m";
	public static final String ANSI_G = "\u001B[32m";
	static String ownerName;
	static int row=1;

	public static SoftAssert softAssert = new SoftAssert();
	static NavigationPage selection;

	@BeforeClass
	public void ProgramStart() throws InterruptedException, IOException {
		AELogin.Login();
	}

	@Test(priority = 0, dataProvider = "VoyageInfo")

	public void VoyageInfo(String vesselCode,String vesselName) throws InterruptedException, IOException {
		try {
			System.out.println(vesselName + "******************");
			// Vessel Selection
			iWait();
			selection = new NavigationPage(driver);
			eWait(selection.vesseldropdown);
			selection.vesseldropdown.click();
			eWait(selection.Vesselclear);
			selection.Vesselclear.clear();
			eWait(selection.Vesselclear);
			selection.Vesselclear.click();
			eWait(selection.Vesselclear);
			selection.Vesselclear.sendKeys(vesselName);
			WebElement vessels = driver.findElement(By.xpath("//div[text()='" + vesselName + "']"));
			eWait(vessels);
			vessels.click();
			System.out.println(ANSI_G + "Vessel Selection successful" + ANSI_RESET);
			//log.info("Vessel Selection successfully");
		} catch (NoSuchElementException n) {
			// TODO: handle exception
			softAssert.assertTrue(false, "Error in vessel Search" +  n.getMessage());
			n.printStackTrace();
			System.out.println("Error in vessel Search" +  n.getMessage());
			//log.error("Error in vessel Search" + n.getMessage());

		}
		selection = new NavigationPage(driver);
		eWait(selection.VoyageSnapshot);
		String VoyageSnapshot = getPageText(selection.VoyageSnapshot);

		System.out.println(ANSI_Y_BACKGROUND + VoyageSnapshot + ANSI_RESET);

		//String VoyageSnapshot1 = getPageText(selection.VoyageSnapshot1);

		eWait(selection.VoyageSnapshot1);
		System.out.println(ANSI_G + "Voyage Snapshot Load Successfully" + ANSI_RESET);
		ReadExcel.setData(0, row,2, "Voyage Snapshot Load Successfully");
		String port = selection.port.getAttribute("title");
		System.out.println(port);

		if (port.equalsIgnoreCase("In Port")) {
			eWait(selection.portName);
			String portName = getPageText(selection.portName);
			String portOn = getPageText(selection.portOn);
			System.out.println("Vessel In Port: " + portName);
			ReadExcel.setData(0, row,4, portName);
			System.out.println("Vessel port on: " + portOn);
			ReadExcel.setData(0, row,6, portOn);
		} else if (port.equalsIgnoreCase("Last Port")) {
			eWait(selection.LastPort);
			System.out.println("Last Port: " + getPageText(selection.LastPort));
			ReadExcel.setData(0, row,3, getPageText(selection.LastPort));
			String portOn = getPageText(selection.LastPorton);
			System.out.println("Vessel port on: " + portOn);
			ReadExcel.setData(0, row,6, portOn);
			eWait(selection.NextPort);
			System.out.println("Next Port: " + getPageText(selection.NextPort));
			ReadExcel.setData(0, row,5, getPageText(selection.NextPort));
		} else {
			System.out.println("Voyage Snapshot not Loading");
			ReadExcel.setData(0, row,2, "Voyage Snapshot Not Loading");
		}

	}

	@AfterMethod
	public void AfterMethod() throws IOException, InterruptedException {
		row++;
		softAssert.assertTrue(true);
	}

	// DataProvider

	@DataProvider(name = "VoyageInfo")
	public Object[][] testDataExample() throws IOException {
		ReadExcel configuration = new ReadExcel(
				System.getProperty("user.dir") + "/src/main/resources/Data/voyageInfo.xlsx");

		int rows = configuration.getRowCount(0);
		int cells = configuration.getcellCount(0, rows);
		System.out.println(rows + "rows");
		System.out.println(cells + "cells");
		Object[][] signin_credentials = new Object[rows][cells];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				signin_credentials[i][j] = configuration.getData(0, i + 1, j);
			}
		}
		return signin_credentials;
	}

	@AfterClass
	public void endTest() throws IOException, InterruptedException {

		softAssert.assertAll();
		driver.close();
	}
}