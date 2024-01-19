package testClass;
import java.io.IOException;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.ShipyardDrawing;
import utilities.ReadExcelFile;


public class ShipyardDrawings extends VesselSearchOLD {
	static int ListSize;
	static String type;
	@Test
	public static void shipyardDrawings() throws InterruptedException, IOException {
		iWait();
		ShipyardDrawing selection = new ShipyardDrawing(driver);
		eWaitClick(selection.ShipyardDrawing);
		Thread.sleep(2000);
		boolean Record = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordSDPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (Record) {
			System.out.println(ANSI_RED+"Shipyard Drawing: " + eWaitText(selection.NoRecords)+ANSI_RESET);
			ReadExcelFile.setData(5, row,2, "No record to display",IndexedColors.RED.getIndex());
		} 
		else if (RecordSDPages) {
			ReadExcelFile.setData(5, row,2, "record display",IndexedColors.GREEN.getIndex());
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			 ListSize = wb.findElements(By.tagName("li")).size();
			System.out.println("Pages : " + ListSize);
			for (int j = 1; j < ListSize; j++) {
				int ListSizeI = selection.list.findElements(By.tagName("tr")).size();
				ListSize = wb.findElements(By.tagName("li")).size();
				System.out.println("Page :"+j);
				for (int i = 1; i <= ListSizeI; i++) {
					String name = driver
							.findElement(By
									.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[1]/span"))
							.getText();
					type = driver
							.findElement(
									By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[4]"))
							.getText();
					System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
					System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
					System.out.println();
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
			}
			if(type.equalsIgnoreCase("Folder")) {
				driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[1]/td[5]/div")).click();
				eWait(selection.OK);
			    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
			    ReadExcelFile.setData(5, row,3, "record download",IndexedColors.GREEN.getIndex());
				eWaitClick(selection.OK);
				}
				else
				{
					
					String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")).getText();
					driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[1]/td[5]/div")).click();
					downlaodFileChecker2(text,5,row,3);
				}
		}
		else {
			ReadExcelFile.setData(5, row,2, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeS = selection.list.findElements(By.tagName("tr")).size();
			System.out.println("Total Shipyard Drawing List: " + ListSizeS);
			for (int i = 1; i <= ListSizeS; i++) {
				String name = driver
						.findElement(By
								.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: " +ANSI_RESET+ name);
				System.out.print(ANSI_Y+"  Type: " +ANSI_RESET+ type);
				System.out.println();
			}
			
			if(type.equalsIgnoreCase("Folder")) {
			driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[1]/td[5]/div")).click();
			eWait(selection.OK);
		    System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
		    ReadExcelFile.setData(5, row,3, "record download",IndexedColors.GREEN.getIndex());
			eWaitClick(selection.OK);
			}
			else
			{
				
				String text=driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div/table/tbody/tr[1]/td[1]/span")).getText();
				driver.findElement(By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[1]/td[5]/div")).click();
				downlaodFileChecker2(text,5,row,3);
			}
		}

		eWaitClick(selection.InstructionManuals);
		Thread.sleep(1000);
		boolean RecordIM = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		Thread.sleep(500);
		boolean RecordIMPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
	
		if (RecordIM) {
			System.out.println(ANSI_RED+"Instruction Manuals: " + eWaitText(selection.NoRecords)+ANSI_RESET);
			ReadExcelFile.setData(5, row,4, "No record to display",IndexedColors.RED.getIndex());
		}

		else if (RecordIMPages) {
			ReadExcelFile.setData(5, row,4, "record display",IndexedColors.GREEN.getIndex());
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			 ListSize = wb.findElements(By.tagName("li")).size();
			System.out.println("Pages : " + ListSize);
			for (int j = 1; j < ListSize; j++) {
				int ListSizeI = selection.list.findElements(By.tagName("tr")).size();
				ListSize = wb.findElements(By.tagName("li")).size();
				System.out.println("Page :"+j);
				for (int i = 1; i <= ListSizeI; i++) {
					String name = driver
							.findElement(By
									.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[1]/span"))
							.getText();
					String type = driver
							.findElement(
									By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[4]"))
							.getText();
					System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
					System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
					System.out.println();
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
			}
		}
		else {
			ReadExcelFile.setData(5, row,4, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeI = selection.list.findElements(By.tagName("tr")).size();
			System.out.println("Total Instruction Manuals List: " + ListSizeI);
			
			for (int i = 1; i <= ListSizeI; i++) {
				String name = driver
						.findElement(By
								.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
				System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
				System.out.println();
			}
		}
		Thread.sleep(500);
		//selection.compass.click();

	}
}
