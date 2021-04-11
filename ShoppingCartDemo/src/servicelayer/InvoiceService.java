package servicelayer;

import java.util.List;

public interface InvoiceService {
	
	boolean saveInvoice(int invoiceId, List<String> itemId, List<String> itemQuantities) throws Exception;
}
