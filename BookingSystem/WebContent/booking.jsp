<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,com.server.*,java.time.*" %>
<%--
	File: booking.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The webpage for the booking form. Posts the form data and also makes the booking process as easy as possible.
	
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
        //has user read the symptom list?
        session.setAttribute("readSymptoms", "false");
    }
	
    String navbar = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp?login=attempt\">Log-In</a></li><br><li class=\"nav-item\"><a class=\"btn btn-primary\" href=\"register.jsp\" role=\"button\">Register</a></li>";
    String formType = "unlogged";
  	//If the user is logged in, then the navbar is displayed with the drop down profile menu and the users name is displayed
    if (session.getAttribute("loggedin") == "true") {
    	//If the user is not logged in then the navbar is displayed with the drop
        navbar = "<div class=\"btn-group\">\n<button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" + session.getAttribute("username") + "</button>\n<div class=\"dropdown-menu\">\n<a class=\"dropdown-item\"><img src=\"https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/user.png\" class=\"img-thumbnail\"></a>\n<a class=\"dropdown-item\" href=\"accountbookings.jsp\">View Bookings</a>\n<a class=\"dropdown-item\" href=\"account.jsp\">View Account Details</a>\n<a class=\"dropdown-item\" href=\"logoutaction.jsp\">Logout</a>\n</div>\n</div>";
        formType = "logged";
    }
    String name = "";
    String error = "";
    //try to get the office and error parameters to handle error messages and getting the correct data
    try {
    	//get office and error parameters
    	name = request.getParameter("office");
    	error = request.getParameter("error");
    	//If the office is not specified, then the program tries to redirect them to the homepage
    	//A default value of "UK House" is also set
    	if(name == null || name.isEmpty()) {
    		response.sendRedirect("index.jsp");
    		name = "UK House";
    	}
    	//If no error is set, then it sets the error line with no message
    	if(error == null || error.isEmpty()) {
    		error = "";
    	}
    } catch (Exception e ) {
    	//If error, redirect to homepage
    	response.sendRedirect("index.jsp");
    }
    //Error handling <------- TODO: Integrate Switch Case Statement
    //If an error occured on the last form, find the correct message and add it to the error line.
    if(error.equals("notimeslot")) {
    	error = "You need to select a time slot";
    } else if(error.equals("bookingexceedcap")) {
    	error = "Your number of seats exceeds the office capcaity";
    } else if(error.equals("negseats")) {
    	error = "You have entered a 0 or a negative number of seats";
    } else if(error.equals("nodetails")) {
    	error = "You have not provided contact details";
    } else if(error.equals("email")) {
    	error = "Your email must be @lsh.co.uk or @lsh.com";
    }
    //Get the office data of the current office from the database
	com.server.Office office = com.server.DataBase.queryOfficeSingleName(name);
	String officeName = office.getOfficeName();
	int officeSeats = office.getSeatsAvailable();
	int officeOpen = office.getOfficeOpens();
	int officeClose = office.getOfficeCloses();
	int officeSlots = office.getMaxSlotsPerDay();
	String output = "";
	//If the user is logged in, then the input for information is removed as the user information is already saved to the account
	if (formType.equals("logged")) {
		output = "<div class=\"col\"><a>No need to enter your details!</a><br><a>They have been saved to your account.</a></div>";
	} else {
		output = "<div class=\"form-group row\"><label for=\"emailid\" class=\"col-2 col-form-label\">Email</label><div class=\"col-10\"><input class=\"form-control\" type=\"email\" placeholder=\"e.g. JohnDoe@lsh.co.uk\" value=\"\" id=\"emailid\" name=\"email\"></div></div><div class=\"form-group row\"><label for=\"nameid\" class=\"col-2 col-form-label\">Full Name</label><div class=\"col-10\"><input class=\"form-control\" type=\"text\" value=\"\" id=\"nameid\" name=\"name\"></div></div><div class=\"form-group row\"><label for=\"phoneid\" value=\"0\" class=\"col-2 col-form-label\">Phone Number</label><div class=\"col-10\"><input class=\"form-control\" type=\"text\" value=\"\" id=\"phoneid\" name=\"phonenum\"></div></div>";
	}
	//Get the current date
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int day = localDate.getDayOfMonth();
	int month = localDate.getMonthValue();
	int year = localDate.getYear();
	String dateFormat = day + "-" + month + "-" + year;
%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <meta name="description" content="">
     <meta name="author" content="">
	<title>LSH Booking System</title>
	<!-- set-up library references to css, javascript, ajax and jquery libraries -->
     <link href="CSSJS/css/bootstrap.min.css" rel="stylesheet">
     <link href="CSSJS/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script src="CSSJS/JQuery/jquery.min.js"></script>
     <script src="CSSJS/js/bootstrap.bundle.min.js"></script>
     <script src="CSSJS/js/bootstrap-datepicker.min.js"></script>
     <script>
     <!-- JavaScript function that retreives data for that date-->
     $(document).ready(function(){
    	 <!-- Called when the date selector is updated -->
     	$('#dateid').change(function(){
     		<!-- Get the current office and date -->
     		var time = $("#dateid").val();
     		var office = $("#var1").val();
     		<!-- Make a post request to dateGet.jsp for with the office and the date -->
     		$.post("dateGet.jsp",	  
		  {
		    officeName: office, 
     		date: time, 
		  },
		  function(data){
			  <!-- Input the returned html into the #timeSelector section -->
			  $("#timeSelector").html(data);
		  });
     	});
     	<!-- When one of the time selector buttons is clicked, that time is selected -->
     	$("body").on("click", "#timeSelector a", function() {
     		<!-- Get which button was clicked -->
     	    var object = $("#formCheckBox" + this.id).val();
     	    var checkbox = $("#"+this.id).find("input").attr('id');
     	    <!-- If checked, then unchecks the button. If unchecked, then checks it. This check is part of form data and is parsed with the form -->
     	    if(object == "checked") {
     	      $("#formCheckBox"+this.id).val("unchecked");
     	      $("#"+checkbox).prop("checked", false);
     	    }
     	    else {
     	      $("#formCheckBox"+this.id).val("checked");
     	      $("#"+checkbox).prop("checked", true);
     	    }
     	  });
     	<!-- When slider is updated, update seats field -->
     	$("#seatsID").click(function(){
     		var seatsVal = $("#seatsID").val();
     		$("#seatsBox").val(seatsVal);
     		$("#seatsBox2").val(seatsVal);
     		if($("#seatsBox").val() > 1) {
     			
     		}
     	});
     	<!-- When seats box is changed, update slider -->
     	$("#seatsBox").change(function(){
     		var seatsVal = $("#seatsBox").val();
     		$("#seatsID").val(seatsVal);
     		$("#seatsBox2").val(seatsVal);
     	});
     });
	 </script>
	 <script language="javascript" type="text/javascript">
   <!--disable enter key / go button iphone-->
   function stopRKey(evt) {
      var evt = (evt) ? evt : ((event) ? event : null);
      var node = (evt.target) ? evt.target : 
                               ((evt.srcElement) ? evt.srcElement : null);
      if ((evt.keyCode == 13) && (node.type=="text")) {return false;}
      if ((evt.keyCode == 13) && (node.type=="email")) {return false;}
      if ((evt.keyCode == 13) && (node.type=="tel")) {return false;}
      if ((evt.keyCode == 13) && (node.type=="number")) {return false;}
   }

   document.onkeypress = stopRKey; 
</script>
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
        <!--  Display office name and the error line -->
     <h1 class="display-4">Book Desks At <%=officeName %></h1>
     <p class="text-danger"><%= error %></p>
     <hr/>
     <div class="row">
     	<div class="col-md-5 col-sm-6">
     	<!--  Setup the form -->
	     <form action="bookingaction.jsp">
	     	<div class="form-group row">
	     		<label for="example-date-input" class="col-2 col-form-label">Date</label>
				  <div class="col-10">
				  <!--  Date selection form input -->
				    <input class="form-control" type="date" placeholder="dd/mm/yyyy" value="<%= dateFormat %>" id="dateid" name="date">
				    <!-- Form parameters used in form processing -->
				    <input type="hidden" id="var1" value="<%=officeName%>" name="officeName">
				    <input type="hidden" id="var2" value="<%=formType%>" name="logged">
				    <input type="hidden" id="var3" value="<%=office.getOfficeID()%>" name="officeID">
				    <%
				   	//for each officeSlot, create a hidden checkbox that will be used when selecting a time
				    for(int i=1; i<office.getMaxSlotsPerDay() + 1; i++) {
				    	out.println("<input type=\"hidden\" id=\"formCheckBox"+i+"\" value=\"unchecked\" name=\"timeSlotSelect"+i+"\">");
				    }
				    
				    %>
				  </div>
		  	</div>
		  	<div class="form-group row">
		  		<!--  Seats input form -->
	     		<label for="example-date-input" class="col-2 col-form-label">Seats</label>
	     		<!-- Set max slider value to the max seats of that office -->
	     		<div class="col-md-2 col-sm-12"><input class="form-control form-control-sm" max="<%= office.getSeatsAvailable() %>" type="text" placeholder="1" id="seatsBox" name="seatstemp"></div>
	     		<div class="col-md-8 col-sm-0" id="content-desktop">
				  <input type="range" class="form-control-range" min="1" max="<%= office.getSeatsAvailable() %>" value="1" id="seatsID">
				  <input type="hidden" placeholder="1" value="1" id="seatsBox2" name="seats">
				 </div>
		  	</div>
		  	<div class="form-group row">
		  	<!--  Notes section -->
	     		<label for="example-date-input" class="col-2 col-form-label">Reason for Office Visit</label>
				  <div class="col-10">
				    <textarea class="form-control" id="Textareaid" rows="3" name="notes"></textarea>
				  </div>
		  	</div>
		  	<!-- If the user is not signed in, then the account forms are inserted here -->
		  	<%= output %>
		  	<hr/>
		  	<div class=\"form-group row\">
		  	<!-- Form submit button -->
		  		<div class=\"col-sm-10\"><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Book</button></div>
  			</div>
	     </form>
	     </div>
	     <br>
	     <div class="col-md-7 col-sm-6 list-group" id="timeSelector">
	     	<br>
     	</div>
     	<div class="modal fade bd-example-modal-lg" id="exampleModal" data-backdrop="static" data-keyboard="false" tabindex="-1">
    	<div class="modal-dialog modal-dialog-centered modal-sm">
        <div class="modal-content">
        <div class="modal-header">
        	<!--  Loading screen -->
	        <h5 class="modal-title" id="exampleModalLabel">Creating Booking</h5>
            <p class="text-center">This can take up to 10 seconds</p>
	        </div>
	        <div class="modal-body">
            	<div class="d-flex justify-content-center">
			  <div class="spinner-border text-primary" role="status">
			    <span class="sr-only">Loading...</span>
			  </div>
			</div>
            </div>
        </div>
    </div>
</div>
     </div>
    </div>
   </body>
</html>
