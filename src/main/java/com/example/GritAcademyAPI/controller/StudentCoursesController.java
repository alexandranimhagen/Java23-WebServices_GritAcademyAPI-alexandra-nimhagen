package com.example.GritAcademyAPI.controller;

import com.example.GritAcademyAPI.model.StudentCourses;
import com.example.GritAcademyAPI.services.StudentCoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentCoursesController {

    @Autowired
    private StudentCoursesServices studentCoursesServices;

    @GetMapping(value = "/students_courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentCourses> getAllStudentCourses() {
        return studentCoursesServices.getAllStudentCourses();
    }
}
