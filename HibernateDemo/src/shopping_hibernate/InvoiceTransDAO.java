package shopping_hibernate;

import java.util.List;

public interface InvoiceTransDAO {
	public InvoiceTransDTO getInvoice(Integer invoiceId, Integer itemId) throws Exception;
	public List<InvoiceTransDTO> getAllInvoiceTrans() throws Exception;
	public List<ItemDTO> getItemsInInvoice(Integer invoiceId) throws Exception;
	public int insertInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception;
	public int updateIvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception;
	public int deleteInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception;
	public int deleteInvoiceTrans(Integer invoiceId) throws Exception;
}
