package com;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import daolayer.DBUtility;
import daolayer.UserDAOImpl;
import servicelayer.LoginServiceImpl;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		try {
		System.out.println("Session destroyed");
		HttpSession session = se.getSession();
		
		String username = (String)session.getAttribute("name");
		String password = (String) session.getAttribute("password");
				
		Connection connection = DBUtility.getConnection("", "", "", "");	
		LoginServiceImpl loginService=LoginServiceImpl.getLoginService(UserDAOImpl.getInstance(connection));
		loginService.setFlag(username, password, 0);
		System.out.println("Flag set to 0");
		}catch(Exception e) {
			System.out.println("sessionDestroyed: "+e);
		}
		
	}
	
	
}
