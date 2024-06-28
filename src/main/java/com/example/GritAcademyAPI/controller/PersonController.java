package com.example.GritAcademyAPI.controller;

import com.example.GritAcademyAPI.model.Persons;
import com.example.GritAcademyAPI.services.PersonsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonsServices personsServices;

    @GetMapping
    public List<Persons> getAllPersons() {
        return personsServices.getAllPersons();
    }

    @PostMapping
    public Persons createPerson(@RequestBody Persons persons) {
        return personsServices.createPerson(persons);
    }
}
