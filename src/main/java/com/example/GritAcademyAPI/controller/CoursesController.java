package com.example.GritAcademyAPI.controller;

import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesServices coursesServices;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Courses> getAllCourses() {
        return coursesServices.getAllCourses();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Courses> getCourseById(@PathVariable(value = "id") Long id) {
        Courses course = coursesServices.getCourseById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course) {
        Courses createdCourse = coursesServices.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    // Lägg till andra endpoints om nödvändigt
}
