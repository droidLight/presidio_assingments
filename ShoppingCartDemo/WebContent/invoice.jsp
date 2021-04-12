<!DOCTYPE HTML>
<%@page import="daolayer.ItemDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<title>Invoice</title>
<meta charset="utf-8" />
</head>

<body>
	<center>
		<h2>Invoice</h2>
		<form action="./actionservlet" method="POST">
			<input type="hidden" name="formid" value="invoiceform"/> 
			<input type="text" name="invoiceid" placeholder="Enter your invoice ID"/><br/>
			<input type="text" name="email" placeholder="Enter your email address"/><br/>
			<p>Email Invoice</p><input type="checkbox" name="email"/><br/>
			<p>Generate PDF</p><input type="checkbox" name="pdf"/><br/>
			<p>Generate Invoice</p><input type="checkbox" name="xls"/><br/>
			
			<input type="submit" value="Generate Invoice"/>
		</form>
	</center>	
</body>
</html>