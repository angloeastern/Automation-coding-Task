package myAE_testClass;

import java.io.IOException;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.AEResourcesPage;
import utilities.ReadExcelFile;

public class AEResource extends VesselSearchOLD {
	static int ListSize;
	
	@Test
	public static void aeResources() throws InterruptedException, IOException {
		iWait();
		AEResourcesPage selection = new AEResourcesPage(driver);
		eWaitClick(selection.Lookout);
		System.out.println("Lookout");
		Thread.sleep(1000);

		boolean RecordLookout = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.evaluate(\"//div[contains(text(),'No record to display')]\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");
	 
	  boolean RecordLookoutPages = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.evaluate(\"//*[@title='navigation']\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");
       
		if (RecordLookout) {
			System.out.println(ANSI_RED + "Lookout: " + eWaitText(selection.NoRecords) + ANSI_RESET);
			ReadExcelFile.setData(6, row,2, "No record to display",IndexedColors.RED.getIndex());
		} else if (RecordLookoutPages) {
		int count=0;
		String type = null ;
			ReadExcelFile.setData(6, row,2, "record display",IndexedColors.GREEN.getIndex());
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			ListSize = wb.findElements(By.tagName("li")).size();
			System.out.println("Pages : " + ListSize);
			for (int j = 1; j < ListSize; j++) {
				// int ListSizeI = selection.LookoutList.findElements(By.tagName("div")).size();
				int ListSizeI = driver.findElements(By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div")).size();
				ListSize = wb.findElements(By.tagName("li")).size();
				System.out.println("Page :" + j);
				for (int i = 1; i <= ListSizeI; i++) {
					String name = driver
							.findElement(
									By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/h3"))
							.getText();
					 type = driver
							.findElement(By
									.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[1]"))
							.getText();
					String updateOn = driver.findElement(By
							.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[2]/div[1]"))
							.getText();
					System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
					System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
					System.out.print(ANSI_Y + "  updateOn: " + ANSI_RESET + updateOn);
					System.out.println();
					count++;
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
				Thread.sleep(500);
			}
			System.out.println("Total Lookout Records: "+count);

			eWaitClick(selection.LD);
			Thread.sleep(8000);
			getPageText(selection.Text);
			softAssert.assertEquals(eWaitText(selection.LD)+".pdf", getPageText(selection.Text));
			Thread.sleep(2000);
			eWaitClick(selection.download);
			Thread.sleep(3000);
			downlaodFileCheckerType(eWaitText(selection.Text));
			eWaitClick(selection.xmark);
		} else {
			int count=0;
			ReadExcelFile.setData(6, row,2, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeI = driver.findElements(By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div")).size();
			System.out.println("Total Shipyard Drawing List: " + ListSizeI);
			for (int i = 1; i <= ListSizeI; i++) {
				String name = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/h3"))
						.getText();
				String type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[1]"))
						.getText();
				String updateOn = driver
						.findElement(By.xpath(
								"//*[@id=\"view-body\"]/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[2]/div[1]"))
						.getText();
				System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
				System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
				System.out.print(ANSI_Y + "  updateOn: " + ANSI_RESET + updateOn);
				System.out.println();
				count++;
			}
			System.out.println("Total Lookout Records: "+count);
			eWaitClick(selection.LD);
			Thread.sleep(8000);
			getPageText(selection.Text);
			softAssert.assertEquals(eWaitText(selection.LD)+".pdf", getPageText(selection.Text));
			Thread.sleep(2000);
			eWaitClick(selection.download);
			Thread.sleep(3000);
			downlaodFileCheckerType(eWaitText(selection.Text));
			eWaitClick(selection.xmark);
		}

		eWaitClick(selection.filelines);
		Thread.sleep(1000);
		eWaitClick(selection.compassdrafting);
		WebElement element = selection.PSC;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		eWaitClick(selection.PSC);
		System.out.println("PSC");
		Thread.sleep(1000);
		boolean RecordPSC = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.evaluate(\"//div[contains(text(),'No record to display')]\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");
	 
	  boolean RecordPSCPages = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.evaluate(\"//*[@title='navigation']\", document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue;");

		if (RecordPSC) {
			System.out.println(ANSI_RED + "PSC: " + eWaitText(selection.NoRecords) + ANSI_RESET);
			ReadExcelFile.setData(6, row,3, "No record to display",IndexedColors.RED.getIndex());
		} else if (RecordPSCPages) {
			int count=0;
			ReadExcelFile.setData(6, row,3, "record display",IndexedColors.GREEN.getIndex());
			WebElement wb = driver.findElement(By.xpath("//*[@title='navigation']"));
			ListSize = wb.findElements(By.tagName("li")).size();
			System.out.println("Pages : " + ListSize);
			for (int j = 1; j < ListSize; j++) {
				int ListSizeI = driver.findElements(By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div")).size();
				ListSize = wb.findElements(By.tagName("li")).size();
				System.out.println("Page :" + j);
				for (int i = 1; i <= ListSizeI; i++) {
					String name = driver
							.findElement(
									By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/h3"))
							.getText();
					String type = driver
							.findElement(By
									.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[1]"))
							.getText();
					String updateOn = driver
							.findElement(By.xpath(
									"//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[2]/div[1]"))
							.getText();
					System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
					System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
					System.out.print(ANSI_Y + "  updateOn: " + ANSI_RESET + updateOn);
					System.out.println();
					count++;
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
				Thread.sleep(500);
			}
			System.out.println("Total PSC Records: "+count);
			eWaitClick(selection.LD);
			Thread.sleep(8000);
			getPageText(selection.Text);
			softAssert.assertEquals(eWaitText(selection.LD)+".pdf", getPageText(selection.Text));
			Thread.sleep(2000);
			eWaitClick(selection.download);
			Thread.sleep(3000);
			downlaodFileCheckerType(eWaitText(selection.Text));
			eWaitClick(selection.xmark);
			
		} else {
			int count=0;
			ReadExcelFile.setData(6, row,3, "record display",IndexedColors.GREEN.getIndex());
			int ListSizeI = driver.findElements(By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div")).size();
			System.out.println("Total Shipyard Drawing List: " + ListSizeI);
			for (int i = 1; i <= ListSizeI; i++) {
				String name = driver
						.findElement(By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/h3"))
						.getText();
				String type = driver
						.findElement(
								By.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[1]"))
						.getText();
				String updateOn = driver
						.findElement(By.xpath(
								"//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[2]/div[1]"))
						.getText();
				System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
				System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
				System.out.print(ANSI_Y + "  updateOn: " + ANSI_RESET + updateOn);
				System.out.println();
				count++;
			}
			System.out.println("Total PSC Records: "+count);
			eWaitClick(selection.LD);
			Thread.sleep(8000);
			getPageText(selection.Text);
			softAssert.assertEquals(eWaitText(selection.LD)+".pdf", getPageText(selection.Text));
			Thread.sleep(2000);
			eWaitClick(selection.download);
			Thread.sleep(3000);
			downlaodFileCheckerType(eWaitText(selection.Text));
			eWaitClick(selection.xmark);
		}
		   Thread.sleep(1000);
		   selection.compass.click();
	}
}