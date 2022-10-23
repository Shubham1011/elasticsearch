package com.shubham.elasticsearch.controller;

import com.shubham.elasticsearch.document.Person;
import com.shubham.elasticsearch.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonService personService;

    @PostMapping("/save")
    public void savePerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @GetMapping("/get/{personId}")
    public Person findByPersonId(@PathVariable("personId") Integer personId) {
        return personService.findPersonById(personId);
    }
}
