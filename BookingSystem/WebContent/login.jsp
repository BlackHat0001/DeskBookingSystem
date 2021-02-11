<%--
	File: login.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The login form for logging into user accounts. Posts data to loginaction.jsp
	
	Version: 1.2.0 Release
 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<% 
    String errorLine = "";
	//This checks if the user has visited the site before in this session. i.e. The user is not logged in
	//If the session is new, then the below attributes are setup
    if(session.isNew()) {
        session.setAttribute("loggedin", "false");
    }
  	//If the user is logged in, then the navbar is displayed with the drop down profile menu and the users name is displayed
  	String navbar = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp?login=attempt\">Login</a></li><br><li class=\"nav-item\"><a class=\"btn btn-primary\" href=\"register.jsp\" role=\"button\">Register</a></li>";
  	//If the user is not logged in then the navbar is displayed with the drop
  	if (session.getAttribute("loggedin") == "true") {
  	    navbar = "<div class=\"btn-group\">\n<button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" + session.getAttribute("username") + "</button>\n<div class=\"dropdown-menu\">\n<a class=\"dropdown-item\"><img src=\"https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/user.png\" class=\"img-thumbnail\"></a>\n<a class=\"dropdown-item\" href=\"accountbookings.jsp\">View Bookings</a>\n<a class=\"dropdown-item\" href=\"account.jsp\">View Account Details</a>\n<a class=\"dropdown-item\" href=\"logoutaction.jsp\">Logout</a>\n</div>\n</div>";
  	}
    String returntype = "attempt";
    //Legacy way of handling errors
    //If the page is called with no parameters then returntype is set with default value attempt
    try{
    	returntype = request.getParameter("login");
    	if(returntype == null) {
    		returntype = "attempt";
    	}
    } catch (Exception e) {
    	
    }
    //If the returntype is an error message, then an error line is updated with the correct string
    //This one handles incorrect emails or passwords
    if(returntype.equals("invalid")) {
        errorLine = "Incorrect Email or Password";
        String errorproblem = request.getParameter("debug");
    }
    //This one is when the user tries to login to a temp account
    if(returntype.equals("tempUserException")) {
        errorLine = "You can not log into this account! The email cannot contain \"tempuser:\"";
        String errorproblem = request.getParameter("debug");
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
	<!-- set-up library references to css, javascript, ajax and jquery libraries -->
             <link href="CSSJS/css/bootstrap.min.css" rel="stylesheet">
		     <link href="CSSJS/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
		     <link href="CSSJS/css/bootstrap-slider.css" rel="stylesheet">
		     <script src="CSSJS/js/bootstrap-slider.js"></script>
			 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			 <script src="CSSJS/JQuery/jquery.min.js"></script>
		     <script src="CSSJS/js/bootstrap.bundle.min.js"></script>
		     <script src="CSSJS/js/bootstrap-datepicker.min.js"></script>

    </head>
    <body>
    <!--  Sets up the navbar  -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
       <div class="container">
         <a class="navbar-brand" href="index.jsp">LSH Desk Booking System</a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="navbarResponsive">
           <ul class="navbar-nav ml-auto">
             <li class="nav-item active">
               <a class="nav-link" href="index.jsp">Home
                 <span class="sr-only">(current)</span>
               </a>
             </li>
             <!--  Inserts generated navbar with either the login and register buttons or the profile drop down -->
            <%= navbar %>
           </ul>
         </div>
       </div>
     </nav>
        
        <div class="container">
        <br>
        <strong>Login to Your Account</strong>
        <hr/>
        <!-- Display the error line -->
		<p class="text-center text-danger"><a><%= errorLine %></a></p>
		<!-- Setup the login form  -->
        <form action="loginaction.jsp">
            <div class="form-group">
              <label for="exampleInputEmai1">Email address</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
              <small id="emailHelp" class="form-text text-muted">We'll never share your details with anyone.</small>
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"  name="password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        
        </div>
        
    </body>
</html>
