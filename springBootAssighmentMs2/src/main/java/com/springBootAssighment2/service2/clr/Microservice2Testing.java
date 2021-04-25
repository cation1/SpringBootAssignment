package com.springBootAssighment2.service2.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springBootAssighment2.service2.service.MicroService2;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Microservice2Testing implements CommandLineRunner{
	private final MicroService2 microService2;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("_________get all persons________________");
		System.out.println(microService2.getAllPersons());		
	}

}
