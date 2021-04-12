package customtags;

import java.sql.Connection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import daolayer.DBUtility;
import daolayer.InvoiceObjDAOImpl;
import servicelayer.InvoiceObjService;
import servicelayer.InvoiceObjServiceImpl;
import models.Invoice;

public class InvoiceReport extends TagSupport{
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String invoiceId = pageContext.getRequest().getParameter("invoiceid");
		
		try {
			Connection connection = DBUtility.getConnection("", "", "", "");
			InvoiceObjService invoiceObjService = InvoiceObjServiceImpl.getInstance(InvoiceObjDAOImpl.getInstance(connection));
			
			Invoice invoice = invoiceObjService.getInvoice(Integer.parseInt(invoiceId));
			
			double totalAmount=0;
			out.write("<table>");
			out.write("<tr>");
			out.write("<td> Item Id</td>");
			out.write("<td> Item Name</td>");
			out.write("<td> Price</td>");
			out.write("<td> Quantity</td>");
			out.write("<td>Total</td>");
			out.write("</tr>");
			for(int i = 0; i  < invoice.getItemIds().size(); i++) {
				Integer id = invoice.getItemIds().get(i);
				String name = invoice.getNameList().get(i);
				Float price = invoice.getPriceList().get(i);
				Integer quant = invoice.getQuantityList().get(i);
				
				double total = price * quant;
				
				out.write("<tr>");
				out.write("<td>"+id+"</td>");
				out.write("<td>"+name+"</td>");
				out.write("<td>"+price+"</td>");
				out.write("<td>"+quant+"</td>");
				out.write("<td>"+total+"</td>");
				out.write("</tr>");
				
				totalAmount += total;
			}
			out.write("</table>");
			out.write("<h4>Total amount: </h4><p>"+totalAmount+"</p>");
		}catch(Exception e) {
			System.out.println("InvoiceReport: "+e);
		}
		return super.doEndTag();
	}
	
	
}
