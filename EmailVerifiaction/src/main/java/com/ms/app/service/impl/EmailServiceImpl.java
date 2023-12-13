package com.ms.app.service.impl;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl {

	public String sendEmail(String subject,String to,String from,String message) {
		
		
		String host = "smtp.gmail.com";
		
		// setting system properties
		Properties properties = System.getProperties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//step 1 : to get session object
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("roversetesting@gmail.com","tdygcecqyyuigsil");
			}
			
		});
		session.setDebug(true);
		
		//Step 2 : compose message[text,multimedia]
		MimeMessage mime = new MimeMessage(session);
		
		try {
			// from email
			mime.setFrom(from);
			
			// adding recepent to message
			mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// adding subject to message
			mime.setSubject(subject);
			
			// adding text to message
			mime.setText(message);
			
		
			
			// send
			
			Transport.send(mime);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "Send successfully .... ";		
		
	}
	
}
