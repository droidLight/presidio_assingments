package shopping_hibernate;

import java.sql.Connection;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Test {
	public static void main(String[] args) {

		InvoiceDTO invoice = InvoiceDTO.getInvoiceDTO();
		invoice.setInvoiceId(123);
		invoice.setCustomerId(456);
		invoice.setInvoiceDate(new Date(2020, 4, 12));

		InvoiceTransDTO invoiceTrans = InvoiceTransDTO.getInvoiceTransDTO();
		invoiceTrans.setItemId(35);
		invoiceTrans.setQty(200);
		invoiceTrans.setInvoice(invoice);

		InvoiceTransDTO invoiceTrans2 = InvoiceTransDTO.getInvoiceTransDTO();
		invoiceTrans2.setItemId(40);
		invoiceTrans2.setQty(30);
		invoiceTrans2.setInvoice(invoice);

		InvoiceTransDTO invoiceTrans3 = InvoiceTransDTO.getInvoiceTransDTO();
		invoiceTrans3.setItemId(45);
		invoiceTrans3.setQty(450);
		invoiceTrans3.setInvoice(invoice);

		List<InvoiceTransDTO> list = new ArrayList<InvoiceTransDTO>();
		list.add(invoiceTrans);
		list.add(invoiceTrans2);
		list.add(invoiceTrans3);
		invoice.setInvoiceTransactions(list);

		InvoiceDAO dao = InvoiceDAOImpl.getInstance();
		try {
			System.out.println("created: " + dao.insertInvoice(invoice));

			InvoiceDTO result = dao.getInvoice(1);
			System.out.println("invoice id: " + result.getInvoiceId());
			System.out.println("customer id: " + result.getCustomerId());
			System.out.println("invoice date: " + result.getInvoiceDate());
			for (InvoiceTransDTO trans : result.getInvoiceTransactions()) {
				System.out
						.println(trans.getInvoice().getInvoiceId() + "\t" + trans.getItemId() + "\t" + trans.getQty());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		InvoiceTransDAO transDAO = InvoiceTransDAOImpl.getInstance();

		try {
			List<InvoiceTransDTO> resList = transDAO.getTransactionInInvoice(1);
			for (InvoiceTransDTO res : resList) {
				System.out.println("transaction id: " + res.getTransactionId() + "\titem id: " + res.getItemId()
						+ "\tqty: " + res.getQty() + "\tinv id: " + res.getInvoice().getInvoiceId());
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("end");
	}
}
