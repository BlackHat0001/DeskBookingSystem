/*
  	File: DataBase.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Handles database query and update requests. 
	
	Version: 1.2.0 Release
*/
package com.server;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author danma
 */
public class DataBase {
    //Store the database connection URL, username and passowrd
    public static String databaseURL = "jdbc:mysql://localhost:3306/lshdata";
    public static String databaseUser = "LSH";
    public static String databasePass = "LSHAdmin1221";

    public static String query = "SELECT VERSION()";
    //Define the result set
    public static ResultSet rs;
    //Define the connection
    public static Connection connection;
    //Define the statement
    public static Statement statement;
    
    public static String createUserAccount (User x) throws ClassNotFoundException {
    	//Creates a user account in the database for a given User x
    	Class.forName("com.mysql.jdbc.Driver");
        try {
        	//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed: " + ex);
            return "error";
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            //Set the result set to the last element
            rs.last();
            //Store the size of the current table from the position of the last row
            int size = rs.getRow();
            //Set the userID as the current row + 1
            x.setUserId(rs.getRow() + 1);
            //Go to the first row
            rs.first();
            //Loop for all users in the table and find if any of the emails already exist as a temp account
            //If they do exist, delete them and store the userID as the current row
            //This replaces tempuser accounts with proper accounts when made
            for(int i = 0; i<size; i++) {
            	if(rs.getString("email").contains("tempuser:") && rs.getString("email").contains(x.getEmail())) {
            		x.setUserId(rs.getInt("userId"));
            		rs.deleteRow();
            		i = size;
            	}
            	rs.next();
            }
            //Move to the next place to insert a row
            rs.moveToInsertRow();
            //Update the collums with user data
            rs.updateInt("userId", x.getUserId());
            rs.updateString("email", x.getEmail());
            rs.updateString("password", x.getEncryptedPass());
            rs.updateString("name", x.getName());
            rs.updateLong("phonenum", x.getPhonenum());
            //Insert the row
            rs.insertRow();
        	
            System.out.println("Data Write Success");
            //Return success string
            return "accCreateComplete";
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
        return null;
    }
    public static int createTempUserAccount (User x) throws ClassNotFoundException {
    	//Creates a temporary user account for a given User x (Legacy)
    	Class.forName("com.mysql.jdbc.Driver");
        try {
        	//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed: " + ex);
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            //Go to the last row
            rs.last();
            System.out.println("triggered");
            //Set the userID to update as the last row id
            x.setUserId(rs.getRow() + 1);
            int userId = rs.getRow() + 1;
            //Go to the first row
            rs.first();
            boolean exists = false;
            //Loop for all users and find duplicate accounts
            for(int i = 0; i<userId; i++) {
            	if(rs.next() == false) {
            		System.out.print("breaking");
            		break;
            	}
            	//If account already exists then dont create new account
            	if(rs.getString("email").contains("tempuser:") && rs.getString("email").equals(x.getEmail())) {
            		userId = rs.getRow();
            		exists = true;
            		System.out.println(exists);
            		i = userId;
            	}
            	rs.next();
            }
            //Insert data into collums
            if(exists == false) {
	            rs.moveToInsertRow();
	            rs.updateInt("userId", userId);
	            rs.updateString("email", x.getEmail());
	            rs.updateString("name", x.getName());
	            rs.updateLong("phonenum", x.getPhonenum());
	            rs.insertRow();
            }
            

            System.out.println("Data Write Success");
            
            return userId;
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
        return 0;
    }
    
    public static User queryUserAccount(String email) throws RuntimeException, ClassNotFoundException {
    	//Gets user data for a specific user using their email. This feature is used when logging in
    	Class.forName("com.mysql.jdbc.Driver");
        try {
        	//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            
            //Get the size of the table
            rs.last();
            int size = rs.getRow();
            rs.first();
            //Loop for all elements in the and get the user information for a provided email
            for (int i = 1; i <= size; i++) {
                
                String userRetreive = rs.getString("email");
                //If the current result set users email equals the one provided in the parameter 
                if (email.equals(userRetreive)) {
                	//Get information and return in a User object
                    System.out.println("Found User");
                    int currentID = rs.getInt("userId");
                    String name = rs.getString("name");
                    String password = rs.getString("password");
                    long phonenum = rs.getLong("phonenum");
                    String Admintemp = rs.getString("admin");
                    boolean isAdmin = false;
                    if (Admintemp.equals("true")) {
                        isAdmin = true;
                    } else {
                        isAdmin = false;
                    }
                    User insert = new User(name, email, password, phonenum, currentID, isAdmin);
                    return insert;
                }
                //If not found move the result set down a line
                rs.next();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static User queryUserAccountID(int ID) throws RuntimeException, ClassNotFoundException {
    	//Get user data for a specific user account from the users ID
    	Class.forName("com.mysql.jdbc.Driver");
        try {
        	//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            //Get the size of the table
            rs.last();
            int size = rs.getRow();
            rs.first();
            //Loop for all elements in the table and if the current result set ID equals the provided, return the user data
            for (int i = 1; i <= size; i++) {
                int currentID = rs.getInt("userId");
                //If current userID equals the one in the parameter
                if (currentID == ID) {
                	//Get data and return in a User Object
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    String password = rs.getString("password");
                    long phonenum = rs.getLong("phonenum");
                    String Admintemp = rs.getString("admin");
                    boolean isAdmin = false;
                    if (Admintemp.equals("true")) {
                        isAdmin = true;
                    } else {
                        isAdmin = false;
                    }
                    User insert = new User(name, email, password, phonenum, currentID, isAdmin);
                    return insert;
                }
                //If not found, move the result set to the next line
                rs.next();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static ArrayList<User> queryAllUserAccount() throws RuntimeException, ClassNotFoundException {
    	//Returns an arraylist of all user accounts in the user table. Useful for when displaying tables of booking data
    	Class.forName("com.mysql.jdbc.Driver");
        try {	
        	//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            //Get the size of the table
            rs.last();
            int size = rs.getRow();
            rs.first();
            ArrayList<User> users = new ArrayList();
            //Loop for all elements in the users table, get the data and add it to a Users arraylist
            for (int i = 1; i <= size; i++) {
                int currentID = rs.getInt("userId");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String password = rs.getString("password");
                long phonenum = rs.getLong("phonenum");
                String Admintemp = rs.getString("admin");
                boolean isAdmin = false;
                //Parse admin as a string
                if (Admintemp.equals("true")) {
                    isAdmin = true;
                } else {
                    isAdmin = false;
                }
                //Add to a user array list and add to arraylist
                User insert = new User(name, email, password, phonenum, currentID, isAdmin);
                users.add(insert);
                //Move result set to next line
                rs.next();
            }
            //Return arraylist of users
            return users;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static ArrayList<Office> queryAllOffice() throws ClassNotFoundException {
    	//used for querying all offices in the database
    	Class.forName("com.mysql.jdbc.Driver");
    	try {
    		//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM office");
            //Get the size of the current table
            rs.last();
            int size = rs.getRow();
            rs.first();
            
            ArrayList<Office> officeList = new ArrayList();
            //Loop for all elements in the office list and add the data for each row to an array list
            for (int i = 1; i <= size; i++) {
            	//Get data from the row
                int officeID = rs.getInt("officeID");
                String officeName = rs.getString("officeName");
                int officeseats = rs.getInt("seatsAvailable");
                int officeOpens = rs.getInt("officeOpen");
                int officeClose = rs.getInt("officeClose");
                int maxSlotsPerDay = rs.getInt("officeSlots");
                //Create office object
                Office x = new Office(officeID, officeName, officeseats, officeOpens, officeClose, maxSlotsPerDay);
                //Add object to office arraylist
                officeList.add(x);
                //Move the result set to the next line
                rs.next();
            }
            //return the arraylist
            return officeList;

        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    public static Office queryOfficeSingleName(String name) throws ClassNotFoundException {
    	//Query the data for a specific office by its name
    	Class.forName("com.mysql.jdbc.Driver");
        try {
        	//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM office");
            //Get the current size of the table
            rs.last();
            int size = rs.getRow();
            rs.first();
            //Loop for all elements in office table and if it comes across the office with the name that matches the provided name then return the data
            for (int i = 1; i <= size; i++) {
            	//Get current officename
                String officeName = rs.getString("officeName");
                //Does current result set office name match given parameter
                if (officeName.equals(name)) {
                    int officeID = rs.getInt("officeID");
                    int officeseats = rs.getInt("seatsAvailable");
                    int officeOpens = rs.getInt("officeOpen");
                    int officeClose = rs.getInt("officeClose");
                    int maxSlotsPerDay = rs.getInt("officeSlots");
                    Office x = new Office(officeID, officeName, officeseats, officeOpens, officeClose, maxSlotsPerDay);
                    //Return object office
                    return x;
                }
                //If not found then move the result set to the next line
                rs.next();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    public static Office queryOfficeSingleID(int id) throws ClassNotFoundException {
    	//Query a specific office by the officeID and return type office
    	Class.forName("com.mysql.jdbc.Driver");
        try {
        	//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
        try {
        	//Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM office");
            //Get the size of the table
            rs.last();
            int size = rs.getRow();
            rs.first();
            //Loop for all elements in the office table and if the officeID matches given ID then return that data
            for (int i = 1; i <= size; i++) {
                int officeID = rs.getInt("officeID");
                if (officeID == id) {
                	//if current result set id equals the given id parameter then get the office data and return a Office object
                    String officeName = rs.getString("officeName");
                    int officeseats = rs.getInt("seatsAvailable");
                    int officeOpens = rs.getInt("officeOpen");
                    int officeClose = rs.getInt("officeClose");
                    int maxSlotsPerDay = rs.getInt("officeSlots");
                    Office x = new Office(officeID, officeName, officeseats, officeOpens, officeClose, maxSlotsPerDay);
                    //return office object
                    return x;
                }
                //move result set to the next line
                rs.next();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    public static String createOffice(Office office) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
		return null;
    }
    public static String deleteOffice(int id) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
		return null;
    }
    public static ArrayList<Booking> queryAllBookingOffice() throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try {
    		//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
    	try {
    		//Create a prepared statement
    		PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    		//Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM booking");

            rs.last();
            int size = rs.getRow();
            rs.first();

            ArrayList<Booking> bookingList = new ArrayList();

            for (int i = 1; i <= size; i++) {
                int bookingID = rs.getInt("bookingID");
                int officeID = rs.getInt("officeID");
                int userID = rs.getInt("userID");
                String date = rs.getString("date");
                int time = rs.getInt("timeslot");
                int numberdesks = rs.getInt("numberdesks");
                String status = rs.getString("bookingStatus");
                Booking x = new Booking(officeID, bookingID, userID, date, time, numberdesks, status);
                bookingList.add(x);
                rs.next();
            }
            return bookingList;
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
    }
    
    public static int[] createBooking(ArrayList<Booking> booking) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try {
    		//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
    	try {
    		//Create a prepared statement
    		PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    		//Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM booking");
            int id[] = new int[booking.size()];
            rs.last();
        	int bookingID = rs.getRow() + 1;
            for (int i = 0; i < booking.size(); i++) {
            	bookingID = rs.getRow() + i;
            	rs.moveToInsertRow();
                rs.updateInt("officeID", booking.get(i).getOfficeid());
                rs.updateInt("userID", booking.get(i).getUserID());
                rs.updateString("date", booking.get(i).getDate());
                rs.updateInt("timeslot", booking.get(i).getTimeslot());
                rs.updateInt("numberdesks", booking.get(i).getNumberdesks());
                rs.insertRow();
            }
            System.out.println("success");
            return id;
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
    }
    
    public static void editUserAccount(String emailToUpdate, String password, String name, long phonenum, boolean updatePassword, boolean updateName, boolean updatePhonenum) throws Exception {
    	Class.forName("com.mysql.jdbc.Driver");
    	try {
    		//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
    	try {
    		//Create a prepared statement
    		PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    		//Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            
            rs.last();
            int size = rs.getRow();
            rs.first();
            
            for (int i = 1; i <= size; i++) {
                
                String userRetreive = rs.getString("email");
                int currentID = rs.getInt("userId");
                if (emailToUpdate.equals(userRetreive)) {
                    if(updatePassword == true) {
                    	String passwordnew = passwordEncryption.hasher(password);
                    	rs.updateString("password", passwordnew);
                    	System.out.println("Changed pw");
                    }
                    if(updateName == true) {
                    	rs.updateString("name", name);
                    	System.out.println("Changed name");
                    }
                    if(updatePhonenum == true) {
                    	rs.updateLong("phonenum", phonenum);
                    	System.out.println("Changed phonenum");
                    }
                    rs.updateRow();
                    break;
                }
                rs.next();
            }
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    public static void updateBookingStatus(int bookingID, String message) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try {
    		//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
    	try {
    		//Create a prepared statement
    		PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    		//Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM booking");
            
            if(message == null || message.isEmpty()) {
            
            rs.last();
            int size = rs.getRow() + 1;
            rs.first();
            for (int i = 0; i < size; i++) {
            	int bookingIDtemp = rs.getInt("bookingID");
            	if(bookingIDtemp == bookingID) {
            		rs.updateString("bookingStatus", "approved");
            		rs.updateRow();
            		System.out.println("success");
            		break;
            	}
            	rs.next();
            }
            } else {
            	
            	rs.last();
                int size = rs.getRow() + 1;
                rs.first();
                for (int i = 0; i < size; i++) {
                	int bookingIDtemp = rs.getInt("bookingID");
                	if(bookingIDtemp == bookingID) {
                		rs.updateString("bookingStatus", message);
                		rs.updateRow();
                		System.out.println("success");
                		break;
                	}
                	rs.next();
                }
            	
            }
            
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    public static void deleteBooking(int bookingID) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try {
    		//Open a connection to the database with the provided information
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePass);

            System.out.println("Connection Success");

            System.out.println("Writing data...");

        } catch (SQLException ex) {
            System.out.println("Connection Failed" + ex);
        }
    	try {
    		//Create a prepared statement
    		PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    		//Execute a SELECT aggregate SQL function that gets all data from the users table
            ResultSet rs = statement.executeQuery("SELECT * FROM booking");
            rs.last();
            int size = rs.getRow() + 1;
            rs.first();
            for (int i = 0; i < size; i++) {
            	int bookingIDtemp = rs.getInt("bookingID");
            	if(bookingIDtemp == bookingID) {
            		rs.deleteRow();
            		break;
            	}
            	rs.next();
            }
            System.out.println("success");
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
}
