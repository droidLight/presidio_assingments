package invoice_generator;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadsheetGenerator implements InvoiceGenerator, Cloneable {

	private TaxReport taxReport;
	private static SpreadsheetGenerator instance;

	private SpreadsheetGenerator() {
	}

	public static SpreadsheetGenerator createSpreadsheet(TaxReport taxReport) {
		if (instance == null) {
			instance = new SpreadsheetGenerator();
		}
		SpreadsheetGenerator obj = instance.createClone();
		obj.taxReport = taxReport;
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

	@Override
	public void generate(String path) throws Exception{
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		// product column
		this.writeToFile(sheet, 0, 0, "Product");
		List<String> productList = this.taxReport.getProductList();
		for (int i = 1; i <= productList.size(); i++) {
			this.writeToFile(sheet, i, 0, productList.get(i-1));
		}
		sheet.autoSizeColumn(0);

		//data with double data type
		this.writeToFile(sheet, 0, 1, "Price");
		this.writeToFile(sheet, 0, 2, "Tax%");
		this.writeToFile(sheet, 0, 3, "Final Price");
		List<List<Double>> data = new ArrayList<>();
		data.add(this.taxReport.getPriceList());
		data.add(this.taxReport.getTaxList());
		data.add(this.taxReport.getPriceListAfterTax());
		
		for(int i = 0; i < data.size(); i++) {
			List<Double> col = data.get(i);
			for(int j = 1; j <= col.size(); j++) {
				
				this.writeToFile(sheet, j, i+1, col.get(j-1));
			}
			sheet.autoSizeColumn(i+1);
		}
		
		//total amount
		int row = productList.size()+1;
		this.writeToFile(sheet, row, 0, "Total amount");
		sheet.autoSizeColumn(0);
		this.writeToFile(sheet, row, 1, this.taxReport.getTotalAmount());
		sheet.autoSizeColumn(1);
		
		FileOutputStream fout = new FileOutputStream(path);
		workbook.write(fout);
		workbook.close();
		System.out.println("spreadsheet  created");
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

}
