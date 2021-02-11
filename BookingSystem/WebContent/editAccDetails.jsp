<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*" %>
<%--
	File: editAccDetails.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Handles the following requests from the account.jsp:
	- Change password
	- Change account details
	
	Version: 1.2.0 Release
 --%>
<%
	//Get the session attribute for email
	String email = (String)session.getAttribute("email");
	String name = "";
	long phonenum = 0;
	String pw = "";
	String pwconfirm = "";
	//Get the parameter for name from the form in account.jsp
	name = request.getParameter("name");
	//Checks if phonenum has been set before requesting the parameter
	if (!(request.getParameter("phonenum") == null || request.getParameter("phonenum") == "")) {
		phonenum = Long.parseLong(request.getParameter("phonenum"));
	}
	//Gets the password form data / parameters
	pw = request.getParameter("password");
	pwconfirm = request.getParameter("passwordConfirm");
	boolean updateName = true;
	boolean updatePhonenum = true;
	boolean updatePassword = true;
	try{
		//if no name has been sent in the form, then dont update the name
	if(name == null || name.equals("") || name.equals("null")) {
		updateName = false;
	} else {
		session.setAttribute("username", name);
	}
		//if no phonenumber has been set, then dont update the phonenumber
	if(phonenum == 0) {
		updatePhonenum = false;
	} else {
		session.setAttribute("phonenum", phonenum);
	}
		//if no password has been set, dont update the passwords
	if(pw == null || pw.equals("") || pw.equals("null")) {
		updatePassword = false;
	} else {
		//If the passwords dont match send an error pwmatch back to the form
		if(!(pw.equals(pwconfirm))) {
			response.sendRedirect("account.jsp?error=pwmatch");
		}
	}
	} catch (Exception e) {}
	//Update the user account information in the database
	com.server.DataBase.editUserAccount(email, pw, name, phonenum, updatePassword, updateName, updatePhonenum);
	//Redirect the user back to the account page
	response.sendRedirect("account.jsp?error=success");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirecting please wait</title>
</head>
<body>
<a>Sorry, This feature is still under construction</a>
</body>
</html>