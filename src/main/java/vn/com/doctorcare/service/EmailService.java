package vn.com.doctorcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.error.EmailException;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String to) {
    	
    	try {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("RESET PASSWORD - DOCTORCARE APP");
	        message.setText("Link to reset password: localhost:8080/user/reset-password");
	        message.setFrom("duongvtfx20043@funix.edu.vn");
	        mailSender.send(message);
    	} catch (Exception e) {
    		throw new EmailException("Could not send email");
    	}
    }

}
