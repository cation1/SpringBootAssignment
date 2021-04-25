package com.katia.crudMicroService.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	private String state;
	private String city;
	private String street;
	@Id
	private int zipcode;	
}
