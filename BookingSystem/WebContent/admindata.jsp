<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, com.server.*, java.time.LocalDate, java.time.format.DateTimeFormatter, java.util.Date" %>
<%--
	File: admindata.jsp
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: A handling page for processing the following admin requests:
	- Approve Booking
	- Deny Booking
	- Delete Booking
	
	Version: 1.2.0 Release
 --%>
<%
	//Get parameters for the bookingID and the type (approve, deny, delete)
	String bookingIDtemp = request.getParameter("bookingID");
	String action = request.getParameter("action");
	//Parse the bookingID as an integer
	int bookingID = Integer.parseInt(bookingIDtemp);
	//Retrieve all bookings from the database
	ArrayList<Booking> bookings = DataBase.queryAllBookingOffice();
	//Initialize booking variables
	int userID = 0;
	String bookingDate = "";
	int bookingTime = 0;
	int bookingOffice = 0;
	//loop for all bookings and store the values for userID, bookingDate, bookingTime, bookingOffice for the booking referenced with bookingID
	for(int i=0; i<bookings.size(); i++) {
		if(bookings.get(i).getBookingID() == bookingID) {
			userID = bookings.get(i).getUserID();
			bookingDate = bookings.get(i).getDate();
			bookingTime = bookings.get(i).getTimeslot();
			bookingOffice = bookings.get(i).getOfficeid();
			break;
		}
	}
	//Send a query for the office corresponding to that booking
	Office office = DataBase.queryOfficeSingleID(bookingOffice);
	
	//Beginning of time calculation section <----- To Do: Localize
	//The below section gets the timeslot from the booking and converts it into a real time format
	//Get the time the office opens and calculate  the time the office is open and how long each slot is
	double timecalc = office.getOfficeOpens();
	double officeOpenTime = Math.abs(12 - office.getOfficeOpens()) + Math.abs(0 - office.getOfficeCloses());
	officeOpenTime = Math.abs(officeOpenTime);
	double officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
	//Calculate the current booking slot
	officeSlotLength = officeSlotLength * (bookingTime - 1);
	timecalc = timecalc + officeSlotLength;
	//Calculate the beginning of the slot
    double mintemp = timecalc % 1;
	int hour = (int)(timecalc - mintemp);
	int min = (int)(mintemp * 60);
	//Calculate the end interval
	officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
	timecalc = office.getOfficeOpens();
	officeSlotLength = officeSlotLength * (bookingTime);
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
	
	//Create a string with the start time and end time of the current booking
	String displayTime = hour+":"+min+""+additional1+" - "+hourend+":"+minend+""+additional2;
	//Query the database for the user account with the userID from the booking
	User user = DataBase.queryUserAccountID(userID);
	//Retrieve the string to use for the email message containing the officeName, displayTime, and the bookingDate
	//The email message will be simple and will not contain any HTML styling
	String message = EmailStrings.adminData("simple", office.getOfficeName(), displayTime, bookingDate);
	//Checks the action (type) parameter for what operation to perform
	if(action.equals("Approve")) {
		//Updates the booking in the database to approved
		com.server.DataBase.updateBookingStatus(bookingID, "");
	} else if(action.equals("Delete") || action.equals("Deny")) {
		//Gets the current date and formats it to the format: "yyyy-mm-dd"
		LocalDate datetemp = java.time.LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MMM-dd");
		String date = formatter.format(datetemp);
		System.out.println(date);
		//Gets the email from the user
		String email = user.getEmail();
		//Checks if the account is a temporary account and removes the "tempory:" tag so it can be used as a valid email
		if(email.contains("tempuser:")) {
			email = email.replace("tempuser:", "");
			System.out.println("true "+ email);
		}
		//Checks if the bookingDate is in the present before emailing the user
		if(bookingDate.compareTo(date) < 0) {
			//Send the email to the users email with subject "Booking Denied" and the message
			com.server.Emailer.sendEmail(email, "Booking Denied", message);
			//Delete the booking from the database
			com.server.DataBase.deleteBooking(bookingID);
		} else if(bookingDate.compareTo(date) > 0) {
			//If the booking is in the past, dont send an email and just delete the booking from the database
			com.server.DataBase.deleteBooking(bookingID);
		}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
data
</body>
</html>