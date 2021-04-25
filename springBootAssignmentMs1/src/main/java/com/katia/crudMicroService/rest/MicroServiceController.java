package com.katia.crudMicroService.rest;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katia.crudMicroService.beans.Person;
import com.katia.crudMicroService.exeptions.NotExistExeption;
import com.katia.crudMicroService.service.MicroService1;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class MicroServiceController {

	private final MicroService1 microService1;
	
	@PostMapping("add")
	public void addPerson(@RequestBody Person person) {
		microService1.addPerson(person);
	}
	@GetMapping("find-by-id/{id}")
	public Person getOnePerson(@PathVariable(name = "id") long id) throws NotExistExeption {
		Person person = microService1.getSinglePerson(id);
		if (person == null) {
			throw new NotExistExeption("not exist");
		}
		return person;
	}
	
	@GetMapping("get-all-persons")
	public List<Person> getAllPersons() {
		return microService1.getAllPersons();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable long id) throws NotExistExeption {
		Person person = microService1.getSinglePerson(id);
		if(person == null) {
			throw new NotExistExeption("not exist, nothing to delete");
		}
		microService1.deletePerson(id);
		return new ResponseEntity<String>("the person with id " + id + " deleted succesfully" ,HttpStatus.OK);
	}
	
	@PostMapping("/persons")
	public ResponseEntity<?> createPerson(@RequestBody Person person) {
		Person savedPerson = microService1.addPerson(person);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedPerson.getId()).toUri();
		
		//return ResponseEntity.created(location).build();
		return new ResponseEntity<String>("The Person Created", HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> updatePerson(@RequestBody Person person) throws NotExistExeption{
		if(microService1.getSinglePerson(person.getId()) == null){
			throw new NotExistExeption("the person is not exist");
		}
		microService1.updatePerson(person);
		return new ResponseEntity<String>("The Person Updated", HttpStatus.OK);
	}
	

}
