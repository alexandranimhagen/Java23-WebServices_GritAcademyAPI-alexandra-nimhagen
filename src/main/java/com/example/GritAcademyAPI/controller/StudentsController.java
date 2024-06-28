package com.example.GritAcademyAPI.controller;

import com.example.GritAcademyAPI.model.Students;
import com.example.GritAcademyAPI.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsServices studentsServices;

    @GetMapping
    public List<Students> getAllStudents() {
        return studentsServices.getAllStudents();
    }

    @PostMapping
    public Students createStudent(@RequestBody Students students) {
        return studentsServices.createStudent(students);
    }
}
