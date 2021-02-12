<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, com.server.*, java.util.regex.Pattern, java.util.regex.Matcher" %>
<%--
	File: bookingaction.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Handles the booking form data. Creates booking in database and sends confirmation emails. 
	
	Version: 1.2.0 Release
 --%>
<% 
	//This checks if the user has visited the site before in this session. i.e. The user is not logged in
	//If the session is new, then the below attributes are setup
    if(session.isNew()) {
        session.setAttribute("loggedin", "false");
    }
	//Sets up boolean that if set to false, stops the program from advancing as break can not be used with JSP
	boolean allowAdvance = true;
	//Get the parameters sent from the booking form
    String officeName = request.getParameter("officeName");
    String officeIDtemp = request.getParameter("officeID");
    String date = request.getParameter("date");
    String notes = request.getParameter("notes");
    String seatstemp = request.getParameter("seats");
    //Get if the user was logged in or not when booking
    String formType = request.getParameter("logged");
    int userID = 0;
    String email = "";
    String name = "";
    String phonenumtemp = "";
    long phonenum = 0;
    String error = "";
    //If the number of seats is less than 0 or 0 then return an invalid number error
    if(Integer.parseInt(seatstemp) < 0 || Integer.parseInt(seatstemp) == 0) {
    	response.sendRedirect("booking.jsp?office="+officeName+"&error=negseats");
    	allowAdvance = false;
    }
    //If the user was not logged in then use custom user information provided in the form
    if(!(formType.equals("logged")) && allowAdvance == true) {
    	//Gets the parameters for the user information
    	email = request.getParameter("email");
    	name = request.getParameter("name");
    	phonenumtemp = request.getParameter("phonenum");
    	//A regex pattern is used to check if the users email matches to an @lsh.co.uk or an @lsh.com email
    	Pattern regExPattern = Pattern.compile("^[\\w-\\._\\+%]+@(lsh.co.uk|lsh.com)");
        Matcher matcher = regExPattern.matcher(email);
        //If no user information was provided then return an error asking for user information
        if(name.isEmpty() || email.isEmpty() || phonenumtemp.isEmpty()) {
        	error = "nodetails";
        	allowAdvance = false;
        	phonenumtemp = "0";
        }
        //If the email does not match the regex then return an error
        if(!(matcher.matches())) {
        	error = "email";
        	allowAdvance = false;
        }
        //parse phonenumber as a long
    	phonenum = Long.parseLong(phonenumtemp);
        //Append "tempuser:" to the front of the email. This indicates that it is a temporary account
    	String email2 = "tempuser:" + email;
        //Create a new user account in the database with the above information
    	User x = new User(name, email2, phonenum);
    	int returnType = 0;
    	if(allowAdvance == true) {
    		returnType = DataBase.createTempUserAccount(x);
    	}
    	userID = returnType;
    } else {
    	//Get these session attributes
    	userID = (int)session.getAttribute("userID");
    	name = (String)session.getAttribute("username");
    	email = (String)session.getAttribute("email");
    }
    if(allowAdvance == false ) {
    	response.sendRedirect("booking.jsp?office=" + officeName + "&error="+error);
    }
    //Query the office from the databases with the officeID
	int officeID = Integer.parseInt(officeIDtemp);
    Office office = DataBase.queryOfficeSingleID(officeID);
    ArrayList<Integer> time = new ArrayList();
    //For all office slots, get the checked time slots in the booking form and add them to an arraylist
    try {
    for(int i=1; i<office.getMaxSlotsPerDay() + 1; i++) {
    	
    	String temp = request.getParameter("timeSlotSelect"+i);
    	if(temp.equals("checked")) {
    		time.add(i);
    	}
    	
    }
    //If exception then return a no time slot selected error
    } catch (Exception e) {
    	response.sendRedirect("booking.jsp?office="+officeName+"&error=notimeslot");
    	allowAdvance = false;
    }
    //If the time array has no elements, return a no time slot selected error
    if(time.size() == 0) {
    	response.sendRedirect("booking.jsp?office="+officeName+"&error=notimeslot");
    	allowAdvance = false;
    }
    int seats = Integer.parseInt(seatstemp);
    ArrayList<Booking> bookings = new ArrayList();
    //For all the size of the time array, add a new booking to the bookings array list with all of the form data
    //This allows the user to select multiple timeslots in the booking form
    for(int i=0; i<time.size(); i++) {
    	
   		Booking y = new Booking(officeID, 0, userID,  date, time.get(i), seats);
   		
   		bookings.add(y);
    }
    //Query the database for all bookings
    ArrayList<com.server.Booking> bookingstemp = com.server.DataBase.queryAllBookingOffice();
    int bookingsSize = 0;
    if(allowAdvance == true) {
    	//loops through the all bookings and gets the bookings on that date and timeslot
    for(int i=0; i<bookingstemp.size(); i++) {
   	 if(bookingstemp.get(i).getDate().equals(date) && bookingstemp.get(i).getTimeslot() == time.get(0)) {
   		 bookingsSize = bookingstemp.get(i).getNumberdesks();
   	 }
    }
    	//checks if the current quantity of seats plus the new seats to book goes over the office capacity
    	//If it does, return a booking exceeded capacity error
    if((seats + bookingsSize) > office.getSeatsAvailable()) {
    	response.sendRedirect("booking.jsp?office="+officeName+"&error=bookingexceedcap");
    	allowAdvance = false;
    }
    }
    try {
   	if(allowAdvance == true) {
   	//Create the booking in the database
    int id[] = DataBase.createBooking(bookings);
    StringBuilder str = new StringBuilder();
    //Append all ids to a string
    for(int i=0; i<id.length; i++) {
    	str.append(""+id[i]);
    }
  	//Beginning of time calculation section <----- To Do: Localize
	//The below section gets the timeslot from the booking and converts it into a real time format
	//Get the time the office opens and calculate  the time the office is open and how long each slot is
	double timecalc = office.getOfficeOpens();
	double officeOpenTime = Math.abs(12 - office.getOfficeOpens()) + Math.abs(0 - office.getOfficeCloses());
	officeOpenTime = Math.abs(officeOpenTime);
	double officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
	//Calculate the current booking slot
	officeSlotLength = officeSlotLength * (time.get(0)-1);
	timecalc = timecalc + officeSlotLength;
	//Calculate the beginning of the slot
    double mintemp = timecalc % 1;
	int hour = (int)(timecalc - mintemp);
	int min = (int)(mintemp * 60);
	//Calculate the end interval
	officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
	timecalc = office.getOfficeOpens();
	officeSlotLength = officeSlotLength * ((time.size()-1));
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
    
	//If the user is logged in, then display basic account detials at the base of the footer. Else, display the booking user account data
    String output = "<p style=\"Margin-top: 0;Margin-bottom: 0;\">Logged in with account: "+session.getAttribute("username")+"</p><p style=\"Margin-top: 0;Margin-bottom: 0;\">Email: " + session.getAttribute("email") + "</p><p style=\"Margin-top: 0;Margin-bottom: 0;\">Phone Number: 0" + session.getAttribute("phonenum") + "</p>";
    if(!(formType.equals("logged"))) {
    	output = "<p style=\"Margin-top: 0;Margin-bottom: 0;\">Email: " + email + "</p><p style=\"Margin-top: 0;Margin-bottom: 0;\">Name: " + name + "</p><p style=\"Margin-top: 0;Margin-bottom: 0;\">Phone Number: 0" + phonenum + "</p>";
    }
    
    //Retreive the email message
    //This gets the simple type with no HTML styling to the email
 	String message = EmailStrings.booking("simple", office.getOfficeName(), "" + seats, "" + hour, "" + min, additional1, ""+ hourend, "" + minend, additional2, notes, output);
 	
  	try {
  		//Sends an email to the provided email / the users email along with the message
    com.server.Emailer.sendEmail(email, "Booking Completed", message);
    
  	} catch (Exception e) {
  		
  	}
   	}
   	//Redirect the user to the bookingcompleted page
    response.sendRedirect("bookingcompleted.jsp");
    } catch (Exception e) {
   	
    }

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirecting</title>
</head>
<body>
<p>Redirecting please wait</p>
</body>
</html>