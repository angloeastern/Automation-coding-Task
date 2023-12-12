package ActionClass;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.Base;
import testClass.AELogin;
import testClass.VesselSearchOLD;
import utilities.ReadExcelFile;

public class VesselAction extends Base {
	
	ExtentReports extent;
	ExtentTest test;
	public static SoftAssert softAssert = new SoftAssert();
	@BeforeClass
	public void ProgramStarted() throws InterruptedException, IOException {
		AELogin.Login();
	} 	
	
	
@Test(dataProvider="Vesseldata")
public void selectVessel(String VesselName,String test,String test1) throws InterruptedException 
	{
	VesselSearchOLD.vesselSearch(VesselName,test,test1);
	VesselSearchOLD.voyageSnapshot();
	VesselSearchOLD.crewInfo();
	VesselSearchOLD.Financial();
	VesselSearchOLD.Particulars();
	}
	
@DataProvider(name="Vesseldata")
public Object[][] testDataExample(){
ReadExcelFile configuration = new ReadExcelFile(System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\Login.xlsx");
int rows = configuration.getRowCount(0);
int cells=configuration.getcellCount(0,rows);
System.out.println(rows+"rows");
System.out.println(cells+"cells");
Object[][]signin_credentials = new Object[rows][cells];

for(int i=0;i<rows;i++)
{
	for (int j=0;j<cells;j++)
	{
signin_credentials[i][j] = configuration.getData(0, i, j);
}
}
return signin_credentials;
}

@AfterClass
public void endTest()
{
	softAssert.assertAll();
	//driver.close();
}
}