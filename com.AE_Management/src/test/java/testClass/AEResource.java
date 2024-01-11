package testClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.AEResourcesPage;

public class AEResource extends VesselSearchOLD {
	static int ListSize;

	@Test
	public static void aeResources() throws InterruptedException {
		iWait();
		AEResourcesPage selection = new AEResourcesPage(driver);
		eWaitClick(selection.Lookout);
		System.out.println("Lookout");
		Thread.sleep(1000);

		boolean RecordLookout = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordLookoutPages = driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (RecordLookout) {
			System.out.println(ANSI_RED + "Lookout: " + eWaitText(selection.NoRecords) + ANSI_RESET);
		} else if (RecordLookoutPages) {
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
					String type = driver
							.findElement(By
									.xpath("//*[@id='view-body']/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[1]"))
							.getText();
					String updateOn = driver.findElement(By
							.xpath("//*[@id=\"view-body\"]/div/div/div/div[1]/div/div[" + i + "]/div[2]/div[2]/div[1]"))
							.getText();
					System.out.print(ANSI_Y + "Name: " + ANSI_RESET + name);
					System.out.print(ANSI_Y + "  Type: " + ANSI_RESET + type);
					System.out.print(ANSI_Y + "  updateOn: " + ANSI_RESET + updateOn);
					System.out.println();
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
				Thread.sleep(500);
			}
		} else {
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
			}
		}

		eWaitClick(selection.filelines);
		Thread.sleep(1000);
		eWaitClick(selection.compassdrafting);
		WebElement element = selection.PSC;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		eWaitClick(selection.PSC);
		System.out.println("PSC");
		Thread.sleep(1000);

		boolean RecordPSC = driver.findElements(By.xpath("//*[text()='No record to display']")).size() != 0;
		boolean RecordPSCPages = driver.findElements(By.xpath("//*[@title='navigation']")).size() != 0;
		if (RecordPSC) {
			System.out.println(ANSI_RED + "PSC: " + eWaitText(selection.NoRecords) + ANSI_RESET);
		} else if (RecordPSCPages) {
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
				}
				driver.findElement(By.xpath("//*[@title='navigation']/li[" + ListSize + "]")).click();
				Thread.sleep(500);
			}
		} else {
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
			}
		}
		   Thread.sleep(1000);
		   selection.compass.click();
	}
}