package com.work.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Foundation {
	
    @Id
    private String email;
    private String name;
    private String address;

}
