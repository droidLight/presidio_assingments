package day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWriteDemo {

	
	private static void readFile(File file) throws Exception{
		
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		
		int numOfSheets = workbook.getNumberOfSheets();
		System.out.println("Number of sheets: " + numOfSheets);
		Sheet sheet = workbook.getSheetAt(0);

		for(Row row : sheet) {
			for(Cell cell : row) {
				System.out.print(cell.getStringCellValue()+"\t");
			}
			System.out.println("");
		}
		
		workbook.close();
	} 
	
	private static void writeToFile(Sheet sheet, int rowNum, int colNum, String content) {
		Row row = (sheet.getRow(rowNum) == null)?sheet.createRow(rowNum):sheet.getRow(rowNum);		
		Cell cell = row.createCell(colNum);
		cell.setCellValue(content);
	}
	
	public static void main(String[] args) throws Exception {
		
		//read from excel file
		File file = new File("./test.xlsx");
		readFile(file);
		
		
		// write to excel file
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		writeToFile(sheet, 0, 0,"row_1_cell_1");
		writeToFile(sheet, 0, 1,"row_1_cell_2");
		writeToFile(sheet, 0, 2,"row_1_cell_3");
		
		writeToFile(sheet, 1, 0,"row_2_cell_1");
		writeToFile(sheet, 1, 1,"row_2_cell_2");
		writeToFile(sheet, 1, 2,"row_2_cell_3");

		FileOutputStream fout = new FileOutputStream("./new_test.xlsx");
		workbook.write(fout);
		workbook.close();
		System.out.println("file written");
				
	}
}
