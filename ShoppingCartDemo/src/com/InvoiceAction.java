package com;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daolayer.DBUtility;
import daolayer.InvoiceTransDAOImpl;
import daolayer.ItemDAOImpl;
import daolayer.ItemDTO;
import models.Invoice;
import servicelayer.InventoryServiceImpl;
import servicelayer.InvoiceServiceImpl;
import generators.EmailGenerator;
import generators.Generator;
import generators.SpreadsheetGenerator;
import generators.PdfGenerator;

public class InvoiceAction extends Action {

	Connection connection;

	@Override
	String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int invoiceId = Integer.parseInt(request.getParameter("invoiceid"));
		String toAddress = request.getParameter("email");
		// session.setAttribute("invoiceid", invoiceId);

		List<String> itemIds = (List<String>) session.getAttribute("items");
		List<String> quantities = (List<String>) session.getAttribute("itemQuantity");

		// save invoice into invoicetrans table
		connection = DBUtility.getConnection("", "", "", "");
		InvoiceTransDAOImpl dao = InvoiceTransDAOImpl.getInstance(connection);
		InvoiceServiceImpl invoiceServiceImpl = InvoiceServiceImpl.getInstance(dao);

		// get invoice object
		Invoice invoice = generateInvoice(itemIds, quantities, invoiceId);

		// generating pdf or spreadsheet or email based on user input
		Generator generator = null;
		Enumeration<String> nameEnumeration = request.getParameterNames();
		while (nameEnumeration.hasMoreElements()) {

			String paramName = nameEnumeration.nextElement();
			if (paramName.equals("email") || paramName.equals("pdf") || paramName.equals("xls")) {
				if (paramName.equals("email") && !toAddress.equals("")) {
					generator = EmailGenerator.getInstance(toAddress, "Invoice for your purchase",
							"The invoice for your latest purchase is attached in this email");

				} else if (paramName.equals("pdf")) {
					generator = PdfGenerator.getInstance();
				} else if (paramName.equals("xls")) {
					generator = SpreadsheetGenerator.getInstance();
				}
				generator.setInvoice(invoice);
				generator.execute("C:\\users\\VC\\Documents\\");

			}
		}

		if (invoiceServiceImpl.saveInvoice(invoiceId, itemIds, quantities)) {
			return "invoice.success";

		} else {
			return "invoice.failure";
		}
	}

	Invoice generateInvoice(List<String> ids, List<String> quantities, int invoiceId) {

		try {
			Invoice invoice = Invoice.getInvoice();
			InventoryServiceImpl inventoryService = InventoryServiceImpl
					.getInstance(ItemDAOImpl.getInstance(connection));

			List<String> itemNames = new ArrayList();
			List<Float> itemPrices = new ArrayList();
			List<Integer> itemIds = new ArrayList();
			List<Integer> itemQuant = new ArrayList();

			int i = 0;
			for (String id : ids) {
				ItemDTO item = inventoryService.getItem(Integer.parseInt(id));
				itemNames.add(item.getItemName());
				itemPrices.add(item.getPrice());
				itemIds.add(item.getItemid());
				itemQuant.add(Integer.valueOf(quantities.get(i)));
				i++;
			}
			invoice.setInvoiceId(Integer.toString(invoiceId));
			invoice.setItemIds(itemIds);
			invoice.setNameList(itemNames);
			invoice.setPriceList(itemPrices);
			invoice.setQuantityList(itemQuant);

			return invoice;
		} catch (Exception e) {
			System.out.println("generateInvoice: " + e);
			return null;
		}
	}

}