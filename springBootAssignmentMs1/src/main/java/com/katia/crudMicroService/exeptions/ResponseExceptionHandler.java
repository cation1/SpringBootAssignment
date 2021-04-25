package com.katia.crudMicroService.exeptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler {
	@ExceptionHandler(NotExistExeption.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	     
	public ResponseEntity<?> handleNotExistExeption(NotExistExeption ex, WebRequest request) {
		ErrorDetails errDetails=new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
	    return new ResponseEntity(errDetails, HttpStatus.NOT_FOUND);
	}
}

