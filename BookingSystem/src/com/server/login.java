/*
  	File: login.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Handles login and registration actions.
	
	Version: 1.2.0 Release
*/
package com.server;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author danma
 */
public class login {
    public static String loginPerform(String email, String password) {
    	//Checks if the users credentials are correct and returns a string back to loginaction.jsp if there correct, incorrect or an admin account
        try {
            String passwordEncrypted = "";
            //Sends the password to be encypted with MD5 so they can be compared from the database
            passwordEncrypted = com.server.passwordEncryption.hasher(password);
            //If the email is a temporary user, return an error called temp user. This means that the user has tried to log into a temporary account
            //which they can not do
            if(email.contains("tempuser:")) {
            	return "tempUser";
            }
            com.server.User tempUser = new com.server.User("","",0);
            System.out.println(passwordEncrypted);
            //Get the users account from their database using their email
            try {
                tempUser = com.server.DataBase.queryUserAccount(email);
            } catch (Exception e) {
                System.out.println(e);
            }
            //If nothing was returned then the users account was not found in the database. It returns an invalidEmail message which is displayed to the user.
            if(tempUser == null) {
            	return "invalidEmail";
            }
            //Get the MD5 hashed password stored in the database
            String accpass = tempUser.getEncryptedPass();
            //If the two matched passwords match, then the entered password is ok
            if (accpass.equals(passwordEncrypted)) {
            	//Checks if the user is an admin. Returns adminAccount which logs the user in as an admin
            	if(tempUser.isAdmin == true) {
            		return "adminAccount";
            	}
            	System.out.println("Correct Details");
                //For standard user the correctDetails is returned which logs the user in
            	return "correctDetails";
            } else {
            	//If the password is incorrect then incorrectDetails is returned and displayed to the user
                return "incorrectDetails";
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null,ex);
        }
        return "";
        
        
    }
    
    public static String createAccount(String email, String password, String name, Long phonenum) throws Exception {
    	//Creates a user account and returns a message for success, tempuser or duplicate account.
        String passwordEncrypted = "";
        //If the user has entered the tempuser: tag in their email, then a tempUser error is sent back and displayed to the user
        if(email.contains("tempuser:")) {
        	return "tempUser";
        }
        //Query the database with that email. If it comes back with a result then that account already exists and a duplicate account
        // message is sent back and displayed to the user
        User tempUser = com.server.DataBase.queryUserAccount(email);
        if(!(tempUser == null)) {
        	return "duplicateAccount";
        }
        //Hashes the password with MD5
        passwordEncrypted = com.server.passwordEncryption.hasher(password);
        //Creates user object with the new account data
        User user = new User(name, email, passwordEncrypted, phonenum);
        //Updates the database with the new account data and returns a success message
        String result = DataBase.createUserAccount(user);
        if(result.equals("accCreateComplete")) {
        	return "accCreateComplete";
        
	    }
        return null;
	}
}
