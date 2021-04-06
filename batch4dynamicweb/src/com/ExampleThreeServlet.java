package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExampleThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExampleThreeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Enumeration paramNames = request.getParameterNames();
		PrintWriter pw = response.getWriter();
		
		while(paramNames.hasMoreElements()) {
			String name = (String) paramNames.nextElement();
			
			pw.println("Parameter name: "+name+", Parameter value: "+request.getParameter(name)+"<br/>");
		}
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
