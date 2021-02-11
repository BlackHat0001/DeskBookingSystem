<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--
	File: dateGet.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Handles data posts from the booking page.
	
	Version: 1.2.0 Release
 --%>
<!DOCTYPE html>
<html>
<body>
<% 
//Handles data post requests from the booking page for the bookings on a specific date
//Calls the loadData method to prepare the data
String officeName = request.getParameter("officeName");
String date = request.getParameter("date");
String returnType = com.server.loadData.timeSelection(officeName, date);
out.print(returnType);
%>

</body>
</html>