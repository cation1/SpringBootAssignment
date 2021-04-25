package com.katia.crudMicroService.clr;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.katia.crudMicroService.beans.Address;
import com.katia.crudMicroService.beans.Person;
import com.katia.crudMicroService.service.MicroService1;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MicroServiceTesting implements CommandLineRunner{

	private final MicroService1 microService1;
	@Override
	public void run(String... args) throws Exception {
		Address a1 = new Address("israel", "holon", "ben gurion", 70210);
		Address a2 = new Address("new york", "holon", "ben gurion", 51210);
		Person p1 = new Person(1, "elad",31.2f, "male", 1.80f,91.1f,a1);
		Person p2 = new Person(2, "katia",32f, "female", 1.70f,51.1f,a2);
		Person p3 = new Person(3, "talia",2.2f, "female", 0.80f,10.1f,a1);
		Person p4 = new Person(4, "sean",0.2f, "male", 0.40f,5.1f,a1);
		microService1.addPerson(p1);
		microService1.addPerson(p2);
		microService1.addPerson(p3);
		microService1.addPerson(p4);
		System.out.println("_________get one person_______________");
		System.out.println(microService1.getSinglePerson(3));
		System.out.println("_________get all persons________________");
		System.out.println(microService1.getAllPersons());
		p4.setWeight(6.1f);
		System.out.println("_______get one after update_______________");
		microService1.updatePerson(p4);
		System.out.println(microService1.getSinglePerson(4));
		System.out.println("________delete one and get all_______________");
		microService1.deletePerson(4);
		System.out.println(microService1.getAllPersons());
		microService1.getSinglePerson(1);
		
	}

}
