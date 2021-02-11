<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, com.server.*" %>
<%--
	File: adminpanel.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The webpage for the adminpanel for all offices. This handles:
	- Approve Booking
	- Deny Booking
	- Delete Booking
	
	Allows admins to view and manage bookings for that office.
	
	Version: 1.2.0 Release
 --%>
<% 
	//Sets up boolean that if set to false, stops the program from advancing as break can not be used with JSP
	boolean allowAdvance = true;
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
	 //This redirects the user to the homepage (index.jsp) if they are not logged in or are not an admin
	if(session.getAttribute("admin") == "false" || session.isNew()) {
		response.sendRedirect("index.jsp");
		allowAdvance = false;
	}
	//Gets all bookings from the database
	ArrayList<com.server.Booking> bookings = com.server.DataBase.queryAllBookingOffice();
	//Setup office variables
	String officeName = "";
	int officeID = 0;
	int officeSeats = 0;
	int officeOpen = 0;
	int officeClose = 0;
	int officeSlots = 0;
	String officeRequest = "";
	//Setup users arraylist
	ArrayList<User> users = new ArrayList();
	com.server.Office office = new Office(0, "", 0, 0, 0, 0);
	//retreive all user accounts from the database
	users = com.server.DataBase.queryAllUserAccount();
	System.out.println(users.size());
	String csvdata = "";
	boolean search = false;
	String searchString = "";
	Booking searchResult;
	//Program contiunes if allowed
	if(allowAdvance == true) {
		//try to get office parameter. This is the office that the adminpanel will display data for
		try{
			officeRequest = request.getParameter("office");
		} catch (Exception e) {}
		//If no office was provided in the URL, then the office "UK House" is used as the default
		if(officeRequest == null) {
			officeRequest = "UK House";
		}
		//Populate office variables
		office = com.server.DataBase.queryOfficeSingleName(officeRequest);
		officeName = office.getOfficeName();
		officeSeats = office.getSeatsAvailable();
		officeOpen = office.getOfficeOpens();
		officeClose = office.getOfficeCloses();
		officeSlots = office.getMaxSlotsPerDay();
		officeID = office.getOfficeID();
		//Try to get search parameter. This is used if the admin has executed a search before loading this page and will execute the search
		try{
			//If search is provided, then serach is set to true, so a search will be executed
			searchString = request.getParameter("search");
			search = true;
		} catch (Exception e) {}
		//If no search was provided, then no search will be executed as search = false
		if(searchString == null || searchString == "") {
			searchString = "";
			search = false;
		}
		
		
	}
	

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
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"/>
     <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
     <script src="CSSJS/js/bootstrap-slider.js"></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script src="CSSJS/JQuery/jquery.min.js"></script>
     <script src="CSSJS/js/bootstrap.bundle.min.js"></script>
     <script src="CSSJS/js/bootstrap-datepicker.min.js"></script>
     <script>
     <!-- JavaScript Function that handles data posts when using the admin functions -->
     $(document).ready(function(){
    	 <!-- On button clicked, this function is called that handles posting and UI management -->
    	 $("body").on("click", "button", function() {
    		 	<!-- Get the data from the button that contains the current bookingID and the action: Approve, Deny or Delete -->
           		var bookingIDtemp = $(this).val();
           		var actiontemp = $(this).text();
           		<!-- Add a loading spinner to the button -->
           		$(this).fadeIn(500, function(){$(this).append(' <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>')});
           		<!-- Send a post request to admindata.jsp containing the bookingID and the action to perform -->
       		$.post("admindata.jsp",	  
   			  {
   			    bookingID: bookingIDtemp, 
   	     		action: actiontemp, 
    			  },
    			  function(data){
    				  <!-- After post is executed, fade out the row from the table -->
   				  if(actiontemp == "Approve" || actiontemp == "Deny") {
    				$("tr[data-id=" + bookingIDtemp + "]").fadeOut(1000, function() { $(this).remove(); });
    			  } else {
    				  $("tr[data-other-id=" + bookingIDtemp + "]").fadeOut(1000, function() { $(this).remove(); }); 
    			  }
    			  });
       	});
    	 <!-- When the button: "View new bookings" is clicked display it displays the new bookings table -->
      	$('#btn1').click(function(){
			var html = $("#btn1data").html();
			$("#table").html(html);
      	});
      	<!-- When the button: "View all bookings" is clicked display it displays the new bookings table -->
      	$('#btn2').click(function(){
			var html = $("#btn2data").html();
			$("#table").html(html);
      	});
     });
     
     </script>
     <script type="text/javascript" class="init">
     </script>
<title>Admin Panel</title>

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
     <div class="col-2"></div>
     <div class="col-4">
     	<br>
     	<br>
     	<div class="card" style="width: 32rem;">
     		<div class="card-body">
     		<!-- Display the officeName -->
     			<h5 class="display-4 card-title">Office Name</h5>
     			<h3 class="card-subtitle mb-2 text-muted"><%= officeName %></h3>
   			</div>
		</div>
		
     </div>
     <div class="col-4">
     	<br>
     	<br>
     	<div class="card" style="width: 26rem;">
     		<div class="card-body">
     		<!-- Display the number of seats in the office  -->
     			<h5 class="display-4 card-title">Office Capacity</h5>
     			<h3 class="card-subtitle mb-2 text-muted"><%= officeSeats %></h3>
   			</div>
		</div>
     </div>
     <div class="col-2"></div>
     </div>
     <div class="row">
     	<div class="col-3"></div>
     	<div class="col-6">
     	<br>
     	<h1 class="display-3">Welcome Admin</h1>
     	<hr/>
     	<br>
     	<!-- Buttons for displaying different tables  -->
     	<div class="row">
     		<div class="col-4">
     		<input class="btn btn-primary" id="btn1" type="button" value="View New Bookings">
     		</div>
     		<div class="col-4">
     		<input class="btn btn-primary" id="btn2" type="button" value="View All Bookings">
     		</div>
     		<div class="col-4">
     		<a type="button" class="btn btn-primary" id="csv" type="button" download="<%= officeName %>.csv" href="data:application/csv;charset=utf-8,<%= csvdata = com.server.csv.downloadOffice(officeID) %>">Export Excel File</a>
     		</div>
     	</div>
     	<h5><% 
     	//Funtion that executes search using a given date
     	
     	//If search was called with webpage execute search using a given date 
     	if(search == true) {
     		//Print out a string
     		out.println("Search Results: <br>");
     		
     		
	ArrayList<Booking> newBooking = new ArrayList<Booking>();
     
     System.out.println(bookings.size());
     //Loop for all bookings and add all bookings with officeID that mactch the current officeID (adds them to a new arraylist)
     for(int i=0; i<bookings.size(); i++) {
    	 if(bookings.get(i).getOfficeid() == office.getOfficeID()) {
    		 newBooking.add(bookings.get(i));
    	 }
     }
     
     //Perform a MergeSort by date on the newBooking arraylist
     Utils.sort(newBooking);
     
     Booking criteria = new Booking(0, 0, 0, searchString, 0, 0);
   		//Perform a binary search on the data using criteria of the date
     searchResult = Utils.search(newBooking, criteria);
     int userIndex = 0;
     //Loop for all users and find the user for that booking
     for(int i=0; i<users.size(); i++) {
    	 if(searchResult.getUserID() == users.get(i).getUserId()) {
    		 userIndex = i;
    	 }
     }
     //If the search result is -1, then no result was found
     //If this is false, display the search data 
     if(searchResult.getBookingID() != -1) {
    	 out.println("Name: " + users.get(userIndex).getName() + " Email: " + users.get(userIndex).getEmail() + "Phone Number: " + users.get(userIndex).getPhonenum() + 
        		 " Date: " + searchString);
     } else {
    	 //Display error message with given search criteria
    	 out.println("No data was found or there was an error");
     }
     
     	}
	 	%></h5>
     	</div>
     	<div id="table">
     	</div>
     	<div class="col-3"></div>
     </div>
     <div class="d-none" id="btn1data">
     <table class="table" id="btn1table">
	<br>
   	<hr/>
   	<!-- Setup new bookings table -->
     <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Email</th>
	      <th scope="col">Phone Number</th>
	      <th scope="col">Date</th>
	      <th scope="col">Time</th>
	      <th scope="col">No. Seats</th>
	      <th scope="col">
	      <form action="adminpanel.jsp">
	      <input type="hidden" id="var2" value="<%=officeName%>" name="office">
	      <input class="form-control mr-sm-2" type="search" placeholder="YYYY-MM-DD" aria-label="Search" name="search">
    		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    		</form>
    		</th>
	    </tr>
 		</thead>
 		<tbody>
     <%
     //If program is allowed to advance
     if(allowAdvance == true) {
   		//Setup string builder 
     StringBuilder str = new StringBuilder();
     ArrayList<com.server.Booking> userBookings = new ArrayList();
     System.out.println(bookings.size());
     //For all bookings, get the bookings for this office and the bookings with status that is "waiting"
     for(int i=0; i<bookings.size(); i++) {
    	 if(bookings.get(i).getOfficeid() == office.getOfficeID() && bookings.get(i).getStatus().equals("waiting")) {
    		 userBookings.add(bookings.get(i));
    	 }
     }
     
     //Perform a mergesort on the bookings
     Utils.sort(userBookings);
     //for all bookings this will add a row to the table
     for(int i=0; i<userBookings.size(); i++){
    	 int userIndex = 0;
    	 //for all users, find the user that corresponds to this userID
    	 for(int j=0; j<users.size(); j++) {
    		 if(users.get(j).getUserId() == userBookings.get(i).getUserID()) {
    			 userIndex = j;
    			 break;
    		 }
    	 }
    	 //Create a new table row with index of the bookingID
    	 str.append("<tr data-id=\""+userBookings.get(i).getBookingID()+"\">");
    	 str.append("<th scope=\"row\">"+(i+1)+"</th>");
    	 //Add the bookings users na,e to the next collum
    	 str.append("<td>"+users.get(userIndex).getName()+"</td>");
    	 String email = users.get(userIndex).getEmail();
    	 //If the current email for that booking is a tempory account, remove the "tempory:" tag
    	 if(email.contains("tempuser:")) {
    		 email = email.replace("tempuser:", "");
    	 }
    	 //Add the bookings users email, phonenumber and the booking date to the next collums
    	 str.append("<td>"+email+"</td>");
    	 str.append("<td>0"+users.get(userIndex).getPhonenum()+"</td>");
    	 str.append("<td>"+userBookings.get(i).getDate()+"</td>");
    	 
    	//Beginning of time calculation section <----- To Do: Localize
   		//The below section gets the timeslot from the booking and converts it into a real time format
   		//Get the time the office opens and calculate  the time the office is open and how long each slot is
   		double timecalc = office.getOfficeOpens();
   		double officeOpenTime = Math.abs(12 - office.getOfficeOpens()) + Math.abs(0 - office.getOfficeCloses());
   		officeOpenTime = Math.abs(officeOpenTime);
   		double officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
   		//Calculate the current booking slot
   		officeSlotLength = officeSlotLength * (userBookings.get(i).getTimeslot() - 1);
   		timecalc = timecalc + officeSlotLength;
   		//Calculate the beginning of the slot
   	    double mintemp = timecalc % 1;
   		int hour = (int)(timecalc - mintemp);
   		int min = (int)(mintemp * 60);
   		//Calculate the end interval
   		officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
   		timecalc = office.getOfficeOpens();
   		officeSlotLength = officeSlotLength * (userBookings.get(i).getTimeslot());
   		timecalc = timecalc + officeSlotLength;
   		//Calculate the end of the slot
   	    double mintempend = timecalc % 1;
   		int hourend = (int)(timecalc - mintempend);
   		int minend = (int)(mintempend * 60);
   		//Add any additional zeros if the formatting is incorrect. E.g. 14:0 --> 14:00
   		String additional1 = "";
   		String additional2 = "";
   		if(min == 0) {
   			additional1 = "0";
   		}
   		if (minend == 0) {
   			additional2 = "0";
   		}
   		//End of time calculation section
   		
   		//Append the formatted time
    	 str.append("<td>"+hour+":"+min+""+additional1+" - "+hourend+":"+minend+""+additional2+"</td>");
   		//Append the number of booked desks
    	 str.append("<td>"+userBookings.get(i).getNumberdesks()+"</td>");
   		//Add the action buttons: Approve, Deny
    	 str.append("<td><button type=\"button\" value=\""+userBookings.get(i).getBookingID()+"\" class=\"btn btn-success\" href=\"\" role=\"button\">Approve</button></td><td><button type=\"button\" value=\""+userBookings.get(i).getBookingID()+"\" class=\"btn btn-danger\" href=\"\" role=\"button\">Deny</button></td>");
    	 str.append("</tr>");
    	 System.out.println("a");
     }
     //Print the table data
    	out.println(str.toString());
     } else {
    	 //If the program was halted, display no data
    	 out.println("<tr><th scope=\"1\"></th><td>No Data To Display</td></tr>");
     }
     %>
     <tr>
     <td>No more data</td>
     </tr>
     </tbody>
     </table>
     </div>
     <div class="d-none" id="btn2data">
     <table class="table" id="btn2table">
	<br>
   	<hr/>
   	<!-- Setup all bookings table -->
     <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Email</th>
	      <th scope="col">Phone Number</th>
	      <th scope="col">Date</th>
	      <th scope="col">Time</th>
	      <th scope="col">No. Seats</th>
	      <th scope="col">Status</th>
	      <th scope="col"><form action="adminpanel.jsp">
	      <input type="hidden" id="var2" value="<%=officeName%>" name="office">
	      <input class="form-control mr-sm-2" type="search" placeholder="YYYY-MM-DD" aria-label="Search" name="search">
    		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    		</form>
    		</th>
	    </tr>
 		</thead>
 		<tbody>
     <%
   //If program is allowed to advance
     if(allowAdvance == true) {
    	//Setup string builder 
     StringBuilder str = new StringBuilder();
     ArrayList<com.server.Booking> userBookings = new ArrayList();
     System.out.println(bookings.size());
   //For all bookings, get the bookings for this office
     for(int i=0; i<bookings.size(); i++) {
    	 if(bookings.get(i).getOfficeid() == office.getOfficeID()) {
    		 userBookings.add(bookings.get(i));
    	 }
     }
   //Perform a mergesort on the bookings
     Utils.sort(userBookings);
   //for all bookings this will add a row to the table
     for(int i=0; i<userBookings.size(); i++){
    	 int userIndex = 0;
    	//for all users, find the user that corresponds to this userID
    	 for(int j=0; j<users.size(); j++) {
    		 if(users.get(j).getUserId() == userBookings.get(i).getUserID()) {
    			 userIndex = j;
    			 break;
    		 }
    	 }
    	//Create a new table row with index of the bookingID
    	 str.append("<tr data-other-id=\""+userBookings.get(i).getBookingID()+"\">");
    	 str.append("<th scope=\"row\">"+(i+1)+"</th>");
    	 str.append("<td>"+users.get(userIndex).getName()+"</td>");
    	 String email = users.get(userIndex).getEmail();
    	//If the current email for that booking is a tempory account, remove the "tempory:" tag
    	 if(email.contains("tempuser:")) {
    		 email = email.replace("tempuser:", "");
    	 }
    	//Add the bookings users email, phonenumber and the booking date to the next collums
    	 str.append("<td>"+email+"</td>");
    	 str.append("<td>0"+users.get(userIndex).getPhonenum()+"</td>");
    	 str.append("<td>"+userBookings.get(i).getDate()+"</td>");
    	 
    	//Beginning of time calculation section <----- To Do: Localize
   		//The below section gets the timeslot from the booking and converts it into a real time format
   		//Get the time the office opens and calculate  the time the office is open and how long each slot is
   		double timecalc = office.getOfficeOpens();
   		double officeOpenTime = Math.abs(12 - office.getOfficeOpens()) + Math.abs(0 - office.getOfficeCloses());
   		officeOpenTime = Math.abs(officeOpenTime);
   		double officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
   		//Calculate the current booking slot
   		officeSlotLength = officeSlotLength * (userBookings.get(i).getTimeslot() - 1);
   		timecalc = timecalc + officeSlotLength;
   		//Calculate the beginning of the slot
   	    double mintemp = timecalc % 1;
   		int hour = (int)(timecalc - mintemp);
   		int min = (int)(mintemp * 60);
   		//Calculate the end interval
   		officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
   		timecalc = office.getOfficeOpens();
   		officeSlotLength = officeSlotLength * (userBookings.get(i).getTimeslot());
   		timecalc = timecalc + officeSlotLength;
   		//Calculate the end of the slot
   	    double mintempend = timecalc % 1;
   		int hourend = (int)(timecalc - mintempend);
   		int minend = (int)(mintempend * 60);
   		//Add any additional zeros if the formatting is incorrect. E.g. 14:0 --> 14:00
   		String additional1 = "";
   		String additional2 = "";
   		if(min == 0) {
   			additional1 = "0";
   		}
   		if (minend == 0) {
   			additional2 = "0";
   		}
   		//End of time calculation section
   		
   		//Append formatted time
    	 str.append("<td>"+hour+":"+min+""+additional1+" - "+hourend+":"+minend+""+additional2+"</td>");
   		//Append the bookings seats ammount
    	 str.append("<td>"+userBookings.get(i).getNumberdesks()+"</td>");
    	 String color = "success";
    	 //If the status is waiting, then set is as red otherwise approved would be green
    	 if(bookings.get(i).getStatus().equals("waiting")) {
    		 color = "danger";
    	 }
    	 //Get if the user attended and then sets colour
    	 String bookingstatus = userBookings.get(i).getStatus();
  		if(bookingstatus.equals("Unattended")) {
  			bookingstatus = "Didn't Attend";
  			color = "warning";
  		}
  		//Append the current booking status
    	 str.append("<td><p class=\"text-"+color+"\">"+bookingstatus+"</p></td>");
  		//Append the button for action: Delete
    	 str.append("<td><button type=\"button\" value=\""+userBookings.get(i).getBookingID()+"\" class=\"btn btn-danger\" href=\"\" data-toggle=\"modal\" data-target=\"#exampleModal\" role=\"button\">Delete</button></td>");
    	 str.append("</tr>");
    	 System.out.println("a");
     }
   //Print the table data
    	out.println(str.toString());
     } else {
    	//If the program was halted, display no data
    	 out.println("<tr><th scope=\"1\"></th><td>No Data To Display</td></tr>");
     }
     %>
     </tbody>
     </table>
     </div>
     </div>
    
</body>
</html>