package com.springBootAssighment2.service2.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {	
	
	private String state;
	private String city;
	private String street;
	private int zipcode;
}

