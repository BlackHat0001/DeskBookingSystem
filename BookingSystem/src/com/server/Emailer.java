/*
  	File: Emailer.java
	
	Author: Daniel Marcovecchio 
	Author URI: https://github.com/BlackHat0001
	
	Description: Handles sending of emails over a mail server through a defined account.
	
	Version: 1.2.0 Release
*/
package com.server;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Emailer {
	public static void sendEmail(String toAddress, String subject, String message) {
		//Sends emails to the user with a given subject, message and address. Can be configured to use any SMTP Server
			//account information. how to connect to the gmail mail servers
		final String userName = "lshdeskbookings@gmail.com";
			String host = "smtp.gmail.com";
			String port = "587";
			final String password = "LSHAdmin1221";
	      // Get system properties
			System.out.println(userName + " " + password);
	      Properties properties = System.getProperties();

	      // Setup mail server and smtp properties
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", port);
	      properties.setProperty("mail.smtp.starttls.enable","true");
	      properties.setProperty("mail.smtp.auth","true");
	      
	      //Create a password authenticator for the account username and password. This is passed on in mail.smtp.auth
	      
	      Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        Session session = Session.getInstance(properties, auth);
	      try {
	         MimeMessage mimemessage = new MimeMessage(session);

	         //Sets from who the email is from
	         mimemessage.setFrom(new InternetAddress(userName));

	         //Set who the email is to (recipient)
	         mimemessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

	         //Set the subject of the email
	         mimemessage.setSubject(subject);

	         //Set the message of the email
	         mimemessage.setContent(message, "text/html");
	         
	         

	         //Send the email
	         Transport.send(mimemessage);
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
 
    }
}
