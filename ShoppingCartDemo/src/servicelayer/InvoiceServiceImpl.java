package servicelayer;

import java.util.List;
import daolayer.InvoiceTransDAO;
import daolayer.InvoiceTransDTO;

public class InvoiceServiceImpl implements InvoiceService, Cloneable{

	private static InvoiceServiceImpl instance;
	private InvoiceTransDAO invoiceDAO;
	
	private InvoiceServiceImpl() {}
	
	private InvoiceServiceImpl getClone() {
		InvoiceServiceImpl obj = null;
		try {
			obj = (InvoiceServiceImpl) super.clone();
		}catch(Exception e) {
			System.out.println("InvoiceServiceImpl: "+e);
		}
		return obj;
	}
	
	private InvoiceServiceImpl setInvoiceDAO(InvoiceTransDAO dao) {
		this.invoiceDAO = dao;
		return this;
	}
	
	synchronized public static InvoiceServiceImpl getInstance(InvoiceTransDAO dao) {
		if(instance == null)
			instance = new InvoiceServiceImpl();
		
		return instance.getClone().setInvoiceDAO(dao);		
	}
	
	@Override
	public boolean saveInvoice(int invoiceId, List<String> itemId, List<String> itemQuantities) throws Exception {
		int count = 0;
		for(int i = 0; i < itemId.size(); i++) {
			InvoiceTransDTO temp = InvoiceTransDTO.getInvoiceTransDTO();
			temp.setInvoiceId(invoiceId);
			temp.setItemId(Integer.parseInt(itemId.get(i)));
			temp.setQty(Integer.parseInt(itemQuantities.get(i)));
			count += this.invoiceDAO.insertInvoiceTrans(temp);
		}	
		return count == itemId.size();
	}

}
