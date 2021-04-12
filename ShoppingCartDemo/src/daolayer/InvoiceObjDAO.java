package daolayer;

import models.Invoice;

public interface InvoiceObjDAO {
	public Invoice getInvoiceById(Integer invId) throws Exception;
	public int insertInvoice(Invoice invoice) throws Exception;
}
