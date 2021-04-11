package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daolayer.DBUtility;
import daolayer.UserDAOImpl;
import daolayer.UserDAO;
import servicelayer.LoginServiceImpl;

public class RegisterAction extends Action{

	@Override
	String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO dao = UserDAOImpl.getInstance(DBUtility.getConnection("", "", "", ""));
		LoginServiceImpl loginServiceImpl = LoginServiceImpl.getLoginService(dao);
		
		if(loginServiceImpl.registerUser(Integer.valueOf(userId), userName, password, 0) == 1) {
			return "register.success";
		}else {
			return "register.faliure";
		}
	}	
}
