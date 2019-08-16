<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.css"
        rel="stylesheet">
   
</style>
<title>Book tickets now</title>
</head>
<body>
<h3>book now</h3>
<div class="container">
<form:form action="enterDetails" method="POST">
<c:forEach items="${flightlist}" var="eachFlight">
<table class="table table-striped">
    <tr>      
    	<td>${eachFlight.flight_number}</td>
        <td>${eachFlight.flight_name}</td>
        <td>${eachFlight.price}</td>
        <td>${eachFlight.source}</td>
        <td>${eachFlight.destination}</td>
        <td>${eachFlight.travel_time}</td>  
        <td>${eachFlight.available_seats}</td> 
        <input type="submit" value="Book Ticket" class="btn btn-dark">
    </tr>
    </table>
</c:forEach>
</form:form>
</div>
</body>
</html>