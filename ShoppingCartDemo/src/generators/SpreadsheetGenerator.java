package generators;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.Invoice;


public class SpreadsheetGenerator implements Generator, Cloneable{

	private static SpreadsheetGenerator instance;
	Invoice invoice;
	
	private SpreadsheetGenerator() {}
	
	private SpreadsheetGenerator getClone() {
		SpreadsheetGenerator obj = null;
		try {
			obj = (SpreadsheetGenerator) super.clone();
		}catch(Exception e) {
			System.out.println("SpreadsheetGenerator: "+e);
		}
		return  obj;
	}
	
	private SpreadsheetGenerator clear() {
		this.invoice = null;
		return this;
	}
	
	public static SpreadsheetGenerator getInstance() {
		if(instance == null)
			instance = new SpreadsheetGenerator();
		return instance.getClone().clear();
	}
	
	private void writeToFile(Sheet sheet, int rowNum, int colNum, String content) {
		Row row = (sheet.getRow(rowNum) == null) ? sheet.createRow(rowNum) : sheet.getRow(rowNum);
		Cell cell = row.createCell(colNum);
		cell.setCellValue(content);
	}

	private void writeToFile(Sheet sheet, int rowNum, int colNum, double content) {
		Row row = (sheet.getRow(rowNum) == null) ? sheet.createRow(rowNum) : sheet.getRow(rowNum);
		Cell cell = row.createCell(colNum);
		cell.setCellValue(content);
	}
		
	@Override
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String execute(String path) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		// product column
		this.writeToFile(sheet, 0, 0, "Product");
		for (int i = 1; i <= invoice.getNameList().size(); i++) {
			this.writeToFile(sheet, i, 0, invoice.getNameList().get(i-1));
		}
		sheet.autoSizeColumn(0);

		//data with double data type
		this.writeToFile(sheet, 0, 1, "Quantity");
		for(int i = 1; i <= invoice.getQuantityList().size(); i++) {
			this.writeToFile(sheet, i, 1, invoice.getQuantityList().get(i-1));
		}
		
		this.writeToFile(sheet, 0, 2, "Price");
		for(int i = 1; i <= invoice.getPriceList().size(); i++) {
			this.writeToFile(sheet, i, 2, invoice.getPriceList().get(i-1));
		}
		
		path = path+"invoice.xls";
		FileOutputStream fout = new FileOutputStream(path);
		workbook.write(fout);
		workbook.close();
		System.out.println("spreadsheet  created");
		return path;

	}

	
}
