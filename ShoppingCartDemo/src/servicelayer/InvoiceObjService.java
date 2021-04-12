package servicelayer;

import models.Invoice;

public interface InvoiceObjService {
	public Invoice getInvoice(Integer invoiceId) throws Exception;
	public boolean saveInvoice(Invoice invoice) throws Exception;
}
