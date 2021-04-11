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
			List<ItemDTO> items = inventoryServiceImpl.getAllItems();
			// session.setAttribute("allItems", items);

			for (ItemDTO item : items) {
				String sq = "\"";
				String checkBoxName = ""+item.getItemid();
				String checkBoxValue = item.getItemName();
				String quantityName ="quantity_"+item.getItemid();
								
				out.write("<h4>"+item.getItemName()+"</h4>");
				out.write("<input type=\"checkbox\" name="+sq+checkBoxName+sq+" value="+sq+checkBoxValue+sq+"/>");
				out.write("<input type=\"text\" name="+sq+quantityName+sq+" placeholder=\"Enter the quantity\"/>");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
