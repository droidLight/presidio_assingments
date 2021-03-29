package invoice_generator;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserInterface {

	public static void main(String[] args) throws Exception{

		Scanner s = new Scanner(System.in);
		System.out.println(
				"Enter product name and price, separated with space. \nUse '_' instead of 'space' in product name");
		System.out.println("Enter # to generate invoice.");

		List<Double> priceList = new ArrayList<>();
		List<String> productList = new ArrayList<>();
		String input;
		
		while (true) {
			input = s.nextLine();
			if (input.equals("#")) {
				break;
			}
			String[] strArr = input.split(" ");
			Double price = Double.valueOf(strArr[1]);
			String product = strArr[0];

			priceList.add(price);
			productList.add(product);

		}

		TaxReport report = GroceriesTaxCalculator.getCalculator(productList, priceList).generateReport();

		List<String> productListTwo = report.getProductList();
		List<Double> priceListTwo = report.getPriceList();
		List<Double> priceAfterTax = report.getPriceListAfterTax();
		List<Double> taxList = report.getTaxList();
		
		System.out.println("Total Amount: " + report.getTotalAmount());
		for (int i = 0; i < report.getPriceList().size(); i++) {
			System.out.println(productListTwo.get(i) + "\t" + priceListTwo.get(i) + "\t" + priceAfterTax.get(i)+"\t"+taxList.get(i));
		}
		
		SpreadsheetGenerator spreadSheetGen = SpreadsheetGenerator.createSpreadsheet(report);
		spreadSheetGen.generate("./invoice_doc.xlsx");
		
		PDFGenerator pdfGen = PDFGenerator.getInstance(report);
		pdfGen.generate("./invoice_doc.pdf");
	}
}
