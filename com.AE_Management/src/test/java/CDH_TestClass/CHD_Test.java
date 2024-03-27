package CDH_TestClass;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.Base;
import cdh_pages.CDH_Page;

public class CHD_Test extends Base {
	static int ListSize;
	static Logger log = LogManager.getLogger(CHD_Test.class.getName());
	public static SoftAssert softAssert = new SoftAssert();
	public static CDH_Page selection ;
	@BeforeClass
	public void startTest() throws InterruptedException, IOException {
		PropertyConfigurator.configure("D:\\WorkInno\\Poonam\\Tasks\\AE Automation\\AE_Management\\src\\main\\java\\config\\log4j.properties");
		Initialize("chrome");
		driver.get(getProperty("CDH"));
		selection = new CDH_Page(driver);
		Thread.sleep(3000);
		selection.email.sendKeys("z-gurjarp@angloeastern.com");
		eWaitClick(selection.next);
		//	driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys("z-gurjarp@angloeastern.com");
		//	driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		selection.password.sendKeys("HappyyJoyy@12345678");
		eWaitClick(selection.submit);
		//	driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("HappyyJoyy@12345678");
		//	driver.findElement(By.xpath("//input[@data-report-event='Signin_Submit']")).click();
		Thread.sleep(2000);
	}
	@Test
	public static void cdh() throws InterruptedException, IOException {
		iWait();
		selection = new CDH_Page(driver);
		eWaitClick(selection.FinancialReports);
		int size,vsize,vesselsize=0;
		//	eWaitClick(selection.searchBox);
		//	selection.searchBox.sendKeys("Agricore Shipping");
		//	eWaitClick(selection.searchButton);

		size=driver.findElements(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)")).size();
		System.out.println(size);
		int counter=0;

		for(int i=1;i<=115;i++)
		{
			Thread.sleep(500);
			System.out.println("Owner Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+i+"]")));
			System.out.println("Owner Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+i+"]")).getText());
			System.out.println("File Size: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[7]/div)["+i+"]")).getText());
			int NofileSize = Integer.parseInt(driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[7]/div)["+i+"]")).getText().trim().replaceAll("[^0-9]", ""));
			
			if(NofileSize>0)
			{
				Thread.sleep(300);
				eWaitClick(driver.findElement(By.xpath("(//button[@data-automationid='FieldRenderer-name'])["+i+"]")));		
				vsize=driver.findElements(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)")).size();
				System.out.println("rrrrrrrrrrrr"+vsize);
				
				
				for(int j=1;j<=vsize;j++)
				{
					Thread.sleep(200);
					System.out.println("vessel Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+j+"]")));
					System.out.println("vessel Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+j+"]")).getText());
					System.out.println("vessel File Size: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[7]/div)["+j+"]")).getText());
					int NovfileSize = Integer.parseInt(driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[7]/div)["+j+"]")).getText().trim().replaceAll("[^0-9]", ""));
					if(NovfileSize>0)
					{	
					java.util.List<WebElement> li =driver.findElements(By.xpath("(//*[@data-automationid='DetailsRow']/div[2]/div[2]/div/div[1]/span/span/button)"));
					System.out.println(li);
					for(WebElement s :li)
					{
						Thread.sleep(300);
						String vessel=s.getText();
						System.out.println(vessel);
					
						Thread.sleep(300);
	//					((JavascriptExecutor) driver).executeScript("window.scrollBy(1,-1000)"); 
						WebElement element = driver.findElement(By.xpath("//button[text()='"+vessel+"']"));
	//					WebElement element = driver.findElement(By.xpath("(//*[@data-automationid='DetailsRow']/div[2]/div[2]/div/div[1]/span/span/button)["+j+"]"));
    //					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//					Thread.sleep(300);
						//element.click();
						eWaitClick(element);
						
						vesselsize=driver.findElements(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)")).size();
						System.out.println("aaaaaaaaaaa"+vesselsize);
						for(int k=1;k<=vesselsize;k++)
						{
							Thread.sleep(300);
							System.out.println("doc Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+k+"]")));
							System.out.println("doc Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+k+"]")).getText());
							System.out.println("doc File Size: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[7]/div)["+k+"]")).getText());
						//	int Novesselsize = Integer.parseInt(driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[7]/div)["+k+"]")).getText().trim().replaceAll("[^0-9]", ""));
						//	if(Novesselsize>0)
						//	{
								
								//eWaitClick(driver.findElement(By.xpath("(//button[@data-automationid='FieldRenderer-name'])["+k+"]")));	
								//System.out.println("Owner Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+k+"]")));
								//System.out.println("Owner Name: "+driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+k+"]")).getText());
								
						//	}
							
						//	else {System.out.println("File size 0");}
							
						}
						Thread.sleep(300);
						eWaitClick(driver.findElement(By.xpath("//*[@id='appRoot']/div[1]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div/div/div/ol/li[2]/div/div/button")));
					}}else 
					{
						
						System.out.println("No data");
					}
				}
				Thread.sleep(300);
				eWaitClick(driver.findElement(By.xpath("(//div[text()='Client Financial Reports'])[1]/..")));
			}
			else 
			{
				
				System.out.println("No vessel");
			}
			counter++;

			if (counter == 5) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				//js.executeScript("window.scrollBy("+i+","+i+50+")"); 
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)["+i+"]")));	              
				counter = 0;
			}
			size=driver.findElements(By.xpath("(//div[@data-automationid='DetailsRowFields']/div[2]/div/div/span/span/button)")).size();
			System.out.println("ssss:  "+size);
		}

	}
	@AfterClass
	public void endTest() {
		softAssert.assertAll();
		//driver.close();
	}
}