package com.katia.crudMicroService.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
	@Id
	private long id;
	private String name;
	private float age;
	private String gender;
	private float height;
	private float weight;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Address address;
}
