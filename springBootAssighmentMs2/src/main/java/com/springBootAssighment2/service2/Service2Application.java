package com.springBootAssighment2.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Service2Application {

	public static void main(String[] args) {		
		ApplicationContext ctx = SpringApplication.run(Service2Application.class, args);
		System.out.println("ioc container was loaded");
	}
}


