package invoice_generator;

import java.util.List;
import java.util.ArrayList;

public class TaxReport implements Cloneable {
	private List<Double> priceList;
	private List<String> productList;
	private List<Double> priceListAfterTax;
	private List<Double> taxList;
	private double totalAmount;

	private static TaxReport instance;

	private TaxReport() {
	}

	public static TaxReport createReport(List<Double> priceList, List<String> productList, List<Double> priceAfterTax,
			List<Double> taxList, double totalAmount) throws Exception {
		if (instance == null) {
			instance = new TaxReport();
		}

		return instance.createClone().setPriceList(priceList).setPriceListAfterTax(priceAfterTax)
				.setProductList(productList).setTaxList(taxList).setTotalAmount(totalAmount);
	}

	private TaxReport createClone() throws Exception {
		return (TaxReport) super.clone();
	}

	public List<Double> getPriceList() {
		return priceList;
	}

	public TaxReport setPriceList(List<Double> priceList) {
		this.priceList = priceList;
		return this;
	}

	public List<String> getProductList() {
		return productList;
	}

	public TaxReport setProductList(List<String> productList) {
		this.productList = productList;
		return this;
	}

	public List<Double> getPriceListAfterTax() {
		return priceListAfterTax;
	}

	public TaxReport setPriceListAfterTax(List<Double> priceListAfterTax) {
		this.priceListAfterTax = priceListAfterTax;
		return this;
	}

	public List<Double> getTaxList() {
		return taxList;
	}

	public TaxReport setTaxList(List<Double> taxList) {
		this.taxList = taxList;
		return this;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public TaxReport setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

}
