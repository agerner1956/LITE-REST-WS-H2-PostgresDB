package com.lifeimage.lite.ws.server.email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	
	@Autowired
	private Environment env;
	
    @Bean
    public JavaMailSender javaMailSender() 
    {
    	
    	
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
      
    	mailSender.setHost(env.getProperty("mailSender.mailFrom"));
    	mailSender.setHost(env.getProperty("mailSender.host"));
    	mailSender.setPort(Integer.valueOf(env.getProperty("mailSender.port")));
    	mailSender.setUsername(env.getProperty("mailSender.username"));       
        mailSender.setPassword(env.getProperty("mailSender.password"));
          
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", env.getProperty("mailSender.protocol"));
        props.put("mail.smtp.auth", env.getProperty("mailSender.javaMailProperties.mail.smtps.auth"));
        props.put("mail.smtp.starttls.enable", env.getProperty("mailSender.javaMailProperties.mail.smtp.starttls.enable"));
        props.put("mail.smtp.quitwait", env.getProperty("mailSender.javaMailProperties.mail.smtp.quitwait"));
        props.put("mail.smtp.ssl.protocols", env.getProperty("mailSender.javaMailProperties.mail.smtp.ssl.protocols"));
        props.put("mail.debug", "false");
          
        return mailSender;
    }
}



