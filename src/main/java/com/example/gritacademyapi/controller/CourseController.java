package com.example.gritacademyapi.controller;

import com.example.gritacademyapi.model.Course;
import com.example.gritacademyapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
git remote add origin https://github.com/alexandranimhagen/Java23-WebServices_GritAcademyAPI-alexandra-nimhagen.git

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
}
