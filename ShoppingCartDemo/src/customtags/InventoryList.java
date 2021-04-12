package customtags;

import java.sql.Connection;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import daolayer.DBUtility;
import daolayer.ItemDAOImpl;
import daolayer.ItemDTO;
import servicelayer.InventoryServiceImpl;

public class InventoryList extends TagSupport {

	String shop;

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Connection connection = DBUtility.getConnection("", "", "", "");
			InventoryServiceImpl inventoryServiceImpl = InventoryServiceImpl
					.getInstance(ItemDAOImpl.getInstance(connection));
			List<ItemDTO> items = inventoryServiceImpl.getByCategory(shop);
			
			out.write("<table>");
			for (ItemDTO item : items) {
				String sq = "\"";
				String checkBoxName = ""+item.getItemid();
				String checkBoxValue = item.getItemName();
				String quantityName ="quantity_"+item.getItemid();
				String imagePath = item.getImagePath();
				
				out.write("<tr>");
				out.write("<td>");
				out.write("<img width=\"100\" height=\"100\" src="+sq+imagePath+sq+">");
				out.write("</td>");
				
				out.write("<td>");
				out.write("<h4>"+item.getItemName()+"</h4>");
				out.write("</td>");
				
				out.write("<td>");
				out.write("<input type=\"checkbox\" name="+sq+checkBoxName+sq+" value="+sq+checkBoxValue+sq+"/>");
				out.write("</td>");
				
				out.write("<td>");
				out.write("<input type=\"text\" name="+sq+quantityName+sq+" placeholder=\"Enter the quantity\"/>");
				out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
