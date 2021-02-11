/*
  	File: csv.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Builds the office specific csv files and the master csv file. Called by the index and admin panel and returns a string.
	
	Version: 1.2.0 Release
*/
package com.server;

import java.util.*;

import com.mysql.cj.util.Util;
import com.server.Utils;
import java.lang.*;
import java.io.*;
import java.time.format.*;
import java.time.*;


public class csv {
	public static String downloadOffice(int officeID) throws Exception {
		//Method is used for generating a csv formatted string for all bookings in a specific office
		
		//Setup string builder
		StringBuilder str = new StringBuilder();
		//Query all bookings from the database
		ArrayList<Booking> bookingstemp = DataBase.queryAllBookingOffice();
		ArrayList<Booking> bookings = new ArrayList();
		//Query the office with the officeID parameter
		Office office = DataBase.queryOfficeSingleID(officeID);
		//Query all users
		ArrayList<User> users = DataBase.queryAllUserAccount();
		//Loop for all bookings and add the bookings for that office to the bookings arraylist
		for(int i=0; i<bookingstemp.size(); i++) {
			if(bookingstemp.get(i).getOfficeid() == officeID) {
				bookings.add(bookingstemp.get(i));
			}
		}
		//Append the collumn headers. This is the format the data will take
		str.append("bookingID,officeID,userID,,Office Name,Date,Time,No. Desks,,Name,Email,Phone Number,, Booking Status");
		//Perform a mergesort on the bookings
		com.server.Utils.sort(bookings);
		//Loop for all bookings and create a row for each booking
		for(int i=0; i<bookings.size(); i++) {
	    	 int userIndex = 0;
	    	 //Lop for all users and find which user matches the current booking userID
	    	 for(int j=0; j<users.size(); j++) {
	    		 if(users.get(j).getUserId() == bookings.get(i).getUserID()) {
	    			 userIndex = j;
	    			 break;
	    		 }
	    	 }
	    	//Beginning of time calculation section <----- To Do: Localise
    		//The below section gets the timeslot from the booking and converts it into a real time format
    		//Get the time the office opens and calculate  the time the office is open and how long each slot is
    		double timecalc = office.getOfficeOpens();
    		double officeOpenTime = Math.abs(12 - office.getOfficeOpens()) + Math.abs(0 - office.getOfficeCloses());
    		officeOpenTime = Math.abs(officeOpenTime);
    		double officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
    		//Calculate the current booking slot
    		officeSlotLength = officeSlotLength * (bookings.get(i).getTimeslot() - 1);
    		timecalc = timecalc + officeSlotLength;
    		//Calculate the beginning of the slot
    	    double mintemp = timecalc % 1;
    		int hour = (int)(timecalc - mintemp);
    		int min = (int)(mintemp * 60);
    		//Calculate the end interval
    		officeSlotLength = officeOpenTime / office.getMaxSlotsPerDay();
    		timecalc = office.getOfficeOpens();
    		officeSlotLength = officeSlotLength * (bookings.get(i).getTimeslot());
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
    		//Append the current row data to the string builder
			str.append("\n" + bookings.get(i).getBookingID() + "," + bookings.get(i).getOfficeid() + "," + bookings.get(i).getUserID() + ",,");
			str.append(office.getOfficeName() + "," + bookings.get(i).getDate() + "," + hour + ":" + min + "" + additional1 + " - " + hourend + ":" + minend + "" + additional2 + "," + bookings.get(i).getNumberdesks() +",,");
			str.append(users.get(userIndex).getName() + "," + users.get(userIndex).getEmail() + "," + users.get(userIndex).getPhonenum() + ",," + bookings.get(i).getStatus());
		}
		//Return a string
		return str.toString();
	}
	
	public static String downloadAll() throws Exception {
		//Method is used for generating a csv formatted string for all bookings in the system
		
		//Setup string builder
		StringBuilder str = new StringBuilder();
		//Query all bookings, offices and users from the database
		ArrayList<Booking> bookings = DataBase.queryAllBookingOffice();
		ArrayList<Office> office = DataBase.queryAllOffice();
		ArrayList<User> users = DataBase.queryAllUserAccount();
		
		//Append the collumn headers. This is the format the data will take
		str.append("bookingID,officeID,userID,,Office Name,Date,Time,No. Desks,,Name,Email,Phone Number,, Booking Status");
		//Perform a merge sort on bookings
		com.server.Utils.sort(bookings);
		//Loop for all bookings and append a row for each booking
		for(int i=0; i<bookings.size(); i++) {
	    	 int userIndex = 0;
	    	 //Loop for all users and find the user that matches the current booking userID
	    	 for(int j=0; j<users.size(); j++) {
	    		 if(users.get(j).getUserId() == bookings.get(i).getUserID()) {
	    			 userIndex = j;
	    			 break;
	    		 }
	    	 }
	    	 int officeIndex = 0;
	    	 //Loop for all offices and find which office matches this bookings officeID
	    	 for(int j=0; j<office.size(); j++) {
	    		 if(office.get(j).getOfficeID() == bookings.get(i).getOfficeid()) {
	    			 officeIndex = j;
	    			 break;
	    		 }
	    	 }
	    	//Beginning of time calculation section <----- To Do: Localise
    		//The below section gets the timeslot from the booking and converts it into a real time format
    		//Get the time the office opens and calculate  the time the office is open and how long each slot is
    		double timecalc = office.get(officeIndex).getOfficeOpens();
    		double officeOpenTime = Math.abs(12 - office.get(officeIndex).getOfficeOpens()) + Math.abs(0 - office.get(officeIndex).getOfficeCloses());
    		officeOpenTime = Math.abs(officeOpenTime);
    		double officeSlotLength = officeOpenTime / office.get(officeIndex).getMaxSlotsPerDay();
    		//Calculate the current booking slot
    		officeSlotLength = officeSlotLength * (bookings.get(i).getTimeslot() - 1);
    		timecalc = timecalc + officeSlotLength;
    		//Calculate the beginning of the slot
    	    double mintemp = timecalc % 1;
    		int hour = (int)(timecalc - mintemp);
    		int min = (int)(mintemp * 60);
    		//Calculate the end interval
    		officeSlotLength = officeOpenTime / office.get(officeIndex).getMaxSlotsPerDay();
    		timecalc = office.get(officeIndex).getOfficeOpens();
    		officeSlotLength = officeSlotLength * (bookings.get(i).getTimeslot());
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
    		//Append the current row data to the string builder
			str.append("\n" + bookings.get(i).getBookingID() + "," + bookings.get(i).getOfficeid() + "," + bookings.get(i).getUserID() + ",,");
			str.append(office.get(officeIndex).getOfficeName() + "," + bookings.get(i).getDate() + "," + hour + ":" + min + "" + additional1 + " - " + hourend + ":" + minend + "" + additional2 + "," + bookings.get(i).getNumberdesks() +",,");
			str.append(users.get(userIndex).getName() + "," + users.get(userIndex).getEmail() + "," + users.get(userIndex).getPhonenum() + ",," + bookings.get(i).getStatus());
		}
		//Return a string
		return str.toString();
	}
}
