package com.shubham.elasticsearch.service;

import com.shubham.elasticsearch.document.Person;
import com.shubham.elasticsearch.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person findPersonById(Integer personId) {
        return personRepository.findById(personId).orElse(null);
    }
}
