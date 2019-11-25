package date;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.MyArchetype.utility.ConstantPaths;

@Test
public class ExcelWriter {
	public void writeData(String columnName, String sheetName, int columNumber) throws IOException {
		File source = new File(ConstantPaths.dateExcelPath);
		FileInputStream input = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet(sheetName);
		sheet.getRow(0).createCell(columNumber).setCellValue(columnName);
		FileOutputStream output = new FileOutputStream(source);
		wb.write(output);
		wb.close();

	}
}
