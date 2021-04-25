package com.katia.crudMicroService.exeptions;

import org.springframework.http.HttpStatus;

public class NotExistExeption extends Exception {

	public NotExistExeption(String message) {
		super(message);
	}
	
}
