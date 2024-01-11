package testClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ConsoleColors;
import pages.ReportPage;

public class Reports extends VesselSearchOLD {
	static int ListSize;
	@Test
	public static void reports() throws InterruptedException {
		iWait();
		// ExternalInspections
		ReportPage selection = new ReportPage(driver);
		eWaitClick(selection.ExternalInspections);
		System.out.println(ConsoleColors.YELLOW_BOLD+"External Inspections"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordE = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordEMPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (RecordE) {
			System.out.println(ANSI_RED+"External Inspections: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else if (RecordEMPages) {
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			 ListSize = wb.findElements(By.tagName("li")).size();
			System.out.println("Pages : " + ListSize);
			for (int j = 1; j < ListSize; j++) {
				int ListSizeI = selection.table.findElements(By.tagName("tr")).size();
				ListSize = wb.findElements(By.tagName("li")).size();
				System.out.println("Page :"+j);
				for (int i = 1; i <= ListSizeI; i++) {
					String port = driver
							.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
							.getText();
					String type = driver
							.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[2]/span"))
							.getText();
					String status = driver
							.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[6]/span"))
							.getText();
					System.out.print(ANSI_Y+"Port: "+ANSI_RESET + port);
					System.out.print(ANSI_Y+"  Inspection Type: "+ANSI_RESET + type);
					System.out.print(ANSI_Y+"  Status: " +ANSI_RESET+ status);
					System.out.println();
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
				Thread.sleep(500);
			}
		}
		else {
			int ListSizeSEI = selection.table.findElements(By.tagName("tr")).size();
			System.out.println("Total External Inspections List: " + ListSizeSEI);
			for (int i = 1; i <= ListSizeSEI; i++) {
				String port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[2]/span"))
						.getText();
				String status = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[6]/span"))
						.getText();
				System.out.print(ANSI_Y+"Port: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Inspection Type: "+ANSI_RESET + type);
				System.out.print(ANSI_Y+"  Status: " +ANSI_RESET+ status);
				System.out.println();
			}
		}
		Thread.sleep(1000);

		// InternalInspections
		eWaitClick(selection.InternalInspections);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Internal Inspections"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordI = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordIMPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (RecordI) {
			System.out.println(ANSI_RED+"Internal Inspections: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else if (RecordIMPages) {
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			 ListSize = wb.findElements(By.tagName("li")).size();
			System.out.println("Pages : " + ListSize);
			for (int j = 1; j < ListSize; j++) {
				int ListSizeI = selection.table.findElements(By.tagName("tr")).size();
				ListSize = wb.findElements(By.tagName("li")).size();
				System.out.println("Page :"+j);
				for (int i = 1; i <= ListSizeI; i++) {
					String port = driver
							.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
							.getText();
					String type = driver
							.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[2]/span"))
							.getText();
					String status = driver
							.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[6]/span"))
							.getText();
					System.out.print(ANSI_Y+"Port: "+ANSI_RESET + port);
					System.out.print(ANSI_Y+"  Inspection Type: "+ANSI_RESET + type);
					System.out.print(ANSI_Y+"  Status: " +ANSI_RESET+ status);
					System.out.println();
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
				Thread.sleep(500);
			}
		}
		
		else {

			int ListSizeSII = selection.table.findElements(By.tagName("tr")).size();
			System.out.println("Total Internal Inspections List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[2]/span"))
						.getText();
				String status = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/table/tbody/tr[" + i + "]/td[6]/span"))
						.getText();
				System.out.print(ANSI_Y+"Port: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Inspection Type: "+ANSI_RESET + type);
				System.out.print(ANSI_Y+"  Status: " +ANSI_RESET+ status);
				System.out.println();
			}
		}
		
		// Dry-Dock
		eWaitClick(selection.DryDock);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Dry-Dock"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordDD = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordDD) {
			System.out.println(ANSI_RED+"Dry-Dock: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else {

			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Dry-Dock List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
		}
		// Claims
		eWaitClick(selection.Claims);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Claims"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordCL = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordCL) {
			System.out.println(ANSI_RED+"Claims: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else {

			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Claims List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
		}
		// Commercial
		eWaitClick(selection.Commercial);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Commercial"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordC = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordC) {
			System.out.println(ANSI_RED+"Commercial: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else {

			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Commercial List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
		}
		// Gallery
		eWaitClick(selection.Gallery);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Gallery"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordG = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordG) {
			System.out.println(ANSI_RED+"Gallery: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else {

			int ListSizeSII = driver.findElements(By.xpath("//*[@id='view-body']/div/div/div/div/div/div[1]/div/div[2]")).size();
			System.out.println("Total Gallery List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/div/div[1]/div["+i+"]/div[2]"))
						.getText();
				
				System.out.print(ANSI_Y+"Port: "+ANSI_RESET + port);
				System.out.println();
			}
		}
		// Other Reports
		eWaitClick(selection.OtherReports);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Other Reports"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordOR = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordOR) {
			System.out.println(ANSI_RED+"Other Reports: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else {

			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Other Reports List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				String port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
		}
	}
}
