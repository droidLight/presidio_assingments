package com;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        System.out.println("constructor called");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    	super.init();
    	System.out.println("init function called");
    	System.out.println("Servlet name: "+servletConfig.getServletName());
    	Enumeration<String> paramNames = servletConfig.getInitParameterNames();
    	while(paramNames.hasMoreElements()) {
    		String name = paramNames.nextElement();
    		System.out.println("Name: "+name+"\t value: "+servletConfig.getInitParameter(name));
    	}
    	
    	ServletContext application = servletConfig.getServletContext();
    	application.setAttribute("global", "value written by HelloServlet");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("Do get method called");
		System.out.println("Test: "+request.getParameter("test"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do post method called");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy method called");
	}
}
