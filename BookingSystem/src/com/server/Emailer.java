package com.server;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Emailer {
	public static void sendEmail(String toAddress,
            String subject, String message) {
			final String userName = "lshdeskbookings@gmail.com";
			String host = "smtp.gmail.com";
			String port = "587";
			final String password = "LSHAdmin1221";
	      // Get system properties
			System.out.println(userName + " " + password);
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", port);
	      properties.setProperty("mail.smtp.starttls.enable","true");
	      properties.setProperty("mail.smtp.auth","true");
	      
	      // Get the default Session object.
	      
	      Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        Session session = Session.getInstance(properties, auth);
	      try {
	         MimeMessage msg = new MimeMessage(session);

	         // Set From: header field of the header.
	         msg.setFrom(new InternetAddress(userName));

	         // Set To: header field of the header.
	         msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

	         // Set Subject: header field
	         msg.setSubject(subject);

	         // Send the actual HTML message, as big as you like
	         msg.setContent(message, "text/html");
	         
	         

	         // Send message
	         Transport.send(msg);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
 
    }
}
