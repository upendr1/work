package com.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.entities.Foundation;

public interface FoundationRepository extends JpaRepository<Foundation,String> {

	 Foundation findByEmail(String email); 
		
		
	

}
