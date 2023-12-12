package testClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import ActionClass.VesselAction;
import pages.CrewPage;

public class CrewTest extends VesselAction {
	
	@Test
	public static void crewRecords() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CrewPage selection=new CrewPage(driver);
		
		System.out.println("Last Crew Change: "+ getPageText(selection.LastCrewChange));
		System.out.println("Last Crew Change Date: "+getPageText(selection.LastCrewChangeDate));
		Thread.sleep(2000);
		System.out.println("Total Crew Onboard: "+getPageText(selection.TotalCrewOnboard));
		int crewSize = Integer.parseInt(getPageText(selection.TotalCrewOnboard));
		
		System.out.println("compared to budgeted: "+getPageText(selection.comparedtobudgeted));
		System.out.println("Planned OffSigners: "+getPageText(selection.PlannedOffSigners));
		Thread.sleep(2000);
		System.out.println("Overdue Crew: "+getPageText(selection.OverdueCrew));
		System.out.println("Crew Budget Variance: "+getPageText(selection.CrewBudgetVariance));
		
		if (getPageText(selection.CrewBudgetVariance).equals("-"))
		{
			System.out.println("Crew Budget Variance is Empty");
		}
		else {
			System.out.println("Crew Variance Budget: "+getPageText(selection.CrewVarianceBudget));
		}
	    int crewListSize=selection.crewlist.size();
	    System.out.println("Total crew List: "+crewListSize);
	    
	    Thread.sleep(2000);
	    selection.compass.click();
	   softAssert.assertEquals(crewSize, crewListSize);
	}

}
