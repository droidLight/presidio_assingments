package servicelayer;

import daolayer.InvoiceObjDAO;
import daolayer.ItemDAO;
import models.Invoice;

public class InvoiceObjServiceImpl implements InvoiceObjService, Cloneable {

	InvoiceObjDAO invoiceDAO;
	private static InvoiceObjServiceImpl instance;

	private InvoiceObjServiceImpl() {
	}

	private InvoiceObjServiceImpl getClone() {
		InvoiceObjServiceImpl obj = null;
		try {
			obj = (InvoiceObjServiceImpl) super.clone();
		} catch (Exception e) {
			System.out.println("InvoiceObjServiceImpl: " + e);
		}
		return obj;
	}

	synchronized public static InvoiceObjServiceImpl getInstance(InvoiceObjDAO invoiceDAO) {
		if (instance == null)
			instance = new InvoiceObjServiceImpl();
		return instance.getClone().setDAO(invoiceDAO);
	}

	private InvoiceObjServiceImpl setDAO(InvoiceObjDAO invoiceDAO) {
		this.invoiceDAO = invoiceDAO;
		return this;
	}

	@Override
	public Invoice getInvoice(Integer invoiceId) throws Exception {
		Invoice invoice = invoiceDAO.getInvoiceById(invoiceId);
		return invoice;
	}

	@Override
	public boolean saveInvoice(Invoice invoice) throws Exception {
		int rows = invoiceDAO.insertInvoice(invoice);
		return rows == 1;
	}

}
