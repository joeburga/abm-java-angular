package com.example.abm;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.abm.repositories.PersonRepository;

@SpringBootApplication
public class AbmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbmApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner initData(PersonRepository personRepository) {
		return (args) -> {
						
			Person persona = new Person("M","Joe","Burga","burga.joe@gmail.com");
			
			personRepository.save(persona);
			
		};
	}

}
