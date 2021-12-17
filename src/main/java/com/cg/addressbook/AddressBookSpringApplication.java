package com.cg.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookSpringApplication.class, args);
		log.info("AddressBook Application Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("AddressBook DB User is {} Environment",
    			context.getEnvironment().getProperty("spring.datasource.username"));
	}
}