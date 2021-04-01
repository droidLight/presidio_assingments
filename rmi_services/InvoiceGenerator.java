package rmi_services;

import java.util.List;

public interface InvoiceGenerator {
	
	public void generate(List<String> productList, List<String> priceList, List<String> quantityList, List<String> taxList, List<String> unitList) throws Exception;
}
