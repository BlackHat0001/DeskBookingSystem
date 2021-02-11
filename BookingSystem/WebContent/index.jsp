<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<%--
	File: index.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The homepage for the system. Displays all of the buttons to access different office booking forms.
	Also displays admin portal buttons and the csv all data download function (for admins).
	
	
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
    session.setAttribute("admin", "false");
}
	if(!(session.getAttribute("loggedin") == "true")) {
		session.setAttribute("admin", "false");
	}
	//If the user is logged in, then the navbar is displayed with the drop down profile menu and the users name is displayed
	String navbar = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp?login=attempt\">Login</a></li><br><li class=\"nav-item\"><a class=\"btn btn-primary\" href=\"register.jsp\" role=\"button\">Register</a></li>";
	//If the user is not logged in then the navbar is displayed with the drop
	if (session.getAttribute("loggedin") == "true") {
	    navbar = "<div class=\"btn-group\">\n<button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" + session.getAttribute("username") + "</button>\n<div class=\"dropdown-menu\">\n<a class=\"dropdown-item\"><img src=\"https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/user.png\" class=\"img-thumbnail\"></a>\n<a class=\"dropdown-item\" href=\"accountbookings.jsp\">View Bookings</a>\n<a class=\"dropdown-item\" href=\"account.jsp\">View Account Details</a>\n<a class=\"dropdown-item\" href=\"logoutaction.jsp\">Logout</a>\n</div>\n</div>";
	}
	//Gets the office display html from the loadData method. This is all of the buttons on the homepage that take the user
	//to individual booking screens. If the user is an admin, then admin features are also sent over in html.
	String officeDisplay = com.server.loadData.queryOffice((String)session.getAttribute("admin"));

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
	<title>LSH Booking System</title>
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

     <div class="container-fluid">
       <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
        <br>
        <!--  CSS for displaying pictures on different sized devices -->
        <style>
        @media (min-width: 768px) {

		.header-image {
		        content:url("https://i.ibb.co/Bc3MTdF/bookingindex-jpg.png");
		        border-radius: 8px;
		    }
		
		}
		@media (max-width: 767px) {

		.header-image {
		        content:url("https://i.ibb.co/C9yszpz/bookingindex2-jpg.png");
		        border-radius: 8px;
		        display: block;
				margin-left: auto;
				margin-right: auto;
				width: 100%;
		    }
		
		}
		@media (max-width: 480px) {

		.header-image {
		        content:url("https://i.ibb.co/C9yszpz/bookingindex2-jpg.png");
		        border-radius: 8px;
		        display: block;
		        margin-left: auto;
				margin-right: auto;
				width: 100%;
		    }
		
		}
        </style>
        <div class="header-image rounded"></div>
        <br>
        <br>
        <p class="h3 font-weight-bold">Please select your office:</p>
	  	
        <hr/>
        <!-- Display all office data -->
         <div class="list-group">
           <%= officeDisplay %>
        </div>
        <br>
        <br>
        <% 
        	//If the user is an admin the display the button to download csv for all data. Calls com.server.csv.downloadAll()
        	if(session.getAttribute("admin") == "true") {
        		out.write("<a type=\"button\" class=\"btn btn-danger\" id=\"csv\" type=\"button\" download=\"allData.csv\" href=\"data:application/csv;charset=utf-8," + com.server.csv.downloadAll() + "\">(Admin) Export Excel File for All Offices</a>");
        	}
        %>
        <br>
        <span class="align-bottom"></span><p class="text-left">Having a problem? Report it <a href="https://forms.gle/RvESA2e3rY2mhtf37">here</a></p></span>
        </div>
        <div class="col-lg-3"><p></div>
       </div>
       
     </div>
   </body>

</html>
