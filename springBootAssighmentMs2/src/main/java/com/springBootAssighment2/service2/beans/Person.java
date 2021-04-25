package com.springBootAssighment2.service2.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

	private long id;
	private String name;
	private float age;
	private String gender;
	private float height;
	private float weight;
	private Address address;
}