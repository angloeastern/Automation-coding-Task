package testClass;

import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import pages.CrewPage;
import utilities.ReadExcelFile;

public class CrewTest extends VesselSearchOLD {
	static int count = 0;
	static int crewSize = 0;
	static CrewPage selection;

	@Test
	public static void crewRecords() throws Exception {

		try {
			iWait();
			selection = new CrewPage(driver);

			System.out.println("Last Crew Change: " + eWaitText(selection.LastCrewChange));
			if (eWaitText(selection.LastCrewChange).equals("-")) {
				System.out.println("Last Crew Change is Empty");
				ReadExcelFile.setData(1, row, 2, "Last Crew Change is Empty", IndexedColors.RED.getIndex());
			} else {
				System.out.println("Last Crew Change Date: " + eWaitText(selection.LastCrewChangeDate));
				ReadExcelFile.setData(1, row, 2, eWaitText(selection.LastCrewChangeDate),
						IndexedColors.GREEN.getIndex());
			}
			System.out.println("Total Crew Onboard: " + eWaitText(selection.TotalCrewOnboard));
			if (eWaitText(selection.TotalCrewOnboard).equals("-")) {
				System.out.println("Total Crew Onboard is Empty");
				ReadExcelFile.setData(1, row, 3, "Not Loading", IndexedColors.RED.getIndex());
			} else {
				crewSize = Integer.parseInt(eWaitText(selection.TotalCrewOnboard));
				ReadExcelFile.setData(1, row, 3, "Loading", IndexedColors.GREEN.getIndex());
				// System.out.println("compared to budgeted: " +
				// eWaitText(selection.comparedtobudgeted));
				System.out.println("Planned OffSigners: " + eWaitText(selection.PlannedOffSigners));
				System.out.println("Overdue Crew: " + eWaitText(selection.OverdueCrew));
			}
			System.out.println("Crew Budget Variance: " + eWaitText(selection.CrewBudgetVariance));

			if (eWaitText(selection.CrewBudgetVariance).equals("-")) {
				System.out.println("Crew Budget Variance is Empty");
			} else {
				System.out.println("Crew Variance Budget: " + eWaitText(selection.CrewVarianceBudget));
			}

			boolean crewRecord = (boolean) ((JavascriptExecutor) driver).executeScript(
	                "return document.evaluate(\"//div[contains(text(),'No record to display')]\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");
  
			if (crewRecord) {
				System.out.println(ANSI_RED + "crewRecord: " + eWaitText(selection.NoRecords) + ANSI_RESET);
				ReadExcelFile.setData(1, row, 4, "No record to display", IndexedColors.RED.getIndex());
			} else {
				int crewListSize = selection.crewlist.size();
				ReadExcelFile.setData(1, row, 5, eWaitText(selection.TotalCrewOnboard), IndexedColors.GREEN.getIndex());
				System.out.println("Total crew List: " + crewListSize);
				softAssert.assertEquals(crewSize, crewListSize);
				IntStream.rangeClosed(1, crewListSize).forEach(i -> {
					String Rank = driver
							.findElement(By.xpath(
									"//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[" + i + "]/td[1]/div/span[2]"))
							.getText();
					String StaffId = driver
							.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[" + i + "]/td[2]"))
							.getText();
					String fName = driver
							.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[" + i + "]/td[3]"))
							.getText();
					String lName = driver
							.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[" + i + "]/td[3]"))
							.getText();
					String status = driver
							.findElement(By
									.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[" + i + "]/td[9]/div/span"))
							.getText();

					if (status.equalsIgnoreCase("Relief Due")) {
						count++;
					}
				});
				String Plannoff = eWaitText(selection.PlannedOffSigners);
				if (Plannoff.equalsIgnoreCase("-")) {
					System.out.println("No PlannedOff crew");
				} else {
					int PlannedOffSigners = Integer.parseInt(Plannoff);
					softAssert.assertEquals(count, PlannedOffSigners, "PlannedOff Matched");
					// eWaitClick(selection.crewStatus);
				}
				String Rank = driver
						.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]"))
						.getText();
				String StaffId = driver.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[1]/td[2]"))
						.getText();
				String fName = driver.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[1]/td[3]"))
						.getText();
				String lName = driver.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[1]/td[4]"))
						.getText();
				String Name = fName + " " + lName;

				System.out.println(Rank + "" + StaffId + "" + Name);

				driver.findElement(By.xpath("//div[@data-testid='crew-list' or @aria-label='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]"))
						.click();
				ReadExcelFile.setData(1, row, 6, "Opend", IndexedColors.GREEN.getIndex());
		
				System.out.println("RANK: " + eWaitText(selection.pRank));
				System.out.println("NAME: " + eWaitText(selection.pName));
				System.out.println(eWaitText(selection.pStaff));
				String pstaff = eWaitText(selection.pStaff);
				String[] stf = pstaff.split(":");

				softAssert.assertEquals(Rank, eWaitText(selection.pRank));
				softAssert.assertEquals(StaffId.trim(), stf[1].trim());
				softAssert.assertEquals(Name, eWaitText(selection.pName));

				// eWaitClick(selection.CrewBio);
				System.out.println("Crew Bio : Personal Details");
				System.out.println("NATIONALITY: " + getPageText(selection.Nationality));
				System.out.println("AGE: " + getPageText(selection.Age));

				System.out.println("Crew Bio: Contract Information");
				// System.out.println("LAST UPDATED ON: "+getPageText(selection.ContectUPDATE));
				System.out.println("LAST UPDATED ON: " + getPageText(selection.Status));
				System.out.println("LAST UPDATED ON: " + getPageText(selection.SignOnDate));

				eWaitClick(selection.Documents);
				System.out.println("Documents : License");
				Thread.sleep(2000);
				String cssColorString = selection.License.getCssValue("color");
				Color color = Color.fromString(cssColorString);
				System.out.println(color.asHex());
				if (color.asHex().equalsIgnoreCase("#00b2ba")) {
					eWaitText(selection.License);
					eWaitClick(selection.License);
					Thread.sleep(8000);
					getPageText(selection.Text);
					softAssert.assertEquals(eWaitText(selection.License), getPageText(selection.Text));
					Thread.sleep(2000);
					eWaitClick(selection.download);
					Thread.sleep(3000);
					downlaodFileChecker(getPageText(selection.Text));
					eWaitClick(selection.xmark);
					Thread.sleep(3000);
				}
				System.out.println("Documents : Certificates");
				Thread.sleep(2000);
				String cssColorString1 = selection.Certificates.getCssValue("color");
				Color color1 = Color.fromString(cssColorString1);
				System.out.println(color.asHex());
				if (color1.asHex().equalsIgnoreCase("#00b2ba")) {
					eWaitText(selection.Certificates);
					eWaitClick(selection.Certificates);
					Thread.sleep(8000);
					getPageText(selection.Text);
					softAssert.assertEquals(eWaitText(selection.Certificates), getPageText(selection.Text));
					Thread.sleep(2000);
					eWaitClick(selection.download);
					Thread.sleep(3000);
					downlaodFileChecker(eWaitText(selection.Text));
					eWaitClick(selection.xmark);
				}
				ReadExcelFile.setData(1, row, 7, "Loading", IndexedColors.GREEN.getIndex());
				eWaitClick(selection.PastExperience);
				System.out.println("PastExperience : Crew Experience Matrix");

			}
			Thread.sleep(1000);
			selection.compass.click();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error("Crew Info" + e.getMessage());
			selection.compass.click();
			throw new Exception("Other Exception", e);
		}
	}
}
