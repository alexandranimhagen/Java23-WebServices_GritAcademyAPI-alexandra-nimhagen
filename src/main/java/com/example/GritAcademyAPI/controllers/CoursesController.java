package com.example.GritAcademyAPI.controllers;

import com.example.GritAcademyAPI.DataTransfers.CoursesDTO;
import com.example.GritAcademyAPI.services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesServices coursesServices;

    @Autowired
    public CoursesController(CoursesServices coursesServices) {
        this.coursesServices = coursesServices;
    }

    @GetMapping
    public List<CoursesDTO> getAllCourses() {
        return coursesServices.getAllCourses();
    }

    @GetMapping("/{id}")
    public CoursesDTO getCourseById(@PathVariable Long id) {
        return coursesServices.getCourseById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getCoursesByName(@PathVariable String name) {
        List<CoursesDTO> courses = coursesServices.getCoursesByName(name);
        if (courses.isEmpty()) {
            return ResponseEntity.status(404).body("No courses found with name containing: " + name);
        }
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<?> getCoursesByDescription(@PathVariable String description) {
        List<CoursesDTO> courses = coursesServices.getCoursesByDescription(description);
        if (courses.isEmpty()) {
            return ResponseEntity.status(404).body("No courses found with description containing: " + description);
        }
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    public CoursesDTO createCourse(@RequestBody CoursesDTO coursesDTO) {
        return coursesServices.createCourse(coursesDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        coursesServices.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}