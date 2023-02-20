package com.gt.services;

import java.io.Console;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String to, String name, String username, String password) throws MessagingException {
    	       
        try {
        	String subject = "Gigatech Due Diligence Credentials";
        	String body = "Dear "+name+".<br/><br/>Welcome from Gigatech Limited. Your username and password for login to due diligence portal are mentioned below-<br/><br/>Username: "+username+"<br/><br/>Password: "+password+"<br/><br/>Thank You.<br/><br/>Gigatech Team";

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            
            helper.setFrom("aloukik.roy@gigatechltd.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

            emailSender.send(message);
        }
        
        catch (Exception e) {
			System.out.print(e);
		}
    }
}
