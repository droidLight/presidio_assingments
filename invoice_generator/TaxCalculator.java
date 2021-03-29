package invoice_generator;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public abstract class TaxCalculator {
	abstract public TaxReport generateReport();

	final protected TaxReport calculateTax(List<String> productList, List<Double> priceList,
			Map<String, Double> taxTable) {

		List<Double> priceAfterTax = new ArrayList<>();
		List<Double> taxList = new ArrayList<>();
		double totalAmount = 0;
		
		for (int i = 0; i < productList.size(); i++) {
			String product = productList.get(i);
			double price  = priceList.get(i);
			double taxPerCent = taxTable.getOrDefault(product.toLowerCase(), taxTable.get("others"));
			double taxedPrice = (taxPerCent * price) / 100;
			
			totalAmount += (taxedPrice + price);
			priceAfterTax.add(price + taxedPrice);
			taxList.add(taxPerCent);
		}
		
		try {
			return TaxReport.createReport(priceList, productList, priceAfterTax, taxList, totalAmount);
		} catch (Exception e) {
			System.out.println("calculateTax: "+e);
		}
		return null;
	}
}
