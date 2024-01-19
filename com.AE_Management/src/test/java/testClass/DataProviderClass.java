package testClass;

import java.io.IOException;
import java.util.stream.IntStream;

import org.testng.annotations.DataProvider;

import base.Base;
import utilities.ReadExcelFile;

public class DataProviderClass extends Base {

	
	// DataProvider
		@DataProvider(name = "Vesseldata")
		public Object[][] testDataExample1() throws IOException {
			ReadExcelFile configuration = new ReadExcelFile(
					"D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\src\\main\\resources\\Data\\Regrassion.xlsx");
			int rows = configuration.getRowCount(0);
			int cells = configuration.getcellCount(0, rows);
			System.out.println(rows + "rows");
			System.out.println(cells + "cells");
			String[][] signin_credentials = new String[rows][cells];
			IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
					.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
			return signin_credentials;
		}
		
		// DataProvider
				@DataProvider(name = "voyageSnapshot")
				public Object[][] testDataExample2() throws IOException {
					ReadExcelFile configuration = new ReadExcelFile(
							"D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\src\\main\\resources\\Data\\Regrassion.xlsx");
					int rows = configuration.getRowCount(0);
					int cells = configuration.getcellCount(0, rows);
					System.out.println(rows + "rows");
					System.out.println(cells + "cells");
					String[][] signin_credentials = new String[rows][cells];
					IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
							.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
					return signin_credentials;
				}
				
				// DataProvider
				@DataProvider(name = "crewInfo")
				public Object[][] testDataExample3() throws IOException {
					ReadExcelFile configuration = new ReadExcelFile(
							"D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\src\\main\\resources\\Data\\Regrassion.xlsx");
					int rows = configuration.getRowCount(0);
					int cells = configuration.getcellCount(0, rows);
					System.out.println(rows + "rows");
					System.out.println(cells + "cells");
					String[][] signin_credentials = new String[rows][cells];
					IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
							.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
					return signin_credentials;
				}
				
				
				// DataProvider
				@DataProvider(name = "financialData")
				public Object[][] testDataExample4() throws IOException {
					ReadExcelFile configuration = new ReadExcelFile(
							"D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\src\\main\\resources\\Data\\Regrassion.xlsx");
					int rows = configuration.getRowCount(0);
					int cells = configuration.getcellCount(0, rows);
					System.out.println(rows + "rows");
					System.out.println(cells + "cells");
					String[][] signin_credentials = new String[rows][cells];
					IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
							.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
					return signin_credentials;
				}
				
				
				// DataProvider
				@DataProvider(name = "vesselParticulars")
				public Object[][] testDataExample5() throws IOException {
					ReadExcelFile configuration = new ReadExcelFile(
							"D:\\WorkInno\\Poonam\\TestingCodeRepositry\\Automation-coding-Task\\com.AE_Management\\src\\main\\resources\\Data\\Regrassion.xlsx");
					int rows = configuration.getRowCount(0);
					int cells = configuration.getcellCount(0, rows);
					System.out.println(rows + "rows");
					System.out.println(cells + "cells");
					String[][] signin_credentials = new String[rows][cells];
					IntStream.range(0, rows).forEach(i -> IntStream.range(0, cells)
							.forEach(j -> signin_credentials[i][j] = configuration.getData(0, i + 1, j)));
					return signin_credentials;
				}
				
				
				
}
