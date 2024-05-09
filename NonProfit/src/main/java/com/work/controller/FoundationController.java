package com.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.work.entities.Foundation;
import com.work.entities.Nonprofit;
import com.work.service.FoundationService;

@RestController
@RequestMapping("/foundation")
public class FoundationController {
	
	  @Autowired
	    private FoundationService foundationService;

	    @GetMapping
	    public List<Foundation> getAllFoundations() {
	        return foundationService.getAllFoundations();
	    }

	    @PostMapping
	    public Foundation saveFoundation(@RequestBody Foundation foundation) {
	        return foundationService.saveFoundation(foundation);
	    }
	    
	    @PutMapping("/{email}")
	    public Foundation updateFoundation(@PathVariable String email, @RequestBody Foundation foundation) {
	      this.foundationService.updateFoundation(email, foundation);
	      return foundation;
	    }
	    
	    @GetMapping("/paginate")
	    public Page<Foundation> getAllFoundationPaginated(Pageable pageable) {
	        return foundationService.getAllFoundationPaginated(pageable);
	    }
	    
	    @GetMapping("/get/{email}")
	    public Foundation findByEmail(@PathVariable String email) {
	    	return foundationService.getByEmail(email);
	    }

}
