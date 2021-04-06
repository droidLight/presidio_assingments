package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ExampleFiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExampleFiveServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession(true);
		Integer count = (Integer)session.getValue("tracker.count");
		
		if(count == null) {
			count = Integer.valueOf(1);
		}else {
			count = Integer.valueOf(count.intValue() + 1);
		}
		session.setAttribute("tracker.count", count);
		
		pw.write("<html>");
		pw.write("<head><title>Session</title></head>");
		pw.write("<body>");
		String countStr = "<p>The number of times/time you visited the page: </p>"+count+"</br>";
		pw.write(countStr);
		
		pw.write("<h4>Session details</h4></br>");
		String names[] = session.getValueNames();
		for(int i = 0; i < names.length; i++) {
			String temp = "<p> Name: "+names[i]+"\t"+"Value: "+session.getAttribute(names[i])+"</p></br>";
			pw.write(temp);
		}
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
