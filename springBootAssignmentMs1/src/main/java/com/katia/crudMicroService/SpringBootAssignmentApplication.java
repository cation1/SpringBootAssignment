package com.katia.crudMicroService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.katia.crudMicroService.beans.Person;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class SpringBootAssignmentApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootAssignmentApplication.class, args);
		System.out.println("ioc container was loaded");

	}

}
