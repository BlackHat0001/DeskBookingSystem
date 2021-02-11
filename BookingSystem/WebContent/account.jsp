<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*" %>
<%--
	File: account.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The webpage and handling for profile data. This is where the users profile information is changed. The user can also change their password and account information
	from this page.
	
	Version: 1.2.0 Release
 --%>
<%
	//This checks if the user has visited the site before in this session. i.e. The user is not logged in
	//If the session is new, then the below attributes are setup
	if(session.isNew()) {
		//This sets up the loggedin, username, userID, email and phonenum attributes. This is to do with the user account
	    session.setAttribute("loggedin", "false"); 
	    session.setAttribute("username", ""); 
	    session.setAttribute("userID", 0); 
	    session.setAttribute("email", ""); 
	    session.setAttribute("phonenum", 0);
	    //This redirects the user to the homepage (index.jsp) if they are not logged in
	    response.sendRedirect("index.jsp");
	}
	//This sets up the message at the top of the page. Example "Hello Daniel". It uses the username attribute
	String topDisplay = "Hello " + (String)session.getAttribute("username");
	//If the user is not logged in, it sets the message to "You are not signed in". This is unlikley to displayed however,
	//because if the user is not logged in then they will be redirected to the home page.
	if(session.getAttribute("loggedin").equals("false")) {
		topDisplay = "You are not signed in";
	}
	//The below gets the current session attributes and stores them as variables.
	String username = (String)session.getAttribute("username");
	int userID = (int)session.getAttribute("userID");
	String email = (String)session.getAttribute("email");
	long phonenum = (long)session.getAttribute("phonenum"); 
	//If the user is not logged in then the navbar is displayed with the drop
	String navbar = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp?login=attempt\">Login</a></li><br><li class=\"nav-item\"><a class=\"btn btn-primary\" href=\"register.jsp\" role=\"button\">Register</a></li>";
	//If the user is logged in, then the navbar is displayed with the drop down profile menu and the users name is displayed
	if (session.getAttribute("loggedin") == "true") {
	    navbar = "<div class=\"btn-group\">\n<button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" + session.getAttribute("username") + "</button>\n<div class=\"dropdown-menu\">\n<a class=\"dropdown-item\"><img src=\"https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/user.png\" class=\"img-thumbnail\"></a>\n<a class=\"dropdown-item\" href=\"accountbookings.jsp\">View Bookings</a>\n<a class=\"dropdown-item\" href=\"account.jsp\">View Account Details</a>\n<a class=\"dropdown-item\" href=\"logoutaction.jsp\">Logout</a>\n</div>\n</div>";
	}
	String errorLine = "";
	//try to get the parameter of error that is sent from accountdata if there is a problem in password reset or in changing account data
	//A try catch is used in case the error is not initialized and it might try to allocate errorLine with null
	try {
		//if the passwords dont match in the password reset section then it sets the error line displayed in the
	if(request.getParameter("error").equals("pwmatch")) {
		errorLine = "Your passwords dont match";
	}
	} catch (Exception e) {}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	   <script>
	   <!--  When the password reset or edit account detials are clicked, the data is displayed. The appropriet html is inserted into the div with the associated tag -->
	   $(document).ready(function(){
	  	 	$("#editDetails").click(function(){
	  	 		$("#htm").html("<br><form action=\"editAccDetails.jsp\"><div class=\"form-group\"><label for=\"phonenum1\">Name</label><input type=\"text\" class=\"form-control\" id=\"Name1\" placeholder=\"Enter Name\" name=\"name\"></div><div class=\"form-group\"><label for=\"phonenum1\">Phone Number</label><input type=\"text\" class=\"form-control\" id=\"phonenum1\" placeholder=\"Enter Phone Number\" name=\"phonenum\"></div><button type=\"submit\" class=\"btn btn-primary\">Submit</button></form>");
	  	 	});
	  	 	$("#passwordReset").click(function(){
	  	 		$("#htm").html("<br><form action=\"editAccDetails.jsp\"><div class=\"form-group\"><label for=\"password\">Password</label><input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Password\" name=\"password\"></div><div class=\"form-group\"><label for=\"passwordConfirm\">Confirm Password</label><input type=\"password\" class=\"form-control\" id=\"passwordConfirm\" placeholder=\"Confirm Password\" name=\"passwordConfirm\"></div><button type=\"submit\" class=\"btn btn-primary\">Submit</button></form>");
	  	 	});
	   });
	   </script>
<title>Account Details</title>
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
     <!-- Sets up the table for the account information display -->
     <div class="container">
    	<div class="col-lg-3"></div>
    	<div class="col-lg-6">
    		<br>
    		<!--  This is where the Hello <Name> is inserted -->
    		<p class="h1 text-danger text-center"><%= topDisplay %></p>
    		<br>
    		<p class="h3">Your Account Details</p>
    		<!--  This is where the error line for an error with the password reset is inserted -->
    		<p class="text-danger"><%= errorLine %></p>
    		<hr/>
    		<br>
    		<!-- This is where the users account details are displayed  -->
    		<ul class="list-group">
    			<li class="list-group-item">Email: <%= email %></li>
    			<li class="list-group-item">Name: <%= username %></li>
    			<li class="list-group-item">Phone Number: <%= phonenum %></li>
   			</ul>
   			<br>
   			<!-- This is where the two buttons are to activate the detail change feature -->
   			<button type="button" class="btn btn-primary" id="editDetails">Edit Account Details</button>
   			<button type="button" class="btn btn-primary" id="passwordReset">Password Reset</button>
   			<br>
   			<!-- The form is inserted into this div when one of the buttons are pushed -->
   			<div id="htm"></div>
   			
    	</div>
    	<div class="col-lg-3"></div>
     </div>
</body>
</html>