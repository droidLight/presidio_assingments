<!DOCTYPE html>
<%@taglib uri="/WEB-INF/customtags.tld" prefix="custom" %>
<%@page import="daolayer.ItemDTO"%>
<%@page import="java.util.List"%>
<%@page import="daolayer.DBUtility"%>
<%@page import="daolayer.ItemDAOImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="servicelayer.InventoryServiceImpl"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop 3</title>
</head>
<body>
	<h1>Groceries shop</h1>
	<form action="./actionservlet" method="post">
		<input type="hidden" name="formid" value="shop"> <input
			type="hidden" name="shopid" value="shop3">
			
			<custom:inventorylist shop="shop3"/><br/><br/>
		<input type="submit" value="Next shop..">
	</form>
</body>
</html>