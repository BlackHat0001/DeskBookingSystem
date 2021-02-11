<%--
	File: register.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The registration form and handles errors
	
	Version: 1.2.0 Release
 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<% 
    String errorLine = "";
	//This checks if the user has visited the site before in this session. i.e. The user is not logged in
	//If the session is new, then the below attributes are setup
  	if(session.isNew()) {
  	//This sets up the loggedin, username, userID, email and phonenum attributes. This is to do with the user account
      session.setAttribute("loggedin", "false");
      session.setAttribute("username", "");
      session.setAttribute("userID", 0);
      session.setAttribute("email", "");
      session.setAttribute("phonenum", 0);
      session.setAttribute("admin", "false");
  	}
	//If the user is not logged in then admin is automatically set to false to prevent security problems
	if(!(session.getAttribute("loggedin") == "true")) {
		session.setAttribute("admin", "false");
	}
	
	//If the user is logged in, then the navbar is displayed with the drop down profile menu and the users name is displayed
	String navbar = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp?login=attempt\">Login</a></li><br><li class=\"nav-item\"><a class=\"btn btn-primary\" href=\"register.jsp\" role=\"button\">Register</a></li>";
	//If the user is not logged in then the navbar is displayed with the drop
	if (session.getAttribute("loggedin") == "true") {
	    navbar = "<div class=\"btn-group\">\n<button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" + session.getAttribute("username") + "</button>\n<div class=\"dropdown-menu\">\n<a class=\"dropdown-item\"><img src=\"https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/user.png\" class=\"img-thumbnail\"></a>\n<a class=\"dropdown-item\" href=\"accountbookings.jsp\">View Bookings</a>\n<a class=\"dropdown-item\" href=\"account.jsp\">View Account Details</a>\n<a class=\"dropdown-item\" href=\"logoutaction.jsp\">Logout</a>\n</div>\n</div>";
	}
    try{
    	//When errors are reterned the full error line is assigned here
	    switch(request.getParameter("error")) {
	    //An error for if a user entered an account that already exists
	    	case "duplicateAccount": {
	    		errorLine = "An account with that email already exists";
	    		break;
	    	}
	    	//An error for when the two passwords dont match
	    	case "passwordMatch": {
	    		errorLine = "Passwords do not match";
	    		break;
	    	}
	    	//Future framework for a phonenum regex
	    	case "phonenum": {
	    		errorLine = "Your phonenumber does not match the format \"+44(Your Phone Num)\"";
	    		break;
	    	}
	    	//An error for when the email does not match the regex
	    	case "email": {
	    		errorLine = "Your email is not @lsh.co.uk";
	    		break;
	    	}
	    	default: { errorLine = "There was a problem. Please try again later or contact the service administrator and give them this message:"+request.getParameter("error")+""; }
	    }
    } catch(Exception e) {
    	errorLine = "";
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
        <strong>Register A New Account</strong>
        <!-- Display for the error line -->
        <p class="text-danger"><%= errorLine %></p>
        <hr/>
        <!-- The registration form -->
        <form action="registeraction.jsp">
            <div class="form-group">
              <label for="exampleInputEmai1">Email address</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email e.g. JohnDoe@lsh.co.uk" name="email">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"  name="password">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Confirm Password</label>
              <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Confirm Password"  name="passwordconfirm">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">First Name</label>
              <input type="text" class="form-control" id="exampleInputPassword1" placeholder="First Name"  name="firstname">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Surname</label>
              <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Surname"  name="surname">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Phone Number</label>
              <input type="number" class="form-control" id="exampleInputPassword1" placeholder="Phone Num"  name="phonenum">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        
        </div>
        
        
    </body>
</html>
