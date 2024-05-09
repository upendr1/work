package com.work.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.entities.Nonprofit;
import com.work.repository.NonprofitRepository;

@Service
public class Nonprofitservice {

	  @Autowired
	    private NonprofitRepository nonprofitRepository;

	    public List<Nonprofit> getAllNonprofits() {
	        return nonprofitRepository.findAll();
	        
	    }
	    
	    public Page<Nonprofit> getAllNonprofitsPaginated(Pageable pageable) {
	        return nonprofitRepository.findAll(pageable);
	    }

	    public Nonprofit saveNonprofit(Nonprofit nonprofit) {
	        return nonprofitRepository.save(nonprofit);
	    }
	    
	    public Nonprofit updateNonprofit(String email, Nonprofit nonprofit) {
	        Nonprofit n = nonprofitRepository.findByEmail(email);
	        if (n != null) {
	            n.setName(nonprofit.getName());
	           n.setAddress(nonprofit.getAddress());
	            return nonprofitRepository.save(n);
	        }
	        return null;
}

		public Nonprofit getNonprofitByEmail(String email) {
			
			return nonprofitRepository.findByEmail(email);
		}
		
		public String deleteNonProfit(String email) {
			nonprofitRepository.deleteById(email);
			
			return "DELETED";
			
			
		}
		public Nonprofit getByEmail(String email) {
			return nonprofitRepository.findByEmail(email);
		}
}
