/*
  	File: Office.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Office class
	
	Version: 1.2.0 Release
*/
package com.server;



/**
 *
 * @author danma
 */
public class Office {
	//Class for the office class.
	//Setup variables
    int officeID;
    String officeName;
    int seatsAvailable;
    int officeOpens;
    int officeCloses;
    int maxSlotsPerDay;
    public Office(int officeID, String officeName, int seatsAvailable, int officeOpens, int officeCloses, int maxSlotsPerDay) {
    	//Constructor for office class
        this.officeID = officeID;
        this.officeName = officeName;
        this.seatsAvailable = seatsAvailable;
        this.officeOpens = officeOpens;
        this.officeCloses = officeCloses;
        this.maxSlotsPerDay = maxSlotsPerDay;
    }
    public int getOfficeID() {
        return officeID;
    }

    public void setOfficeID(int officeID) {
        this.officeID = officeID;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getOfficeOpens() {
        return officeOpens;
    }

    public void setOfficeOpens(int officeOpens) {
        this.officeOpens = officeOpens;
    }

    public int getOfficeCloses() {
        return officeCloses;
    }

    public void setOfficeCloses(int officeCloses) {
        this.officeCloses = officeCloses;
    }

    public int getMaxSlotsPerDay() {
        return maxSlotsPerDay;
    }

    public void setMaxSlotsPerDay(int maxSlotsPerDay) {
        this.maxSlotsPerDay = maxSlotsPerDay;
    }
   
    
}
