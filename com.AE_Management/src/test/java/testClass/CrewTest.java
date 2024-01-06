package testClass;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CrewPage;

public class CrewTest extends VesselSearchOLD {
	static int count=0;
	@Test
	public static void crewRecords() throws InterruptedException
	{

		iWait();
		CrewPage selection=new CrewPage(driver);
		
		System.out.println("Last Crew Change: "+ eWaitText(selection.LastCrewChange));
		System.out.println("Last Crew Change Date: "+eWaitText(selection.LastCrewChangeDate));
		System.out.println("Total Crew Onboard: "+eWaitText(selection.TotalCrewOnboard));
		int crewSize = Integer.parseInt(eWaitText(selection.TotalCrewOnboard));	
		
		System.out.println("compared to budgeted: "+eWaitText(selection.comparedtobudgeted));
		System.out.println("Planned OffSigners: "+eWaitText(selection.PlannedOffSigners));
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

	    IntStream.rangeClosed(1, crewListSize).forEach(i -> {
	    	String Rank=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr["+i+"]/td[1]/div/span[2]")).getText();
	    	String StaffId=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr["+i+"]/td[2]")).getText();
	    	String fName=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr["+i+"]/td[3]")).getText();
	    	String lName=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr["+i+"]/td[3]")).getText();
	    	String status=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr["+i+"]/td[9]/div/span")).getText();    	
	    	
	    	if(status.equalsIgnoreCase("Relief Due"))
	        {
	        	count++;
	        }
	    });
	    softAssert.assertEquals(count,eWaitText(selection.PlannedOffSigners),"PlannedOff Matched");
	    //eWaitClick(selection.crewStatus);
	   
	    String Rank=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]")).getText();
    	String StaffId=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[2]")).getText();
    	String fName=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[3]")).getText();
    	String lName=driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[3]")).getText();
    	String Name=fName+lName;
    	driver.findElement(By.xpath("//div[@data-testid='crew-list']/table/tbody/tr[1]/td[1]/div/span[2]")).click();
	 
    	String pRank=driver.findElement(By.xpath("//div[@data-testid='profile']/div/div[1]")).getText();
    	String pStaff=driver.findElement(By.xpath("//div[@data-testid='profile']/div/div[3]")).getText();
    	String pName=driver.findElement(By.xpath("//div[@data-testid='profile']/div/div[2]")).getText();
        System.out.println("Rank: "+pRank);
        System.out.println("Staff Id: "+pStaff);
        System.out.println("Name: "+pName);
	    softAssert.assertEquals(Rank,pRank);
	    softAssert.assertEquals(StaffId,pStaff);
	    softAssert.assertEquals(pName,Name);
	    		
	    
    	
    	Thread.sleep(1000);
	    selection.compass.click();
	   softAssert.assertEquals(crewSize, crewListSize);
	}

}
