/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        try {
            String passwordEncrypted = "";
            passwordEncrypted = com.server.passwordEncryption.hasher(password);
            if(email.contains("tempuser:")) {
            	return "tempUser";
            }
            com.server.User tempUser = new com.server.User("","",0);
            System.out.println(passwordEncrypted);
            try {
                tempUser = com.server.DataBase.queryUserAccount(email);
            } catch (Exception e) {
                System.out.println(e);
            }
            if(tempUser == null) {
            	return "invalidEmail";
            }
            String accpass = tempUser.getEncryptedPass();
            if (accpass.equals(passwordEncrypted)) {
            	if(tempUser.isAdmin == true) {
            		return "adminAccount";
            	}
            	System.out.println("Correct Details");
                return "correctDetails";
            } else {
                return "incorrectDetails";
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null,ex);
        }
        return "";
        
        
    }
    
    public static String createAccount(String email, String password, String name, Long phonenum) throws Exception {
        String passwordEncrypted = "";
        if(email.contains("tempuser:")) {
        	return "tempUser";
        }
        User tempUser = com.server.DataBase.queryUserAccount(email);
        if(!(tempUser == null)) {
        	return "duplicateAccount";
        }
        passwordEncrypted = com.server.passwordEncryption.hasher(password);
        User user = new User(name, email, passwordEncrypted, phonenum);
        String result = DataBase.createUserAccount(user);
        if(result.equals("accCreateComplete")) {
        	return "accCreateComplete";
        
	    }
        return null;
	}
}
