<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User details</title>
</head>
<body>
<form:form action="validateCardDetails" method="POST">
<label>Cvv</label>
<form:input path="cvv"/>

<label>Card number</label>
<form:input path="card_number"/>

<label>Expiry date</label>
<form:input path="expiry_date"/>

<input type="submit" value="Book">
</form:form>
</body>
</html>