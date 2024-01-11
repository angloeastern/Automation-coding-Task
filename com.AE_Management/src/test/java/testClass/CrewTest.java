package testClass;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CrewPage;

public class CrewTest extends VesselSearchOLD {
	static int count = 0;
	static int crewSize = 0;

	@Test
	public static void crewRecords() throws InterruptedException {

		iWait();
		CrewPage selection = new CrewPage(driver);

		System.out.println("Last Crew Change: " + eWaitText(selection.LastCrewChange));
		if (eWaitText(selection.LastCrewChange).equals("-")) {
			System.out.println("Last Crew Change is Empty");
		} else {
			System.out.println("Last Crew Change Date: " + eWaitText(selection.LastCrewChangeDate));
		}
		System.out.println("Total Crew Onboard: " + eWaitText(selection.TotalCrewOnboard));
		if (eWaitText(selection.TotalCrewOnboard).equals("-")) {
			System.out.println("Total Crew Onboard is Empty");
		} else {
			crewSize = Integer.parseInt(eWaitText(selection.TotalCrewOnboard));
			System.out.println("compared to budgeted: " + eWaitText(selection.comparedtobudgeted));
			System.out.println("Planned OffSigners: " + eWaitText(selection.PlannedOffSigners));
			System.out.println("Overdue Crew: " + eWaitText(selection.OverdueCrew));
		}
		System.out.println("Crew Budget Variance: " + eWaitText(selection.CrewBudgetVariance));

		if (eWaitText(selection.CrewBudgetVariance).equals("-")) {
			System.out.println("Crew Budget Variance is Empty");
		} else {
			System.out.println("Crew Variance Budget: " + eWaitText(selection.CrewVarianceBudget));
		}

		boolean crewRecord = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (crewRecord) {
			System.out.println(ANSI_RED + "crewRecord: " + eWaitText(selection.NoRecords) + ANSI_RESET);
		} else {
			int crewListSize = selection.crewlist.size();
			System.out.println("Total crew List: " + crewListSize);
			softAssert.assertEquals(crewSize, crewListSize);
			IntStream.rangeClosed(1, crewListSize).forEach(i -> {
				String Rank = driver
						.findElement(
								By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[" + i + "]/td[1]/div/span[2]"))
						.getText();
				String StaffId = driver
						.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[" + i + "]/td[2]"))
						.getText();
				String fName = driver
						.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[" + i + "]/td[3]"))
						.getText();
				String lName = driver
						.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[" + i + "]/td[3]"))
						.getText();
				String status = driver
						.findElement(
								By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[" + i + "]/td[9]/div/span"))
						.getText();

				if (status.equalsIgnoreCase("Relief Due")) {
					count++;
				}
			});
			softAssert.assertEquals(count, eWaitText(selection.PlannedOffSigners), "PlannedOff Matched");
			// eWaitClick(selection.crewStatus);

			String Rank = driver
					.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]"))
					.getText();
			String StaffId = driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[2]"))
					.getText();
			String fName = driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[3]"))
					.getText();
			String lName = driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[4]"))
					.getText();
			String Name = fName + " " + lName;

			System.out.println(Rank + "" + StaffId + "" + Name);

			driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]")).click();

			System.out.println("RANK: " + eWaitText(selection.pRank));
			System.out.println("NAME: " + eWaitText(selection.pName));
			System.out.println(eWaitText(selection.pStaff));
			String pstaff = eWaitText(selection.pStaff);
			String[] stf = pstaff.split(":");

			softAssert.assertEquals(Rank, eWaitText(selection.pRank));
			softAssert.assertEquals(StaffId, stf[1]);
			softAssert.assertEquals(Name, eWaitText(selection.pName));

			// eWaitClick(selection.CrewBio);
			System.out.println("Crew Bio : Personal Details");
			System.out.println("NATIONALITY: " + getPageText(selection.Nationality));
			System.out.println("AGE: " + getPageText(selection.Age));

			System.out.println("Crew Bio: Contract Information");
			// System.out.println("LAST UPDATED ON: "+getPageText(selection.ContectUPDATE));
			System.out.println("LAST UPDATED ON: " + getPageText(selection.Status));
			System.out.println("LAST UPDATED ON: " + getPageText(selection.SignOnDate));

			System.out.println("Documents : License");
			eWaitClick(selection.Documents);
			Thread.sleep(2000);
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

			System.out.println("Documents : Certificates");
			Thread.sleep(2000);
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

			eWaitClick(selection.PastExperience);
			System.out.println("PastExperience : Crew Experience Matrix");
			
		}
			Thread.sleep(1000);
			selection.compass.click();
			
		
	}
}
