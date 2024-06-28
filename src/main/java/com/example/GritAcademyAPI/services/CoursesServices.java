package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.DataTransfers.CoursesDTO;
import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServices {
    @Autowired
    private CoursesRepository coursesRepository;

    public List<Courses> getAllCourses() {
        return (List<Courses>) coursesRepository.findAll();
    }

    public Courses createCourse(Courses courses) {
        return coursesRepository.save(courses);
    }

    public List<CoursesDTO> getCourses() {
    }

    public List<CoursesDTO> getCoursesByName(String name) {
    }
}
