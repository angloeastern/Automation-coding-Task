package testClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.CrewPage;

public class CrewTest extends VesselSearchOLD {
	
	@Test
	public static void crewRecords() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CrewPage selection=new CrewPage(driver);
		
		System.out.println("Last Crew Change: "+ eWaitText(selection.LastCrewChange));
		System.out.println("Last Crew Change Date: "+eWaitText(selection.LastCrewChangeDate));
		Thread.sleep(2000);
		System.out.println("Total Crew Onboard: "+eWaitText(selection.TotalCrewOnboard));
		int crewSize = Integer.parseInt(eWaitText(selection.TotalCrewOnboard));
		
		System.out.println("compared to budgeted: "+eWaitText(selection.comparedtobudgeted));
		System.out.println("Planned OffSigners: "+eWaitText(selection.PlannedOffSigners));
		Thread.sleep(2000);
		System.out.println("Overdue Crew: "+eWaitText(selection.OverdueCrew));
		System.out.println("Crew Budget Variance: "+eWaitText(selection.CrewBudgetVariance));
		
		if (eWaitText(selection.CrewBudgetVariance).equals("-"))
		{
			System.out.println("Crew Budget Variance is Empty");
		}
		else {
			System.out.println("Crew Variance Budget: "+eWaitText(selection.CrewVarianceBudget));
		}
	    int crewListSize=selection.crewlist.size();
	    System.out.println("Total crew List: "+crewListSize);
	    
	    Thread.sleep(2000);
	    selection.compass.click();
	   softAssert.assertEquals(crewSize, crewListSize);
	}

}
