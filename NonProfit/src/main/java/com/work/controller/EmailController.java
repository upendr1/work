package com.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.entities.Email;
import com.work.service.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {
	
    @Autowired
    private EmailService emailService;

    @GetMapping("/nonprofit")
    public List<Email> getEmailsSentToNonprofits() {
        return emailService.getEmailsSentToNonprofits();
    }

}
