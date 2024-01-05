package testClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.ShipyardDrawing;


public class ShipyardDrawings extends VesselSearchOLD {
	static int ListSize;
	@Test
	public static void shipyardDrawings() throws InterruptedException {
		iWait();
		ShipyardDrawing selection = new ShipyardDrawing(driver);
		eWaitClick(selection.ShipyardDrawing);
		Thread.sleep(2000);
		boolean Record = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordSDPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (Record) {
			System.out.println(ANSI_RED+"Shipyard Drawing: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		} 
		else if (RecordSDPages) {
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
			int ListSizeS = selection.list.findElements(By.tagName("tr")).size();
			System.out.println("Total Shipyard Drawing List: " + ListSizeS);
			for (int i = 1; i <= ListSizeS; i++) {
				String name = driver
						.findElement(By
								.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[1]/span"))
						.getText();
				String type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.print(ANSI_Y+"Name: " +ANSI_RESET+ name);
				System.out.print(ANSI_Y+"  Type: " +ANSI_RESET+ type);
				System.out.println();
			}
		}
		eWaitClick(selection.InstructionManuals);
		Thread.sleep(1000);
		boolean RecordIM = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		Thread.sleep(500);
		boolean RecordIMPages= driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		
	
		if (RecordIM) {
			System.out.println(ANSI_RED+"Instruction Manuals: " + eWaitText(selection.NoRecords)+ANSI_RESET);
		}

		else if (RecordIMPages) {
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
