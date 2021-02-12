/*
  	File: loadData.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Creates html elements to display in the homepage and booking page. Does the following:
	- Creates list of offices and links to each booking page
	- Creates list of admin panel links for each office
	- Creates the time selection function on the booking screen
	
	Version: 1.2.0 Release
*/

package com.server;

import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 *
 * @author danma
 */
public class loadData {
    public static String queryOffice(String admin) {
    	//Returns the office buttons that redirect the user to the booking page
    	String append = "";
        ArrayList<Office>officeList = new ArrayList();
        //Query all offices in the database
        try {
            officeList = DataBase.queryAllOffice();   
        } catch (Exception e) {
            System.out.println(e);
        }
        //If the office list is empty, then there were none in the database or there was a problem with connection. Return an error message
        if (officeList == null || officeList.size() == 0) {
            return "<a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-primary\">No Offices. Possible Database error</a>";
        }
        //Initialise a string builder for creating the html string to return 
        StringBuilder str = new StringBuilder();
        //Loop for all offices and append a button to the html string that redirects the user to the covid check before further to the booking screen.
        for (int i = 0; i < officeList.size(); i++) {
        	//If the admin is true then also return a button that redirects the user to the admin panel for that office
        	if(admin.equals("true")) {
        		append = "<a class=\"btn btn-danger\" href=\"adminpanel.jsp?office="+officeList.get(i).getOfficeName()+"\">(Admin) View bookings for "+officeList.get(i).getOfficeName()+"</a>";
        	}
        	//Append a button to redirect the user to the covid symptom check. Displays the officeName and the seats available (capacity)
            str.append("<a href=\"covidcheck.jsp?office="+ officeList.get(i).getOfficeName() +"\" class=\"list-group-item list-group-item-action list-group-item-primary\">"
                    + officeList.get(i).getOfficeName() + 
                    "&nbsp; &nbsp; Capacity: " + officeList.get(i).getSeatsAvailable() + "</a>" + append);
            		
        }
        //Return the string containing the html
        String officeHTML = str.toString();
        return officeHTML;
    }
   
    public static String timeSelection(String officeName, String date) throws Exception, ClassNotFoundException {
    	//Returns the time selection button panel to the booking screen with the number of seats available at that timeslot on a given date
    	System.out.println(date);
    	//Query all bookings in the database
    	ArrayList<com.server.Booking> bookings = DataBase.queryAllBookingOffice();
    	//Query the current office that the user is trying to book with. Searches with officeName
    	com.server.Office office = com.server.DataBase.queryOfficeSingleName(officeName);
    	
    	ArrayList<Booking> officeBooking = new ArrayList();
    	//Create new string builder to append html strings
    	StringBuilder str = new StringBuilder();
    	//Get the time the office opens and calculate  the time the office is open and how long each slot is
    	double officeOpenTime = Math.abs(12 - office.getOfficeOpens()) + Math.abs(0 - office.getOfficeCloses());
		officeOpenTime = Math.abs(officeOpenTime);
    	double officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
    	double time = office.getOfficeOpens();
    	System.out.print("slot: " + officeSlotLength + " time: " + officeOpenTime);
    	//Calculate office slot times
    	int officeSlot = (int)officeSlotLength;
    	int officeSlotMin = (int)((officeSlotLength % 1) * 60);
    	for(int i = 0; i < bookings.size(); i++) {
    		if	(bookings.get(i).getOfficeid() == office.getOfficeID() && bookings.get(i).getDate().contentEquals(date)) {
    			officeBooking.add(bookings.get(i));
    		}
    	}
    	//Is executed if there are no bookings at this time for this date.
    	if(officeBooking.size() == 0) {
    		//Calculate the start time
    		double mintemp = time % 1;
    		int hour = (int)(time - mintemp);
    		int min = (int)(mintemp * 60);
    		for (int i = 1; i < office.getMaxSlotsPerDay() + 1; i++) {
    			//Calculate the end interval
				time = time + officeSlotLength;	
				//calculate the end time
				double mincurrenttemp = time % 1;
    			  int hourcurrent = (int)(time - mincurrenttemp);
    			  int mincurrent = (int)(mincurrenttemp * 60);
    			//Add any additional zeros if the formatting is incorrect. E.g. 14:0 --> 14:00
    			  String additional = "";
    			  String additional2 = "";
    			  if(min == 0) { additional = "0"; }
    			  if(mincurrent == 0) { additional2 = "0"; }
    			  //Append a list item with the current start time and end times. Also contains A progress bar showing how full the office is (empty in this case)
    			str.append("<a id="+i+" class=\"list-group-item list-group-item-action list-group-item-success \"> &nbsp; <input type=\"checkbox\" class=\"form-check-input\" value=\"\" id=\"timeslotCheckBox"+(i +1)+"\">&nbsp;   "+ Math.abs(hour) +":"+ Math.abs(min) + additional + " - "+ Math.abs(hourcurrent) +":"+ Math.abs(mincurrent) + additional2 +": Available &nbsp | 0/"+office.getSeatsAvailable()+" Seats Taken<div class=\"progress\">\r\n" + 
    					"  <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"0\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\r\n" + 
    					"</div></a>");
    			min = mincurrent;
    			hour = hourcurrent;
    		}
    		return str.toString();
    	}
    	//Calculate the start time
    	double mintemp = time % 1;
		int hour = (int)(time - mintemp);
		int min = (int)(mintemp * 60);
    	for(int i = 0; i < office.getMaxSlotsPerDay(); i++) {
    		int officeBookingSize = 0;
    		for(int j = 0; j < officeBooking.size(); j++) {
    			if(officeBooking.get(j).getTimeslot() == i + 1) {
    				officeBookingSize = officeBookingSize + officeBooking.get(j).getNumberdesks();
    	  		} 
    		}//Calculate the end interval
    		time = time + officeSlotLength;	
    		//calculate the end time
			double mincurrenttemp = time % 1;
			  int hourcurrent = (int)(time - mincurrenttemp);
			  int mincurrent = (int)(mincurrenttemp * 60);
			//Add any additional zeros if the formatting is incorrect. E.g. 14:0 --> 14:00
  			String additional = "";
  			String additional2 = "";
  			if(min == 0) { additional = "0"; }
  			if(mincurrent == 0) { additional2 = "0"; }
  			String color = "";
  			//Set the colour of the progress bar to red if 90% full, orange if 50% full, green if less than 50% full.
  			if(officeBookingSize > (0.9 * office.getSeatsAvailable())) {
  				color = "bg-danger";
  			} else if(officeBookingSize > (0.5 * office.getSeatsAvailable())) {
  				color = "bg-warning";
  			} else if(officeBookingSize > 0) {
  				color = "bg-success";
  			}
  			System.out.println(officeBookingSize + " " + office.getSeatsAvailable());
  			//Calculate the width of the progress bar completed
  			int barWidth = officeBookingSize * 100 / office.getSeatsAvailable();
  			System.out.println(barWidth);
  			//If there are seats available, then append a list item with the current start time and end times. Also contains A progress bar showing how full the office is
	  		if(officeBookingSize < office.getSeatsAvailable()) {
	  			
	  			str.append("<a id="+(i+1)+" class=\"list-group-item list-group-item-action list-group-item-success \"> &nbsp; <input type=\"checkbox\" class=\"form-check-input\" value=\"\" id=\"timeslotCheckBox"+(i +1)+"\">&nbsp;   "+ Math.abs(hour) +":"
	  			+ Math.abs(min) + additional + " - "+ Math.abs(hourcurrent) +":"
				+ Math.abs(mincurrent) + additional2 + ": Available   &nbsp | "+ officeBookingSize + "/" + office.getSeatsAvailable() + " Seats taken"
				+ "<div class=\"progress\"><div class=\"progress-bar " + color + "\" role=\"progressbar\" style=\"width: "+barWidth+"%\" aria-valuenow=\"" + officeBookingSize + "\" aria-valuemin=\"0\" aria-valuemax=\"" + office.getSeatsAvailable() + "\"></div></div></a>");
	  		} else {
	  			str.append("<a class=\"list-group-item list-group-item-action list-group-item-danger\">"+ Math.abs(hour) +":"+ Math.abs(min) + additional + " - "+ hourcurrent +":"+ mincurrent + additional2 +": Fully Booked</a>");
	  		}
	  		min = mincurrent;
			hour = hourcurrent;
    	}
    	return str.toString();
    }
    
    /*
    public static String queryBookings(int noWeeks) throws Exception {
    	//
    	ArrayList<com.server.Booking> bookings = DataBase.queryAllBookingOffice();
    	StringBuilder str = new StringBuilder();
    	Date date = new Date();
    	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	int day = localDate.getDayOfMonth();
    	DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    	int weekday = dayOfWeek.getValue();
    	for (int i=weekday; i>1; i--) {
    		str.append("<div class=\"col-6 col-sm-1 bg-dark\">"+ (day - (i-1)) +"</div>");
    	}
    	for (int i=0; i<noWeeks; i++) {
    		for (int j = i; j < 6; j++) {
    			String color = null;
				for(int k = 0; k < bookings.size(); k++) {
	    			try {
	    				if(!(bookings.get(k) == null)) {
			    			String[] arrOfStr = bookings.get(k).getDate().split("/"); 
			    			int bookingday = Integer.parseInt(arrOfStr[0]);
			    			System.out.println(bookings.get(k).getDate());
			    			if (bookingday == day) {
			    				color = "bg-danger";
			    			} else {
			    				color = "bg-light";
			    			}
						}else {
		    				color = "bg-light";
		    			}
	    			} catch (Exception e) {}
				}
	            str.append("<div class=\"col-6 col-sm-1 "+ color +"\">"+ day +"</div>");
	            day = day + 1;
	        }
    		str.append("<div class=\"w-100\"></div>");
    	}
    	return str.toString();
    }
    */
    
}
