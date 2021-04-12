<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Query Invoice</title>
</head>
<body>
	<h2>Query Invoice</h2>
	<form action="./invoiceResult.jsp" method="POST">
		<input type="number" name="invoiceid" placeholder="Enter invoice id" />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>