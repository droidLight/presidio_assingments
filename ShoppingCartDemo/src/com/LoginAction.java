package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daolayer.UserDAOImpl;
import daolayer.DBUtility;

import servicelayer.LoginServiceImpl;

public class LoginAction extends Action {
	
	public LoginAction() {}
	
	@Override
	String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{

		//reading properties from config file
//		Properties dbConfig = (Properties) request.getServletContext().getAttribute("dbConfigProp");
//		String url = dbConfig.getProperty("url");
//		String user = dbConfig.getProperty("user");
//		String dbPassword = dbConfig.getProperty("password");
//		String driver = dbConfig.getProperty("driver");
		
		//user details
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//passing connection to UserDAOImpl
		Connection connection = DBUtility.getConnection("", "", "", "");	
		LoginServiceImpl loginService=LoginServiceImpl.getLoginService(UserDAOImpl.getInstance(connection));

		
		if(loginService.userExists(name, password)) {
			System.out.println("User exists");
			if(loginService.checkFlag(name, password)) {
				System.out.println("User flag check true");
				
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("password", password);
				
				return "login.homepage";
			}else {
				System.out.println("User flag check false");
				return "login.already";
			}
						
		}else {
			System.out.println("User does not exist");
			return "login.register";
		}
	}
	
}
