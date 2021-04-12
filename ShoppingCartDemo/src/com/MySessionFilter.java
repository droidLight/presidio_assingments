package com;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MySessionFilter implements Filter {

	public void destroy() {
		System.out.println("Filter destroyed");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse) response;
		HttpSession session = hRequest.getSession();
		
		if(session.isNew()) {
			System.out.println("New session");
			String formId = hRequest.getParameter("formid");
			if(formId.equals("lang")){
				chain.doFilter(hRequest, hResponse);
			}else {
				hResponse.sendRedirect("expired.jsp");
			}
		}else {
			System.out.println("old session");
			chain.doFilter(request, response);
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter created");
	}

}
