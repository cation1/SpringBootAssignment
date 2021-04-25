package com.springBootAssighment2.service2.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springBootAssighment2.service2.beans.Person;
import com.springBootAssighment2.service2.service.MicroService2;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class MicroService2Controller {
	private final MicroService2 microService2;
	
	@GetMapping("get-all-persons")
	public List<Person> getAllPersons() {
		return microService2.getAllPersons();
	}
	
	@GetMapping("persons-a-or-k")
	public List<Person> getPersonsAK() {	
		return microService2.getPersonsAK();
	}

	@GetMapping("persons-israel-and-aw")
	public List<Person> getAllIsrAbAvgWght() {
		return microService2.getAllIsrAbAvgWght();
	}	
}
