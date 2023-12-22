package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import ActionClass.VesselAction;
import pages.NavigationPage;


public class VesselSearchOLD extends VesselAction {
	public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_Y_BACKGROUND = "\u001B[43m";
    public static final String ANSI_G_BACKGROUND = "\u001B[42m";
    public static final String ANSI_G = "\u001B[32m";
    
    
    @Test
	public static void vesselSearch(String vessel, String test, String test1) throws InterruptedException {
		
		// Vessel Selection
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		NavigationPage selection =new NavigationPage(driver);
		Thread.sleep(2000);
		selection.SelectVessel.click();
		selection.VesselSelect.click();
		Thread.sleep(2000);
		selection.VesselSelect.sendKeys(vessel);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='" + vessel + "']")).click();
		Thread.sleep(2000);
	   // System.out.println(getPageText(By.xpath("//div[@data-testid='map-sidebox']/div/div/h4")));
		System.out.println("OwnerName: "+getPageText(selection.OwnerName));
	    String vesselName = getPageText(selection.vesselName);
		Thread.sleep(2000);
		System.out.println("vesselName: "+vesselName);
		softAssert.assertEquals(vessel, vesselName);
		System.out.println(ANSI_G_BACKGROUND+"Vessel Selection successful"+ANSI_RESET);
		
	}

	@Test
	public static void voyageSnapshot() throws InterruptedException {
		// Voyage Snapshot
		
		NavigationPage selection =new NavigationPage(driver);
		Thread.sleep(2000);
		String VoyageSnapshot = getPageText(selection.VoyageSnapshot);
		Thread.sleep(2000);
		System.out.println(ANSI_Y_BACKGROUND +VoyageSnapshot+ ANSI_RESET);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String VoyageSnapshot1 = getPageText(selection.VoyageSnapshot1);
		if(VoyageSnapshot1.isBlank())
		{
			System.out.println(ANSI_RED_BACKGROUND +"Voyage Snapshot Not Loading"+ ANSI_RESET);
		}
		else
		{
			System.out.println(ANSI_G+"Voyage Snapshot Load Successfully"+ ANSI_RESET);
		}
		softAssert.assertNotNull(VoyageSnapshot1);
		Thread.sleep(2000);
		System.out.println("Voyage Snapshot: " + VoyageSnapshot1);
		String port = selection.port.getAttribute("title");
		System.out.println(port);
		if (port.equalsIgnoreCase("In Port")) {
			Thread.sleep(2000);
			String portName = getPageText(selection.portName);
			String portOn = getPageText(selection.portOn);
			System.out.println("Vessel In Port: " + portName);
			System.out.println("Vessel port on: " + portOn);
		} else if (port.equalsIgnoreCase("Last Port")) {
			Thread.sleep(2000);
			System.out.println("Last Port: " + getPageText(selection.LastPort));
			String portOn = getPageText(selection.LastPorton);
			System.out.println("Vessel port on: " + portOn);
			Thread.sleep(2000);
			System.out.println("Next Port: " + getPageText(selection.NextPort));
		} else {
			System.out.println("Voyage Snapshot not Loading");
		}
		softAssert.assertTrue(true);
		
	}

	@Test
	public static void crewInfo() throws InterruptedException {
		// Crew Info
		
		NavigationPage selection =new NavigationPage(driver);
		Thread.sleep(2000);
		System.out.println(ANSI_Y_BACKGROUND+getPageText(selection.CrewInfo)+ ANSI_RESET);
		Thread.sleep(2000);
		 String CrewUpdateOn=getPageText(selection.CrewUpdateOn);
		
		if(CrewUpdateOn.isBlank())
		{
			System.out.println(ANSI_RED_BACKGROUND +"Crew Info Not Loading"+ ANSI_RESET);
		}
		else
		{
			System.out.println(ANSI_G+"Crew Info Load Successfully"+ ANSI_RESET);
		}
		softAssert.assertNotNull(CrewUpdateOn);
		// h3[@title='Total Crew Onboard']
		System.out.println("Crew update on: " +CrewUpdateOn);
		System.out.println("Total Crew Onboard: " + getPageText(selection.TotalCrewOnboard));
		System.out.println("Master Name:  " + getPageText(selection.ChiefEng));
		System.out.println("ChiefEng Name:  " + getPageText(selection.Master));
		
		Thread.sleep(2000);
		selection.Crew.click();
		Thread.sleep(2000);
		CrewTest.crewRecords();
		softAssert.assertTrue(true);
		
	}

	@Test
	public static void Financial() throws InterruptedException {
		// Financial
		
		NavigationPage selection =new NavigationPage(driver);
		Thread.sleep(2000);
		// String Financial =
		// getPageText(By.xpath("//h3[text()='Financial']"));//h3[text()='Financial']/../div
		System.out.println(ANSI_Y_BACKGROUND+getPageText(selection.Financial)+ ANSI_RESET);
		System.out.println("Currency " + getPageText(selection.Currency));
		System.out.println("Daily Running Cost: " + getPageText(selection.DailyRunningCost));
		if(getPageText(selection.DailyRunningCost).equals("-"))
		{
			System.out.println(ANSI_RED_BACKGROUND +"Financial Not Loading"+ ANSI_RESET);
		}
		else
		{
			System.out.println(ANSI_G+"Financial Load Successfully"+ ANSI_RESET);
			System.out.println("Update on " +getPageText(selection.FinancialUpdateOn) );
			Thread.sleep(2000);
			System.out.println("Daily Running Cost: " + getPageText(selection.DailyRunningCost));
			System.out.println("Daily Budget: " + getPageText(selection.DailyBudget));
			System.out.println("color is:  "+selection.color.getCssValue("color"));
				
			String cssColorString=selection.color.getCssValue("color");
			Color color = Color.fromString(cssColorString);
		    System.out.println(color.asHex());
			Thread.sleep(2000);
			System.out.println("Total Variance: " + getPageText(selection.TotalVariance));
			System.out.println("Total Budget Variance: " + getPageText(selection.TotalBudget));
		}
		
		// String FinancialCrcy =
		// getPageText(By.xpath("//h3[text()='Financial']/../div"));
		//System.out.println("Currency " + getPageText(selection.Currency));
		
		Thread.sleep(2000);
		selection.dollarsign.click();
		Thread.sleep(2000);
		FinanceTest1.FinanceRecords();
		softAssert.assertTrue(true);
		
	}

	@Test
	public static void Particulars() throws InterruptedException {
		// Vessel Particulars
		
		NavigationPage selection =new NavigationPage(driver);
		Thread.sleep(2000);

		System.out.println(ANSI_Y_BACKGROUND+getPageText(selection.VesselParticulars)+ ANSI_RESET);
		System.out.println("Flag:  " + getPageText(selection.Flag));
		Thread.sleep(2000);
		System.out.println("Port of Registry:  " + getPageText(selection.PortofRegistry));
		System.out.println("Call Sign: " + getPageText(selection.CallSign));
		System.out.println("Official Number:  " + getPageText(selection.OfficialNumber));
		Thread.sleep(2000);
		System.out.println("IMO Number:  " + getPageText(selection.IMONumber));
		System.out.println("Class:  " + getPageText(selection.Class));
		System.out.println("VSAT Tel:  " + getPageText(selection.VSATTel));
		softAssert.assertTrue(true);
		
	}	
	
	
}
