package com.katia.crudMicroService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.katia.crudMicroService.beans.Person;
import com.katia.crudMicroService.exeptions.NotExistExeption;
import com.katia.crudMicroService.repo.PersonRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MicroService1 {

	private final PersonRepository personRepository;
	
	public Person addPerson (Person person){
		return personRepository.save(person);
	}
	public Person getSinglePerson(long id) throws NotExistExeption {
		return personRepository.findById(id);
	}
	public List<Person>getAllPersons(){
		return personRepository.findAll();
	}
	public void updatePerson(Person person) {
		personRepository.save(person);
	}
	
	public void deletePerson(long id) {
		personRepository.deleteById(id);
	}
}
