package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExampleOneServlet
 */
public class ExampleOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExampleOneServlet() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		pw.write("<html>");
		pw.write("<head><title>Example</title></head>");
		pw.write("<body>");
		pw.write("Welcome, "+"<b>"+name+"</b>");
		pw.write("</body>");
		pw.write("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
