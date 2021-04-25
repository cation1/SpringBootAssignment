package com.katia.crudMicroService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.katia.crudMicroService.beans.Person;

public interface PersonRepository extends MongoRepository<Person, Long>{
	Person findById(long id);
}
