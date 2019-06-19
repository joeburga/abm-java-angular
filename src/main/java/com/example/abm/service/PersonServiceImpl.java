package com.example.abm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abm.Person;
import com.example.abm.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> personList() {
		return personRepository.findAll();
	}

	@Override
	public Person getPerson(long id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public Person add(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person edit(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person delete(long id) {
		Person person = personRepository.findById(id).orElse(null);
		if(person != null) {
			personRepository.delete(person);
		}
		
		return person;
	}

}
