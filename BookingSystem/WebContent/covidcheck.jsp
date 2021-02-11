<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<%--
	File: covidcheck.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: A covid check that the user must complete before they are redirected to the booking page.
	
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
	//Get the office parameter to parse onto the booking page
	String office = request.getParameter("office");
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
<title>COVID-19 Symptoms</title>
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
     <div class="row">
     <div class="col-lg-1"></div>
     <div class="col-lg-10">
     <br>
     <!-- Displays the covid-19 simptoms -->
     <h1 class="display4">COVID-19 Symptom Check</h1>
     <p>All content is taken from the <a href="https://nhs.uk">NHS website</a></p>
     <br>
     <h5>If you have any of the main symptoms of coronavirus (COVID-19), get a test as soon as possible. Stay at home until you get the result.</h5>
     <br>
     <h4>Main Symptoms:</h4>
     <br>
     <p><strong>A high temperature</strong> – this means you feel hot to touch on your chest or back (you do not need to measure your temperature)</p>
     <p><strong>A new, continuous cough</strong> – this means coughing a lot for more than an hour, or 3 or more coughing episodes in 24 hours (if you usually have a cough, it may be worse than usual)</p>
     <p><strong>A loss or change to your sense of smell or taste</strong> – this means you've noticed you cannot smell or taste anything, or things smell or taste different to normal</p>
     <p><strong>Most people with coronavirus have at least 1 of these symptoms.</strong></p>
     <br>
     
     <!-- Adds a button that redirects the user to the booking page with the officeName parsed from the homepage -->
     <p>I have read the above COVID-19 symptom list and confirm I have had no symptoms in the past 2 weeks &nbsp; &nbsp;<a type="button" href="booking.jsp?office=<%= office %>" class="btn btn-danger">Proceed to booking</a></p>
     <hr/>
     <div class="d-flex justify-content-center" style="position: relative; max-width: 1920px; height: 800px"><iframe src="https://api-bridge.azurewebsites.net/conditions/?p=coronavirus-covid-19&aspect=name,overview_short,symptoms_short,symptoms_long,treatments_overview_short,other_treatments_long,self_care_long,prevention_short,causes_short&tab=3&uid=desks.lshportal.co.uk" title="NHS website - health a-z" style="position: absolute; height: 100%; width: 100%; border: 2px solid #015eb8;"></iframe></div>
     </div>
     <div class="col-lg-1"></div>
     </div>
     </div>
</body>
</html>