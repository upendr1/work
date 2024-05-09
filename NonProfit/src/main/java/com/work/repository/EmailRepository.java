package com.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
