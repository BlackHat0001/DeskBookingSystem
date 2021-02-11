<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, java.io.*"%>
<%--
	File: csvdownload.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Calls the csv download function and prints the csv string
	
	Version: 1.2.0 Release
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	//If the type is all then the method for getting all csv data is called
	//Otherwise, It is called on a single office via its ID
	String type = request.getParameter("type");
	if(type.equals("all")) {
		String returnType = com.server.csv.downloadAll();
		//Prints csv string. Picked up by request
		out.print(returnType);
	} else if(type.equals("single")) {
		String IDtemp = request.getParameter("ID");
		int ID = Integer.parseInt(IDtemp);
		String returnType = com.server.csv.downloadOffice(ID);
		//Prints csv string. Picked up by request
		out.print(returnType);
	}

%>
</body>
</html>