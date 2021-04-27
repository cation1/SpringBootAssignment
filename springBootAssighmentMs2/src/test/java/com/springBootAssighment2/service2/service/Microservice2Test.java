package com.springBootAssighment2.service2.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Microservice2Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetAllPersons() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetPersonsAK() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetAllIsrAbAvgWght() {
		fail("Not yet implemented");
	}

}
