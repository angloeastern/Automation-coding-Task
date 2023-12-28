package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelFile{
	static XSSFWorkbook work_book;
	static XSSFSheet sheet;
	static XSSFCell cell;
	File file;	
	public ReadExcelFile(String excelfilePath) {
		try {
			file = new File(excelfilePath);
			FileInputStream stream = new FileInputStream(file);
			work_book = new XSSFWorkbook(stream);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getData(int sheetnumber, int row, int column){
		sheet = work_book.getSheetAt(sheetnumber);
		DataFormatter fomatter=new DataFormatter();
		cell = sheet.getRow(row).getCell(column);
		String data=fomatter.formatCellValue(cell);
		System.out.println(data+"data");

		return data;
	} 
	public int getRowCount(int sheetIndex){
		int row = work_book.getSheetAt(sheetIndex).getLastRowNum();
		return row;
	}
	public int getcellCount(int sheetIndex,int row){
		int cell = work_book.getSheetAt(sheetIndex).getRow(row).getLastCellNum();
		return cell;
	}
	public static void setData(int sheetnumber, int row, int column, String value, short red) throws IOException {
		CellStyle style = work_book.createCellStyle();
		Font font = work_book.createFont();
		font.setColor(red);
		// font.setColor(IndexedColors.GREEN.getIndex());
		style.setFont(font);

		sheet = work_book.getSheetAt(sheetnumber);
		cell = sheet.getRow(row).createCell(column);
		cell.setCellValue(value);
		cell.setCellStyle(style);
		//To write into Excel File
		FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/Data/Login.xlsx");
		//FileOutputStream outputStream = new FileOutputStream("D:\\WorkInno\\Poonam\\New folder\\QaExceptionReport.xls");
		work_book.write(outputStream);
		outputStream.close();
	}
}