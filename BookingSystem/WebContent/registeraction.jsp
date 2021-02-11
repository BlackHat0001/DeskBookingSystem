<%--
	File: registeraction.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: System for handling the registration form from register.jsp. 
	
	Version: 1.2.0 Release
 --%>

<%@page import="com.server.DataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.util.regex.Pattern, java.util.regex.Matcher" %>
<% 
	boolean allowAdvance = true;
	//Gets all form parameters sent to this webpage
    String email = request.getParameter("email"); 
    String password = request.getParameter("password"); 
    String passwordConfirm = request.getParameter("passwordconfirm");
    String firstname = request.getParameter("firstname");
    String surname = request.getParameter("surname");
    String phonenumtemp = request.getParameter("phonenum");
    System.out.println(password + "" + passwordConfirm);
    //Joins the names together
    String name = firstname + " " + surname;
    String returnType = "";
    String error = "";
    //Users a regex to make sure the email ends with an @lsh.co.uk or @lsh.com
    Pattern regExPattern = Pattern.compile("^[\\w-\\._\\+%]+@(lsh.co.uk|lsh.com)");
    Matcher matcher = regExPattern.matcher(email);
    //If the regex does not match then return a pattern match error
    if(!(matcher.matches())) {
    	error = "email";
    	allowAdvance = false;
    }
    //If the two passwords do not equal then return a password error
    long phonenum = 0;
    if(!(password.equals(passwordConfirm))) {
    	error = "passwordMatch";
    	allowAdvance = false;
    }
    
    if(allowAdvance == true) {
    	//Attempt to create the account in the database
   		try{
   			phonenum = Long.parseLong(phonenumtemp);
           returnType = com.server.login.createAccount(email, password, name, phonenum); 
        } catch (Exception e) {
        }
    }
    //Set the session attributes as if the user were signing in as the user is now logged in
    if(returnType.equals("accCreateComplete")) {
        session.setAttribute("loggedin", "true");
        session.setAttribute("username", name);
        session.setAttribute("userID", com.server.DataBase.queryUserAccount(email).getUserId());
        session.setAttribute("email", email);
        session.setAttribute("phonenum", phonenum);
        response.sendRedirect("index.jsp");
    } else {
    	if(error.equals("")) {
    		error = returnType;
    	}
    	//Return a general error
        response.sendRedirect("register.jsp?error="+error);
    }
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
