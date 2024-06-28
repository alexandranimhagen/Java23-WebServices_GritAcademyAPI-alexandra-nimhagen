package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.model.StudentCourses;
import com.example.GritAcademyAPI.repository.StudentCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCoursesServices {

    @Autowired
    StudentCoursesRepository studentCoursesRepository;

    public Iterable<StudentCourses> getStudentCourses(){
        return studentCoursesRepository.findAll();
    }
}