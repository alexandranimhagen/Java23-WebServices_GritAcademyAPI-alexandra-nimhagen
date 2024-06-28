package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServices {
    @Autowired
    private PersonRepository personRepository;

    public List<Persons> getAllPersons() {
        return personRepository.findAll();
    }

    public Persons createPerson(Persons persons) {
        return personRepository.save(persons);
    }
}
