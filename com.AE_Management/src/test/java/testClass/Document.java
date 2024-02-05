package testClass;

import java.io.IOException;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ConsoleColors;
import pages.DocumentPage;
import utilities.ReadExcelFile;

public class Document extends VesselSearchOLD {
	static DocumentPage selection;
	static int ListSize;

	@Test
	public static void document(String documentName) throws InterruptedException, IOException {
		selection = new DocumentPage(driver);
		iWait();
		Thread.sleep(700);
		eWaitClick(selection.orgDropdown);
		eWaitClear(selection.orgclear);
		eWaitClick(selection.orgclear);
		eWait(selection.orgclear);
		selection.orgclear.sendKeys(documentName);
		boolean exists = driver.findElements(By.xpath("//div[text()='" + documentName + "']")).size() != 0;
		if (exists) {
			WebElement document = driver.findElement(By.xpath("//div[text()='" + documentName + "']"));
			System.out.println(documentName);
			eWaitClick(document);
		} else {
			System.out.println("Error in ORG Search");
			log.error("Error in ORG Search");
			eWaitClear(selection.orgclear);
			Thread.sleep(1000);
			eWaitClick(selection.orgDropdown);
			Assert.assertTrue(false, "ORG not founded in list");
		}
		
		Thread.sleep(2000);
		boolean RecordDD = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordSDPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		String type = null;
		String port =null;
		if (RecordDD) {
			System.out.println(ANSI_RED+"" + eWaitText(selection.RecordDpl)+ANSI_RESET);
			ReadExcelFile.setData(7, row,1, "No record to display",IndexedColors.RED.getIndex());
		} 
		else if (RecordSDPages) {
			ReadExcelFile.setData(7, row,1, "record display",IndexedColors.GREEN.getIndex());
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			 ListSize = wb.findElements(By.tagName("li")).size();
			System.out.println("Pages : " + ListSize);
			int count=0;
			for (int j = 1; j < ListSize; j++) {
				int ListSizeI = selection.table.findElements(By.tagName("tr")).size();
				ListSize = wb.findElements(By.tagName("li")).size();
				System.out.println("Page :"+j);
				for (int i = 1; i <= ListSizeI; i++) {
					String name = driver
							.findElement(By
									.xpath("//*[@id='view-body']/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
							.getText();
					type = driver
							.findElement(
									By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[" + i + "]/td[4]"))
							.getText();
					System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
					System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
					System.out.println();
					count++;
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
			}
			System.out.println("Total Doucment: "+count);
			String TD=String.valueOf(count);
			 ReadExcelFile.setData(7, row,2, TD,IndexedColors.GREEN.getIndex());
			if(type.equalsIgnoreCase("Folder")) {
				driver.findElement(By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[1]/td[5]/div")).click();
				eWait(selection.OK);
			    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
			    ReadExcelFile.setData(7, row,3, "record download",IndexedColors.GREEN.getIndex());
				eWaitClick(selection.OK);
				}
				else
				{
					
					String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[1]/td[1]/span")).getText();
					driver.findElement(By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[1]/td[5]/div")).click();
					downlaodFileChecker2(text,7,row,3);
				}
		}
		else {
			ReadExcelFile.setData(7, row,1, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeS = selection.table.findElements(By.tagName("tr")).size();
			System.out.println("Total Shipyard Drawing List: " + ListSizeS);
			int count=0;
			for (int i = 1; i <= ListSizeS; i++) {
				String name = driver
						.findElement(By
								.xpath("//*[@id='view-body']/div/div/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: " +ANSI_RESET+ name);
				System.out.print(ANSI_Y+"  Type: " +ANSI_RESET+ type);
				System.out.println();
				count++;
			}
			System.out.println("Total Doucment: "+count);
			String TD=String.valueOf(count);
			ReadExcelFile.setData(7, row,2, TD,IndexedColors.GREEN.getIndex());
			if(type.equalsIgnoreCase("Folder")) {
			driver.findElement(By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[1]/td[5]/div")).click();
			eWait(selection.OK);
		    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
		    ReadExcelFile.setData(7, row,3, "record download",IndexedColors.GREEN.getIndex());
			eWaitClick(selection.OK);
			}
			else
			{
				
				String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[1]/td[1]/span")).getText();
				driver.findElement(By.xpath("//*[@id='view-body']/div/div/table/tbody/tr[1]/td[5]/div")).click();
				downlaodFileChecker2(text,7,row,3);
			}
			
			
			//div[@role='button']/button
		}
		Thread.sleep(2000);
		selection.compass.click();
	}
}
