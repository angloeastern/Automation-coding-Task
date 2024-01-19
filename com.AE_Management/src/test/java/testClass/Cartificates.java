package testClass;

import java.io.IOException;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ConsoleColors;
import pages.CertificatePage;
import utilities.ReadExcelFile;

public class Cartificates extends VesselSearchOLD {
	static CertificatePage selection ;
  @Test
  public static void allCertificate() throws InterruptedException, IOException {
	     selection = new CertificatePage(driver);
	 
	     int certList= selection.CertificatesList.size();
	    String s=String.valueOf(certList);
	     if(certList!=0){
	     System.out.println(ConsoleColors.YELLOW_BOLD+"All Certificates :"+certList+ANSI_RESET);
	     ReadExcelFile.setData(3, row,2,s,IndexedColors.GREEN.getIndex());
	    eWaitClick(driver.findElement(By.xpath("(//div[@data-testid='collapse-content'])[1]/table/tbody/tr[2]/td[2]/span")));
		eWait(driver.findElement(By.xpath("//*[@id='view-body']/div[2]/div/div[1]/h3")));
		Thread.sleep(8000);
		String fileName=driver.findElement(By.xpath("//*[@id='view-body']/div[2]/div/div[1]/h3")).getText();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='view-body']/div[2]/div/div[1]/h3")).click();
		System.out.println(fileName);
		WebElement wb2=driver.findElement(By.xpath("(//*[@id='view-body']/div[2]/div/div[1]/div[2]/div/*)[1]"));
		eWait(wb2);
		Thread.sleep(500);
		wb2.click();
		downlaodFileChecker1(fileName,3,row,4);	
		Thread.sleep(500);	
		WebElement wb3=driver.findElement(By.xpath("(//*[@id='view-body']/div[2]/div/div[1]/div[2]/div/*)[2]"));
		eWait(wb3);
		wb3.click();
		
		eWaitClick(selection.BulkCertificates);
	//	eWaitClick(selection.OK);
		driver.findElement(By.xpath("//*[@class='sc-ddCuvZ ekpXcI']/div/div[2]/button")).click();
		System.out.println(ANSI_Y+ "You will receive an e-mail with a download link shortly"+ANSI_RESET);
/*		WebElement wb4=driver.findElement(By.xpath("(//div[@data-testid='collapse-toggle'])[2]"));
		eWait(wb4);
		wb4.click();
		WebElement wb5=driver.findElement(By.xpath("(//div[@data-testid='collapse-content'])[2]/table/tbody/tr[2]/td[2]/span"));
		eWait(wb5);
		wb5.click();
		WebElement wb6=driver.findElement(By.xpath("//*[@id='view-body']/div[2]/div/div[1]/h3"));
		eWait(wb6);
		Thread.sleep(8000);
		String fileName1=wb6.getText();
		Thread.sleep(500);
		wb6.click();
		System.out.println(fileName1);
		WebElement wb7=driver.findElement(By.xpath("(//*[@id='view-body']/div[2]/div/div[1]/div[2]/div/*)[1]"));
		eWait(wb7);
		Thread.sleep(500);
		wb7.click();
		downlaodFileChecker(fileName1);
		Thread.sleep(500);
		WebElement wb8=driver.findElement(By.xpath("(//*[@id='view-body']/div[2]/div/div[1]/div[2]/div/*)[2]"));
		eWait(wb8);
		wb8.click();
	*/	
	
	     }
	     else {
	    	 System.out.println(ConsoleColors.YELLOW_BOLD+"Certificates List is empty"+certList+ANSI_RESET);
	    	 ReadExcelFile.setData(3, row,2, "Certificates List is empty: "+s,IndexedColors.RED.getIndex());
	     }
	     
	        Thread.sleep(1000);	
			selection.compass.click();
			softAssert.assertTrue(true);

  }
 
}
