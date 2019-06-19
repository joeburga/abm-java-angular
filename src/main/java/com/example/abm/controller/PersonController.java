package com.example.abm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.abm.Person;
import com.example.abm.service.PersonService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonService personService;

	
	@GetMapping("/person")
	public List<Person> getPersonList() {
		return personService.personList();
	}

	@GetMapping(path = "/person/{id}")
	public Person getPerson(@PathVariable long id) {

//		if (personService.personList().stream().filter(p -> p.getId()==id).count() ==1) {
		Person person = personService.getPerson(id);
		
		return person;
			
//		} else {
//			Person personNull = new Person(id,"","","");
//			return personNull;
//		}
		
	}
	
	@PostMapping("/person/add")
	public ResponseEntity<Map<String, Object>> addPerson(@RequestBody Person person) {
		if (person.getName().isEmpty()) {
			return new ResponseEntity<>(responseInfo("error", "Missing data"), HttpStatus.FORBIDDEN);
		}
		
		person.setId(0);
		personService.add(person);
		return new ResponseEntity<>(responseInfo("ok", "Agregado Correctamente"), HttpStatus.CREATED);
	}


	@PutMapping(path = "/person/{id}")
	public Person editPerson(@RequestBody Person person, @PathVariable long id) {
		person.setId(id);
		return personService.edit(person);
	}

	@DeleteMapping(path = "/person/{id}")
	public Person deletePerson(@PathVariable long id) {
		return personService.delete(id);
	}

	private Map<String, Object> responseInfo(String key, Object value) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		return map;
	}

}
