package com.ms.app.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.app.service.impl.EmailServiceImpl;
import com.ms.app.service.impl.EmailUtils;

import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private EmailUtils utils;
	
	
	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestBody String email) throws MessagingException{
		Random random = new Random();
		String subject = "Copy code\r\n"
				+ "Subject: Your OTP Verification Code\r\n"
				+ "\r\n"
				+ "Dear [Recipient's Name or Username],\r\n"
				+ "\r\n"
				+ "We hope this message finds you well. As part of our commitment to ensuring the security of your account, we are initiating an OTP verification process to confirm your identity.\r\n"
				+ "\r\n"
				+ "Please find below your One-Time Password (OTP) for verification:\r\n"
				+ "\r\n"
				+ "OTP Code: [Insert OTP Code]\r\n"
				+ "\r\n"
				+ "To complete the verification process, please click on the following link or copy and paste it into your web browser:\r\n"
				+ "\r\n"
				+ "[Verify Your Account](http://localhost:8081/email/verifies?value=0909)\r\n"
				+ "\r\n"
				+ "This OTP is valid for a limited time and should only be used for the purpose of account verification on [Your Website/Platform Name]. Do not share this OTP with anyone, including our support staff. We will never ask for your OTP via email or any other means.\r\n"
				+ "\r\n"
				+ "If you did not request this OTP or have any concerns about the security of your account, please contact our support team immediately at [Your Support Email or Phone Number].\r\n"
				+ "\r\n"
				+ "Thank you for choosing [Your Website/Platform Name]. We are committed to ensuring the safety and security of your account.\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "\r\n"
				+ "[Your Name]\r\n"
				+ "[Your Position]\r\n"
				+ "[Your Company Name]\r\n"
				+ "[Website URL]\r\n"
				+ "[Contact Information]";
		return new ResponseEntity<String>(this.utils.sendMessageWithAttachment(email,email,"roversetesting@gmail.com", "Otp is"+random.nextInt(9999)+" Please verify your opt and do not share with anyone"),HttpStatus.OK);
	}
	
	@GetMapping("/verifies")
	public ResponseEntity<String> verifies(@RequestParam("value") String otp){
		System.out.println(otp);
		return new ResponseEntity<String>("",null);
	}
	
}
