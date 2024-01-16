package testClass;

import java.io.IOException;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ConsoleColors;
import pages.ReportPage;
import utilities.ReadExcelFile;

public class Reports extends VesselSearchOLD {
	static int ListSize;
	@Test
	public static void reports() throws InterruptedException, IOException {
		iWait();
		// ExternalInspections
		ReportPage selection = new ReportPage(driver);
		eWaitClick(selection.ExternalInspections);
		System.out.println(ConsoleColors.YELLOW_BOLD+"External Inspections"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordE = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordEMPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
	/*	if (RecordE) {
			System.out.println(ANSI_RED+"External Inspections: " + eWaitText(selection.NoRecords)+ANSI_RESET);
			ReadExcelFile.setData(4, row,2, "No record to display",IndexedColors.RED.getIndex());
		} 
		else if (RecordEMPages) {
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			 ListSize = wb.findElements(By.tagName("li")).size();
			 ReadExcelFile.setData(4, row,2, "record display",IndexedColors.GREEN.getIndex());
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
			ReadExcelFile.setData(4, row,2, "record display",IndexedColors.GREEN.getIndex());
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
			ReadExcelFile.setData(4, row,3, "No record to display",IndexedColors.RED.getIndex());
		} 
		else if (RecordIMPages) {
			ReadExcelFile.setData(4, row,3, "record display",IndexedColors.GREEN.getIndex());
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
			ReadExcelFile.setData(4, row,3, "record display",IndexedColors.GREEN.getIndex());
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
		*/
		// Dry-Dock
		eWaitClick(selection.DryDock);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Dry-Dock"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordDD = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		String type = null;
		String port =null;
		if (RecordDD) {
			System.out.println(ANSI_RED+"Dry-Dock: " + eWaitText(selection.NoRecords)+ANSI_RESET);
			ReadExcelFile.setData(4, row,4, "No record to display",IndexedColors.RED.getIndex());
		} 
		else {
			ReadExcelFile.setData(4, row,4, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Dry-Dock List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
			if(type.equalsIgnoreCase("Folder")) {
				eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")));
				driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")).click();
				eWait(selection.OK);
			    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
			    ReadExcelFile.setData(4, row,5, "Download",IndexedColors.GREEN.getIndex());
				eWaitClick(selection.OK);
				}
				else
				{
					eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")));
				//	String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")).getText();
					driver.findElement(By.xpath("//*[text()='"+port+"']/../../td[5]/div")).click();
					downlaodFileChecker2(port,4,row,5);
					//System.out.println(driver.findElements(By.xpath("//button[text()='OK']")).size());
					/*if(driver.findElements(By.xpath("//button[text()='OK']")).size()!=0)
					{
						eWaitClick(selection.OK);
					}*/
				}
		}
		// Claims
		eWaitClick(selection.Claims);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Claims"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordCL = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordCL) {
			System.out.println(ANSI_RED+"Claims: " + eWaitText(selection.NoRecords)+ANSI_RESET);
			ReadExcelFile.setData(4, row,6, "No record to display",IndexedColors.RED.getIndex());
		} 
		else {
			ReadExcelFile.setData(4, row,6, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Claims List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
			if(type.equalsIgnoreCase("Folder")) {
				eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")));
				driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")).click();
				eWait(selection.OK);
			    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
			    ReadExcelFile.setData(4, row,7, "Download",IndexedColors.GREEN.getIndex());
				eWaitClick(selection.OK);
				}
				else
				{
					eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")));
					//String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")).getText();
					driver.findElement(By.xpath("//*[text()='"+port+"']/../../td[5]/div")).click();
					downlaodFileChecker2(port,4,row,7);
				}
		}
		// Commercial
		eWaitClick(selection.Commercial);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Commercial"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordC = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordC) {
			System.out.println(ANSI_RED+"Commercial: " + eWaitText(selection.NoRecords)+ANSI_RESET);
			ReadExcelFile.setData(4, row,8, "No record to display",IndexedColors.RED.getIndex());
		} 
		else {
			ReadExcelFile.setData(4, row,8, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Commercial List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
			if(type.equalsIgnoreCase("Folder")) {
				eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")));
				driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")).click();
				eWait(selection.OK);
			    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
			    ReadExcelFile.setData(4, row,9, "Download",IndexedColors.GREEN.getIndex());
				eWaitClick(selection.OK);
				}
				else
				{
					eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")));
					//String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")).getText();
					driver.findElement(By.xpath("//*[text()='"+port+"']/../../td[5]/div")).click();
					downlaodFileChecker2(port,4,row,9);
				}
		}
		// Gallery
		eWaitClick(selection.Gallery);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Gallery"+ANSI_RESET);
		Thread.sleep(2000);
		boolean RecordG = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		if (RecordG) {
			System.out.println(ANSI_RED+"Gallery: " + eWaitText(selection.NoRecords)+ANSI_RESET);
			ReadExcelFile.setData(4, row,10, "No record to display",IndexedColors.RED.getIndex());
		} 
		else {
			ReadExcelFile.setData(4, row,10, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeSII = driver.findElements(By.xpath("//*[@id='view-body']/div/div/div/div/div/div[1]/div/div[2]")).size();
			System.out.println("Total Gallery List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				 port = driver
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
			ReadExcelFile.setData(4, row,11, "No record to display",IndexedColors.RED.getIndex());
		} 
		else {
			ReadExcelFile.setData(4, row,11, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeSII = selection.table1.findElements(By.tagName("tr")).size();
			System.out.println("Total Other Reports List: " + ListSizeSII);
			for (int i = 1; i <= ListSizeSII; i++) {
				 port = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				 type = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: "+ANSI_RESET + port);
				System.out.print(ANSI_Y+"  Type: "+ANSI_RESET + type);
				System.out.println();
			}
		}
		if(type.equalsIgnoreCase("Folder")) {
			eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")));
			driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[5]/div")).click();
			eWait(selection.OK);
		    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
		    ReadExcelFile.setData(4, row,12, "Download",IndexedColors.GREEN.getIndex());
			eWaitClick(selection.OK);
			}
			else
			{
				eWait(driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")));
				//String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")).getText();
				driver.findElement(By.xpath("//*[text()='"+port+"']/../../td[5]/div")).click();
				downlaodFileChecker2(port,4,row,12);
			}
	}
}
