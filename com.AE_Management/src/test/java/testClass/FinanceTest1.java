package testClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import ActionClass.VesselAction;
import pages.FinancePage;

public class FinanceTest1 extends VesselAction{

	@Test
	public static void FinanceRecords() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FinancePage selection = new FinancePage(driver);
		Thread.sleep(2000);
		System.out.println("Vessel Owner Name: "+ getPageText(selection.VesselOwnerName));
		System.out.println("Vessel Code: "+ getPageText(selection.VesselCode));
		System.out.println("Financial Overview: "+ getPageText(selection.FinancialOverview));
		
		Thread.sleep(2000);
		System.out.println("Total Budget: "+ getPageText(selection.TotalBudget));
		System.out.println("Actual: "+ getPageText(selection.Actual));
		System.out.println("Budget: "+ getPageText(selection.Budget));
		System.out.println("Variance: "+ getPageText(selection.Variance));
		if(getPageText(selection.Variance).equals("-")){
			
		}
		else
		{
			System.out.println("Variance Budget: "+ getPageText(selection.VarianceBudget));
			System.out.println("color is:  "+selection.color.getCssValue("color"));
		}
	//	System.out.println("Variance Budget: "+ getPageText(selection.VarianceBudget));
		
		System.out.println("ActualYTD: "+ getPageText(selection.ActualYTD));
		System.out.println("BudgetYTD: "+ getPageText(selection.BudgetYTD));
		System.out.println("VarianceYTD: "+ getPageText(selection.VarianceYTD));
         if(getPageText(selection.VarianceYTD).equals("-")){		
		}
		else
		{
			System.out.println("VarianceYTD Budget: "+ getPageText(selection.VarianceYTDBudget));
			System.out.println("color YTD is:  "+selection.colorYTD.getCssValue("color"));
		}
		//System.out.println("VarianceYTD Budget: "+ getPageText(selection.VarianceYTDBudget));
		
		
		Thread.sleep(2000);
	    selection.compass.click();
}
}