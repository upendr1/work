package com.work.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.entities.Nonprofit;
import com.work.service.EmailService;
import com.work.service.Nonprofitservice;



@RestController
@RequestMapping("/nonprofits")
public class NonprController {
	
	 @Autowired
	    private Nonprofitservice nonprofitService;
	
	 @Autowired
	    private EmailService emailService;
	

	    @GetMapping
	    public List<Nonprofit> getAllNonprofits() {
	        return nonprofitService.getAllNonprofits();
	    }

	    @PostMapping
	    public Nonprofit saveNonprofit(@RequestBody Nonprofit nonprofit) {
	        return nonprofitService.saveNonprofit(nonprofit);
	    }
	    
	    @PutMapping("/{email}")
	    public Nonprofit updateNonprofit(@PathVariable String email, @RequestBody Nonprofit nonprofit) {
	        return nonprofitService.updateNonprofit(email, nonprofit);
	    }
	    
	    
	    @GetMapping("/paginate")
	    public Page<Nonprofit> getAllNonprofitsPaginated(Pageable pageable) {
	        return nonprofitService.getAllNonprofitsPaginated(pageable);
	    }
	    
	 
	    @PostMapping("/{email}/send-email")
	    public ResponseEntity<String> sendEmailToNonprofit(@PathVariable String email) {
	        Nonprofit nonprofit = nonprofitService.getNonprofitByEmail(email);
	        if (nonprofit != null) {
	            emailService.sendEmailToNonprofit(nonprofit);
	            return ResponseEntity.ok("Email sent successfully to nonprofit with email: " + email);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nonprofit with email " + email + " not found.");
	        }
	    }
	    @DeleteMapping
	    public String deleteNonProfit(@PathVariable String email) {
			return nonprofitService.deleteNonProfit(email);
	    	
	    }
	    
	    
	}
	    
	    
	    


