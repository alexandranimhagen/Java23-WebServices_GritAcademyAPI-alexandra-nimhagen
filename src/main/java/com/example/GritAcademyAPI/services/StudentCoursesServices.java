package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.model.StudentCourses;
import com.example.GritAcademyAPI.repository.StudentCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCoursesServices {

    @Autowired
    private StudentCoursesRepository studentCoursesRepository;

    public List<StudentCourses> getAllStudentCourses() {
        return studentCoursesRepository.findAll();
    }
}
