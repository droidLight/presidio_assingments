package com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExampleFourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection;
	PreparedStatement st;
    public ExampleFourServlet() {
        super();
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	this.connection = DriverManager.getConnection("jdbc:mysql://localhost/coda4", "root", "root");
        	this.connection.setAutoCommit(false);
        	this.st = this.connection.prepareStatement("insert into users values (?, ?, ?, ?)");
        }catch(Exception e) {
        	System.out.println("Exception: "+e);
        }
        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int uid = Integer.parseInt(request.getParameter("uid"));
		String password = request.getParameter("password");
		int flag = Integer.parseInt(request.getParameter("flag"));
		System.out.println(uid+"\t"+name+"\t"+password+"\t"+flag);
		
		PrintWriter pw = response.getWriter();
		try {
			this.st.setInt(1, uid);
			this.st.setString(2, name);
			this.st.setString(3, password);
			this.st.setInt(4, flag);
			
			int row = this.st.executeUpdate();
			pw.write("<p>"+row+" rows affected"+"</p>");
			pw.close();
			this.connection.commit();
		}catch(Exception e) {
			System.out.println("Exception in doPost: "+e);
		}
				
	}

}
