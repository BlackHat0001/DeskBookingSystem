<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	if(session.isNew()) {
	    session.setAttribute("loggedin", "false");
	}
	String navbar = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp?login=attempt\">Log-In</a></li><br><li class=\"nav-item\"><a class=\"btn btn-primary\" href=\"register.jsp\" role=\"button\">Register</a></li>";
	if (session.getAttribute("loggedin") == "true") {
	    navbar = "<div class=\"btn-group\">\n<button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" + session.getAttribute("username") + "</button>\n<div class=\"dropdown-menu\">\n<a class=\"dropdown-item\"><img src=\"https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/user.png\" class=\"img-thumbnail\"></a>\n<a class=\"dropdown-item\" href=\"accountbookings.jsp\">View Bookings</a>\n<a class=\"dropdown-item\" href=\"account.jsp\">View Account Details</a>\n<a class=\"dropdown-item\" href=\"logoutaction.jsp\">Logout</a>\n</div>\n</div>";
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Booking Completed!</title>
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
             <%= navbar %>
           </ul>
         </div>
       </div>
     </nav>
<div ="container">
<div class="row">
<div class="col-lg-3"></div>
<div class="col-lg-6">
<br>
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
<p class="text-danger h1 text-center">Your booking is complete</p>
<hr/>
<p class="text-center h3">A confirmation email has been sent</p>
<br>
<p class="text-center">You can <a href="register.jsp">register an account</a> to edit your bookings</p>
<div class="col-lg-3"></div>
</div>
</body>
</html>