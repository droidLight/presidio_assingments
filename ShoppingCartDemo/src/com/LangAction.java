package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ResourceBundle;
import java.util.Locale;

public class LangAction extends Action{

	@Override
	String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String language = request.getParameter("language");
		
		ResourceBundle rb = ResourceBundle.getBundle("com.Dictionary", new Locale(language));
		HttpSession session = request.getSession();
		session.setAttribute("rb", rb);
		return "lang.success";
	}

	
}
