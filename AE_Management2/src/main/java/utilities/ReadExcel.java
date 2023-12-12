package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel{
static XSSFWorkbook work_book;
static XSSFSheet sheet;
static XSSFCell cell;
File file;
public ReadExcel(String excelfilePath) {
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
public static void setData(int sheetnumber, int row, int column,String value) throws IOException
{
sheet = work_book.getSheetAt(sheetnumber);
cell = sheet.getRow(row).createCell(column);
cell.setCellValue(value);
//To write into Excel File
FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/Data/voyageInfo.xlsx");
work_book.write(outputStream);
outputStream.close();

}
}