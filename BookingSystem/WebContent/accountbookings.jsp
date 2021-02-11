<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*" %>
<%--
	File: accountbokings.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The webpage for displaying all of the users bookings. 
	
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
	//If the user is not logged in then the navbar is displayed with the drop
	String navbar = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp?login=attempt\">Login</a></li><br><li class=\"nav-item\"><a class=\"btn btn-primary\" href=\"register.jsp\" role=\"button\">Register</a></li>";
	//If the user is logged in, then the navbar is displayed with the drop down profile menu and the users name is displayed
	if (session.getAttribute("loggedin") == "true") {
	    navbar = "<div class=\"btn-group\">\n<button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" + session.getAttribute("username") + "</button>\n<div class=\"dropdown-menu\">\n<a class=\"dropdown-item\"><img src=\"https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/user.png\" class=\"img-thumbnail\"></a>\n<a class=\"dropdown-item\" href=\"accountbookings.jsp\">View Bookings</a>\n<a class=\"dropdown-item\" href=\"account.jsp\">View Account Details</a>\n<a class=\"dropdown-item\" href=\"logoutaction.jsp\">Logout</a>\n</div>\n</div>";
	}
	//This gets all bookings in the database
	ArrayList<com.server.Booking> bookings = com.server.DataBase.queryAllBookingOffice();
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
<title>Account Bookings</title>
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
             <%=navbar%>
           </ul>
         </div>
       </div>
     </nav>
     <container>
     <div class="row">
  	<div class="col-3"></div>
  	<div class="col-6">
     <br>
     <p class="h1 text-danger">Your Bookings</p>

     <br>
     <hr/>
     <!--  Sets up the table to display the users bookings -->
     <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Office</th>
	      <th scope="col">Date</th>
	      <th scope="col">Time</th>
	      <th scope="col">Seats</th>
	    </tr>
 		</thead>
 		<tbody>
     <%
     	//Gets all offices from the database. This will be used when displaying the office name of that booking
     	ArrayList<com.server.Office> offices = com.server.DataBase.queryAllOffice();
     			//Initializes a string builder to build the table data
               StringBuilder str = new StringBuilder();
     			//Create another booking arraylist that will store the bookings for that user
     			//and sorted by date
               ArrayList<com.server.Booking> userBookings = new ArrayList();
     			//This for loop goes through each booking in bookings and adds each booking that belong to the
     			//user to the userBookings ArrayList
               for(int i=0; i<bookings.size(); i++) {
              	 if(bookings.get(i).getUserID() == (int)session.getAttribute("userID")) {
              		 userBookings.add(bookings.get(i));
              		 System.out.print("true");
              	 }
               }
     			//Calls a merge sort on the userBookings arrayList to sort by dates (newest first)
               com.server.Utils.sort(userBookings);
     			//Loop for all of the userBookings 
               for(int i=0; i<userBookings.size(); i++){
              	 String officeName = "";
              	 //Loop for all offices and get the office Name of the current booking in the current nested loop
              	 //Stores it in officeName
             		for(int j=0; j<offices.size(); j++) {
              	 if(offices.get(j).getOfficeID() == userBookings.get(i).getOfficeid()) {
              		 officeName = offices.get(j).getOfficeName();
              	 }
             		}
              	 //Append table data for the current row. Uses The office name, date, timeslot and the number of desks
              	 str.append("<tr>");
              	 str.append("<th scope=\"row\">"+(i+1)+"</th>");
              	 str.append("<td>"+officeName+"</td>");
              	 str.append("<td>"+userBookings.get(i).getDate()+"</td>");
              	 str.append("<td>"+userBookings.get(i).getTimeslot()+"</td>");
              	 str.append("<td>"+userBookings.get(i).getNumberdesks()+"</td>");
              	 str.append("</tr>");
              	 System.out.println("a");
               }
     			//print the stringbuilder to the webpage
               out.println(str.toString());
     %>
       </tbody>
	</table>
     </div>
     <div class="col-3"></div>
     </div>
</body>
</html>