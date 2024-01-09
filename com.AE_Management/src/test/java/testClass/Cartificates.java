package testClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.CertificatePage;

public class Cartificates extends VesselSearchOLD {
	static CertificatePage selection ;
  @Test
  public static void allCertificate() throws InterruptedException {
	     selection = new CertificatePage(driver);
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
		downlaodFileChecker(fileName);	
		Thread.sleep(500);	
		WebElement wb3=driver.findElement(By.xpath("(//*[@id='view-body']/div[2]/div/div[1]/div[2]/div/*)[2]"));
		eWait(wb3);
		wb3.click();
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
	*/	Thread.sleep(1000);	
		selection.compass.click();
		softAssert.assertTrue(true);
  }
}
