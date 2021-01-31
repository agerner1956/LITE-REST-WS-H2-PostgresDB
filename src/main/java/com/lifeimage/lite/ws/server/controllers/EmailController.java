package com.lifeimage.lite.ws.server.controllers;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifeimage.lite.ws.server.beans.EmailEntity;
import com.lifeimage.lite.ws.server.beans.HL7Entity;
import com.lifeimage.lite.ws.server.email.EmailService;
import com.lifeimage.lite.ws.server.repositories.EmailRepository;
import com.lifeimage.lite.ws.server.utils.Constants;
import com.lifeimage.lite.ws.server.utils.Misc;

@RestController

@RequestMapping("/li/lite/ws")
public class EmailController 
{
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
        
    @Autowired
	private EmailService emailService;
    
    @Autowired
    private EmailRepository emailRepository;
    
    @Autowired
	private Environment env;


    @PostMapping(value = "/email")
    public EmailEntity sendMail(@Valid @RequestBody EmailEntity email) {
    	logger.debug("sendMail"+ Constants.messageStarted);
    	Misc misc = new Misc();
    	email.setEmailTimestamp(misc.getTimestamp());
    	email.setEmailFrom(env.getProperty("mailSender.port"));
    	email.setEmailStatus(Constants.statusSuccess);
    	emailService.sendMail(email);
    	emailRepository.save(email);
    	return email;
    }
    
    @GetMapping("/emails")   
    public List<EmailEntity> getAllEmails() {
      return emailRepository.findAll();
    }
 
    
}

