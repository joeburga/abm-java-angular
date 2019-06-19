package com.example.abm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.abm.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


}
