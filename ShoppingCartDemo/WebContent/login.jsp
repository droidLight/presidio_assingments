<!DOCTYPE html>
<%@page buffer="8kb" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/customtags.tld" prefix="custom" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
	</head>
	<body>
		<center>
			<h3>Login</h3><br/>
			<form action="./actionservlet" method="POST">
				 <input type="hidden" name="formid" value="login"/>
				
				<custom:languagetag text="username"/><input type="text" name="name" placeholder="Enter your name"/><br/><br/>
				<custom:languagetag text="password"/><input type="text" name="password" placeholder="Enter your Password"/><br/><br/>				
				<input type="submit" value="Login"/>
			</form>
		</center>
	</body>
</html>