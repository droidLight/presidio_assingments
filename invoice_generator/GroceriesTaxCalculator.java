package invoice_generator;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class GroceriesTaxCalculator extends TaxCalculator implements Cloneable {

	private Map<String, Double> gstTable;
	private List<String> productList;
	private List<Double> priceList;
	private static GroceriesTaxCalculator instance;

	private GroceriesTaxCalculator() {
		this.gstTable = new HashMap<>();
		
		this.gstTable.put("tea", 5.0);
		this.gstTable.put("cofee", 5.0);
		this.gstTable.put("edible_oil", 5.0);
		this.gstTable.put("sugar", 5.0);
		this.gstTable.put("sweets", 5.0);
		this.gstTable.put("medicine", 5.0);
		this.gstTable.put("cereals", 0.0);
		this.gstTable.put("wheat", 0.0);
		this.gstTable.put("oats", 0.0);
		this.gstTable.put("others", 6.0);
	}

	public static GroceriesTaxCalculator getCalculator(List<String> productList, List<Double> priceList) {

		if (instance == null) {
			instance = new GroceriesTaxCalculator();
		}

		GroceriesTaxCalculator obj = instance.createClone();
		obj.setPriceList(priceList);
		obj.setProductList(productList);

		return obj;
	}

	private GroceriesTaxCalculator createClone() {
		GroceriesTaxCalculator obj = null;
		try {
			obj = (GroceriesTaxCalculator) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	@Override
	public TaxReport generateReport() {
		return super.calculateTax(this.productList, this.priceList, this.gstTable);
	}

	//getters and setters
	public List<String> getProductList() {
		return productList;
	}

	public void setProductList(List<String> productList) {
		this.productList = productList;
	}

	public List<Double> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Double> priceList) {
		this.priceList = priceList;
	}

}
