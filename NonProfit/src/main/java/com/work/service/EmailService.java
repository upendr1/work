package com.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.entities.Email;
import com.work.entities.Nonprofit;
import com.work.repository.EmailRepository;

@Service
public class EmailService {
	
    @Autowired
    private EmailRepository emailRepository;

    public void sendEmailToNonprofit(Nonprofit nonprofit) {
    
        String recipientEmail = nonprofit.getEmail();
        String subject = "Sample Email Subject";
        String body = "Dear " + nonprofit.getName() + ",This is a sample email body.";
        
        // Save the sent email to the database
        Email email = new Email();
        email.setRecipientEmail(recipientEmail);
        email.setSubject(subject);
        email.setBody(body); 
        emailRepository.save(email);
    }

	public List<Email> getEmailsSentToNonprofits() {
		return emailRepository.findAll();
	}

}
