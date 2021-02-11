/*
  	File: Booking.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: The booking class
	
	Version: 1.2.0 Release
*/
package com.server;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 *
 * @author danma
 */
public class Booking {
    
	//Variable initialisation 
	int bookingID;
    int officeid;
    int userID;
    String date;
    int timeslot;
    int numberdesks;
    int officeDataAtBookingTime;
    String status;
    User userTempAcc;

    public Booking(int officeid, int bookingID, int userID, String date, int timeslot, int numberdesks) {
    	//Constructor for Booking
        this.officeid = officeid;
        this.bookingID = bookingID;
        this.userID = userID;
        this.date = date;
        this.timeslot = timeslot;
        this.numberdesks = numberdesks;
    }

    public Booking(int officeid, int bookingID, String date, int timeslot, int numberdesks, User userTempAcc) {
    	//Constructor for Booking
        this.officeid = officeid;
        this.bookingID = bookingID;
        this.date = date;
        this.timeslot = timeslot;
        this.numberdesks = numberdesks;
        this.userTempAcc = userTempAcc;
    }
    
    public Booking(int officeid, int bookingID, int userID, String date, int timeslot, int numberdesks, String status) {
    	//Constructor for Booking
		this.bookingID = bookingID;
		this.officeid = officeid;
		this.userID = userID;
		this.date = date;
		this.timeslot = timeslot;
		this.numberdesks = numberdesks;
		this.status = status;
	}
    
    //Getters and setters
    
	public int getBookingID() {
		return bookingID;
	}
    

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getOfficeid() {
        return officeid;
    }

    public void setOfficeid(int officeid) {
        this.officeid = officeid;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    public int getNumberdesks() {
        return numberdesks;
    }

    public void setNumberdesks(int numberdesks) {
        this.numberdesks = numberdesks;
    }

    public User getUserTempAcc() {
        return userTempAcc;
    }

    public void setUserTempAcc(User userTempAcc) {
        this.userTempAcc = userTempAcc;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
}
