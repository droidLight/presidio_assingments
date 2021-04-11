package com;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daolayer.ItemDTO;

public class ShoppingAction extends Action{

	@Override
	String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Shopping Action");
		
		String shopId = request.getParameter("shopid");
		HttpSession session = request.getSession();
		
		List<String> itemList = (session.getAttribute("items") == null)? new ArrayList() : (List<String>)session.getAttribute("items");
		List<String> itemQuantity = (session.getAttribute("itemQuantity") == null)? new ArrayList() : (List<String>)session.getAttribute("itemQuantity");
		
		Enumeration<String> enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			
			if(!name.equals("formid") && !name.equals("shopid")) {				
				 if(name.contains("quantity_")) {
					 String value = request.getParameter(name);					 
					 if(value != "") {
						 System.out.println("value: "+value);
						 itemQuantity.add(value);
					 }
				 }else {
					 itemList.add(name);
				 }
			}
		}
		
		session.setAttribute("items", itemList);
		session.setAttribute("itemQuantity", itemQuantity);
		return shopId;
	}
	
}


//System.out.println("Shop One");
//HttpSession session = request.getSession();
//
//List<String> itemList = new ArrayList();
//Enumeration<String> enumeration = request.getParameterNames();
//while(enumeration.hasMoreElements()) {
//	String name = enumeration.nextElement();
//	
//	if(!name.equals("formid") && !name.equals("shopid")) {
//		itemList.add(request.getParameter(name));
//	}
//}
//session.setAttribute("items", itemList);
//return "shop2";