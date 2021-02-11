<%--
	File: loginaction.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Handles the login request and logs the user into their account
	
	Version: 1.2.0 Release
 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,com.server.*" %>
<% 
	//Sets up boolean that if set to false, stops the program from advancing as break can not be used with JSP
	boolean allowAdvance = true;
	//Get parameters from the submitted form
    String email = request.getParameter("email"); 
    String password = request.getParameter("password"); 
    String returnType = "";
    //try logining into the account using the login function
    try {
        returnType = login.loginPerform(email, password);
    } catch (Exception e) {
        returnType = e.toString();
    }
    //If the email is invalid then return an invalidEmail error
    if(returnType.equals("invalidEmail")) {
    	response.sendRedirect("login.jsp?login=invalid");
    	allowAdvance = false;
    }
    //If the user tried to login to a temp account, return a tempUser error
    if(returnType.equals("tempUser")) {
    	response.sendRedirect("login.jsp?login=tempUserException");
    	allowAdvance = false;
    }
    if(allowAdvance == true) {
   	//Get the user from the database with the email
    User tempUser = com.server.DataBase.queryUserAccount(email);
    String username = tempUser.getName();
    int userID = tempUser.getUserId();
    long phonenum = tempUser.getPhonenum();
    //Set the session attributes for the user
    //If they are an admin then "admin" is set to true
    if(returnType.equals("correctDetails")) {
        session.setAttribute("loggedin", "true");
        session.setAttribute("username", username);
        session.setAttribute("userID", userID);
        session.setAttribute("email", email);
        session.setAttribute("phonenum", phonenum);
        session.setAttribute("admin", "false");
        response.sendRedirect("index.jsp");
    } else if (returnType.equals("adminAccount")){
    	session.setAttribute("loggedin", "true");
        session.setAttribute("username", username);
        session.setAttribute("userID", userID);
        session.setAttribute("email", email);
        session.setAttribute("phonenum", phonenum);
        session.setAttribute("admin", "true");
        response.sendRedirect("index.jsp");
    } else {
    	//The user is redirected to the homepage
        response.sendRedirect("login.jsp?login=invalid");
    }
    }
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h1>Redirecting please wait</h1>
    </body>
</html>
