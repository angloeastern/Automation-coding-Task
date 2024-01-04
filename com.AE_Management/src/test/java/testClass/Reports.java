package testClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.ReportPage;

public class Reports extends VesselSearchOLD {
	static int ListSize;
	@Test
	public static void reports() throws InterruptedException {
		iWait();
		// ExternalInspections
		ReportPage selection = new ReportPage(driver);
		eWait(selection.ExternalInspections);
		selection.ExternalInspections.click();
		Thread.sleep(2000);
		boolean RecordE = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordEMPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (RecordE) {
			System.out.println(ANSI_RED+"External Inspections: " + getPageText(selection.NoRecords)+ANSI_RESET);
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
		eWait(selection.InternalInspections);
		selection.InternalInspections.click();
		Thread.sleep(2000);
		boolean RecordI = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordIMPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (RecordI) {
			System.out.println(ANSI_RED+"Internal Inspections: " + getPageText(selection.NoRecords)+ANSI_RESET);
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
		// selection.compass.click();
	}
}
