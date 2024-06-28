package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.DataTransfers.CoursesDTO;
import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Courses getCourseById(Long id) {
        Optional<Courses> course = coursesRepository.findById(id);
        return course.orElse(null);
    }

    public List<CoursesDTO> getCourses() {
        List<Courses> coursesList = (List<Courses>) coursesRepository.findAll();
        return coursesList.stream().map(course -> new CoursesDTO(course.getId(), course.getName())).collect(Collectors.toList());
    }

    public List<CoursesDTO> getCoursesByName(String name) {
        List<Courses> coursesList = coursesRepository.findByName(name);
        return coursesList.stream().map(course -> new CoursesDTO(course.getId(), course.getName())).collect(Collectors.toList());
    }
}
