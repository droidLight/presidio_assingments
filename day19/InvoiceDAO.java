package day19;

import java.util.List;

public interface InvoiceDAO {
	
	public InvoiceDTO getInvoice(Integer invoiceId) throws Exception;
	public List<InvoiceDTO> getAllInvoice() throws Exception;
	public List<InvoiceDTO> getCustomerInvoice(Integer customerId) throws Exception;
	public int insertInvoice(InvoiceDTO invoice) throws Exception;
	public int updateInvoice(InvoiceDTO invoice) throws Exception;
	public int deleteInvoice(InvoiceDTO invoice) throws Exception;
	public int deleteInvoiceById(Integer invoiceId) throws Exception;
}
