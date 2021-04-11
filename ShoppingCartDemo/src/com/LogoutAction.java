package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daolayer.DBUtility;
import daolayer.UserDAOImpl;
import servicelayer.LoginServiceImpl;

public class LogoutAction extends Action implements Cloneable {

	@Override
	String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// reading properties from config file
		Properties dbConfig = (Properties) request.getServletContext().getAttribute("dbConfigProp");
		String url = dbConfig.getProperty("url");
		String user = dbConfig.getProperty("user");
		String dbPassword = dbConfig.getProperty("password");
		String driver = dbConfig.getProperty("driver");
		
		// passing connection to UserDAOImpl
		Connection connection = DBUtility.getConnection(driver, url, user, dbPassword);
		LoginServiceImpl loginService = LoginServiceImpl.getLoginService(UserDAOImpl.getInstance(connection));

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String password = (String) session.getAttribute("password");

		if(loginService.setFlag(name, password, 0) == 1) {
			return "logout.homepage";			
		}else {
			return "login.homepage";
		}
	}

}
