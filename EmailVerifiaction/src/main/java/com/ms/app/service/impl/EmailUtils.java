package com.ms.app.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailUtils {


    @Autowired
    private JavaMailSender emailSender;
	
	public String sendMessageWithAttachment(
	  String to, String subject, String text, String pathToAttachment) throws MessagingException {
	    // ...
	    
	    MimeMessage message = emailSender.createMimeMessage();
	     
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    
	    helper.setFrom("javatesting406@gmail.com");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);
	        
	    FileSystemResource file 
	      = new FileSystemResource(new File("C:/Users/Hp/Downloads/New-file.gif"));
	    helper.addAttachment("Invoice", file);

	    emailSender.send(message);
	    System.out.println("asdf");
	    // ...
	    return "";
	}
}
