package com;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor implements Cloneable {

	private static RequestProcessor instance;

	private RequestProcessor() {
	}

	private RequestProcessor createClone() {
		RequestProcessor obj = null;
		try {
			obj = (RequestProcessor) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	public static RequestProcessor getInstance() {
		if (instance == null)
			instance = new RequestProcessor();
		return instance.createClone();
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			String formId = request.getParameter("formid");

			Properties config = (Properties) request.getServletContext().getAttribute("configProp");
			String className = config.getProperty(formId);

			Action action = (Action) Class.forName(className).getConstructor().newInstance();
			
			String result = action.execute(request, response);
			response.sendRedirect(config.getProperty(result));
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
