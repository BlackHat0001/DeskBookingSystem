/*
  	File: passwordEncyption.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Performs MD5 hashing on passwords
	
	Version: 1.2.0 Release
*/
package com.server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author danma
 */
public class passwordEncryption {
    public static String hasher(String passwordToHash) throws RuntimeException  {
    	//Generate a MD5 hash from a given string and return the hashed string
        String generatedPassword = null;
        try {
            
        	//Uses message digest package to perfrom MD5 hash
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Updates the message digest with the input string converted to a byte array
            md.update(passwordToHash.getBytes());
            //get the hashed bytearray back from the messagedigest
            byte[] bytes = md.digest();
            //Rebuild the byte array into a string
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Set the generated hash as string
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        //Return the hashed string
        return generatedPassword;
    }
}
