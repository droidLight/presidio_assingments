package rmi_services;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadsheetGenerator implements InvoiceGenerator, Cloneable {

	private static SpreadsheetGenerator instance;

	private SpreadsheetGenerator() {
	}

	public static SpreadsheetGenerator createSpreadsheet() {
		if (instance == null) {
			instance = new SpreadsheetGenerator();
		}
		SpreadsheetGenerator obj = instance.createClone();
		return obj;
	}

	private SpreadsheetGenerator createClone() {
		SpreadsheetGenerator obj = null;
		try {
			obj = (SpreadsheetGenerator) super.clone();
		} catch (Exception e) {
		}
		return obj;
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
	public void generate(List<String> productList, List<String> priceList, List<String> quantityList,
			List<String> taxList, List<String> unitList) throws Exception {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		// product column
		this.writeToFile(sheet, 0, 0, "Product");
		for (int i = 1; i <= productList.size(); i++) {
			this.writeToFile(sheet, i, 0, productList.get(i-1));
		}
		sheet.autoSizeColumn(0);

		//data with double data type
		this.writeToFile(sheet, 0, 1, "Quantity");
		this.writeToFile(sheet, 0, 2, "Price Ex.GST");
		this.writeToFile(sheet, 0, 3, "GST");
		this.writeToFile(sheet, 0, 4, "Price Inc.GST");
		List<List<String>> data = new ArrayList<>();
		data.add(quantityList);
		data.add(priceList);
		data.add(taxList);
		
		for(int i = 0; i < data.size(); i++) {
			List<String> col = data.get(i);
			for(int j = 1; j <= col.size(); j++) {
				
				this.writeToFile(sheet, j, i+1, col.get(j-1));
			}
			sheet.autoSizeColumn(i+1);
		}
		
		int row = productList.size()+1;
		this.writeToFile(sheet, row, 0, "Total amount");
		sheet.autoSizeColumn(0);
		
		//total amount
		//for(int i = 0; i < )
		//this.writeToFile(sheet, row, 1, );
		sheet.autoSizeColumn(1);
		
		//FileOutputStream fout = new FileOutputStream(path);
		//workbook.write(fout);
		workbook.close();
		System.out.println("spreadsheet  created");
		
	}

}
