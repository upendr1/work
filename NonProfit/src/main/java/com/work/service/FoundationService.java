package com.work.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.work.entities.Foundation;
import com.work.entities.Nonprofit;
import com.work.repository.FoundationRepository;

@Service
public class FoundationService {
	
	   @Autowired
	    private FoundationRepository foundationRepository;

	    public List<Foundation> getAllFoundations() {
	        return foundationRepository.findAll();
	    }
	    
	    public Page<Foundation> getAllFoundationPaginated(Pageable pageable) {
	        return foundationRepository.findAll(pageable);
	    }

	    public Foundation saveFoundation(Foundation foundation) {
	        return foundationRepository.save(foundation);
	    }

	    public Foundation updateFoundation(String email, Foundation foundation) {
	        Foundation n = foundationRepository.findByEmail(email);
	        if (n != null) {
	            n.setName(foundation.getName());
	           n.setAddress(foundation.getAddress());
	            return foundationRepository.save(n);
	        }
	        return null;
}
			
			
		}


