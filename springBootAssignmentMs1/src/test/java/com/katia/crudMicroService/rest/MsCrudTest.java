package com.katia.crudMicroService.rest;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.katia.crudMicroService.beans.Address;
import com.katia.crudMicroService.beans.Person;
import com.katia.crudMicroService.service.MicroService1;

import lombok.RequiredArgsConstructor;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
@WebMvcTest
@RunWith(MockitoJUnitRunner.class)

@RequiredArgsConstructor
public class MsCrudTest { 
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MicroService1 microService1;


	@Test
	void testAddPerson() {
//		persons = microService1.getAllPersons();
//		int personsNum = persons.size();
//		Address a1 = new Address("israel", "holon", "ben gurion", 70210);
//		Address a2 = new Address("new york", "holon", "ben gurion", 51210);
//		Person p1 = new Person(1, "elad",31.2f, "male", 1.80f,91.1f,a1);
//		when(microService1.addPerson(p1)).thenReturn(p1);
//		microService1.addPerson(p1);
//		when(null)
//		
		//		Person p2 = new Person(2, "katia",32f, "female", 1.70f,51.1f,a2);
//		Person p3 = new Person(3, "talia",2.2f, "female", 0.80f,10.1f,a1);
//		Person p4 = new Person(4, "sean",0.2f, "male", 0.40f,5.1f,a1);
//		microService1.addPerson(p2);
//		microService1.addPerson(p3);
//		microService1.addPerson(p4);
		//microService1.getAllPersons();
		
	}

	@Test
	void testGetSinglePerson() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllPersons() {
		Address a1 = new Address("israel", "holon", "ben gurion", 70210);
		Address a2 = new Address("new york", "holon", "ben gurion", 51210);
		Person p1 = new Person(1, "elad",31.2f, "male", 1.80f,91.1f,a1);
		Person p2 = new Person(2, "katia",32f, "female", 1.70f,51.1f,a2);
		
		Mockito.when(microService1.getAllPersons()).thenReturn(Arrays.asList(p1,p2));
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/get-all-persons"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(1)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testUpdatePerson() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletePerson() {
		fail("Not yet implemented");
	}

}
