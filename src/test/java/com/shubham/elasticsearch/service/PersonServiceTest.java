package com.shubham.elasticsearch.service;

import com.shubham.elasticsearch.document.Person;
import com.shubham.elasticsearch.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    void savePerson() {
        Mockito.when(personRepository.findById(Mockito.anyInt())).
                    thenReturn(Optional.of(new Person()));
        assertNotNull(personService.findPersonById(1));
    }

    @Test
    void findPersonById() {
    }
}