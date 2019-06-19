package com.example.abm.service;

import java.util.List;

import com.example.abm.Person;

public interface PersonService {

	List<Person> personList();
	Person getPerson(long id);
	Person add(Person person);
	Person edit(Person person);
	Person delete(long id);
}
