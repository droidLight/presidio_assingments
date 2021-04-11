package com;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ActionServlet() throws Exception{
        super();        
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	try {
    		Properties configProp = new Properties();
            configProp.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
            
            config.getServletContext().setAttribute("configProp", configProp);
    	}catch(Exception e) {
    		System.out.println(e);
    	}    	
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestProcessor requestProcessor = RequestProcessor.getInstance();
		requestProcessor.processRequest(request, response);
	}

}
