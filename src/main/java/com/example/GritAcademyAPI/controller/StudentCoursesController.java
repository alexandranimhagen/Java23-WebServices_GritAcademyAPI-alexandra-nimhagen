package com.example.GritAcademyAPI.controller;

import com.example.GritAcademyAPI.model.StudentCourses;
import com.example.GritAcademyAPI.services.StudentCoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCoursesController {

    @Autowired
    StudentCoursesServices studentCoursesServices;

    @GetMapping(value = "/studentCourses", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<StudentCourses> getStudentCourses(){
        return studentCoursesServices.getStudentCourses();
    }
}