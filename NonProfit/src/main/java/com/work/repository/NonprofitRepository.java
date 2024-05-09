package com.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.entities.Nonprofit;

public interface NonprofitRepository extends JpaRepository<Nonprofit, String> {
	Nonprofit findByEmail(String email);
}
