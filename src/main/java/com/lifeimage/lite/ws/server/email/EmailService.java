package com.lifeimage.lite.ws.server.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lifeimage.lite.ws.server.beans.EmailEntity;



@Service
public class EmailService {

	@Autowired
	private Environment env;
	
	private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(EmailEntity email) {

    	SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(email.getEmailTo());
        mailMessage.setSubject(email.getEmailSubject());
        mailMessage.setText(email.getEmailText());
        mailMessage.setFrom(env.getProperty("mailSender.mailFrom"));
        javaMailSender.send(mailMessage);
    }
}


