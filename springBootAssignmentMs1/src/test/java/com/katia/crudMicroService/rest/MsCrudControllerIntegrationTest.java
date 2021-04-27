package com.katia.crudMicroService.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.katia.crudMicroService.beans.Person;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MsCrudControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	public TestRestTemplate testRestTemplate;

	@Test
	void testTestGetAllPersons() {
		List<Person> persons = testRestTemplate.getForObject("http://localhost:" + port + "/persons/get-all-persons",
				List.class);
		assertNotNull(persons);
		assertEquals(4, persons.size());
	}

	@Test
	void testServiceGetById() {
		// test existing ID
		Person person = testRestTemplate.getForObject("http://localhost:" + port + "/persons/find-by-id/1",
				Person.class);
		assertNotNull(person);
		assertEquals(1, person.getId());

		// test not existing ID
		ResponseEntity<Person> response = testRestTemplate
				.getForEntity("http://localhost:" + port + "/persons/find-by-id/0", Person.class);
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
	}

	@Test
	void testTestUpdatePerson() {
		// test existing Person
		Person person = new Person(1, "bracha", 31.2f, "male", 1.80f, 91.1f, null);
		testRestTemplate.put("http://localhost:" + port + "/persons/update", person);
		person = testRestTemplate.getForObject("http://localhost:" + port + "/persons/find-by-id/1", Person.class);
		assertEquals("bracha", person.getName());
		// test not existing person
		Person person2 = new Person(9, "nnn", 31.2f, "male", 1.80f, 91.1f, null);
		testRestTemplate.put("http://localhost:" + port + "/persons/update", person);
		person2 = testRestTemplate.getForObject("http://localhost:" + port + "/persons/find-by-id/9", Person.class);
		assertFalse(9 == person2.getId());
	}

	@Test
	void testTestDeletePerson() {
		testRestTemplate.delete("http://localhost:" + port + "/persons/delete/2");
		ResponseEntity<Person> response = testRestTemplate
				.getForEntity("http://localhost:" + port + "/persons/find-by-id/0", Person.class);
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
	}

}
