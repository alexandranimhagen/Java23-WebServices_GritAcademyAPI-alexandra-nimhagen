package com.example.GritAcademyAPI.controllers;

import com.example.GritAcademyAPI.DataTransfers.StudentsCoursesDTO;
import com.example.GritAcademyAPI.services.StudentsCoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentsCourses")
public class StudentsCoursesController {

    private final StudentsCoursesServices studentsCoursesServices;

    @Autowired
    public StudentsCoursesController(StudentsCoursesServices studentsCoursesServices) {
        this.studentsCoursesServices = studentsCoursesServices;
    }

    @GetMapping
    public List<StudentsCoursesDTO> getAllStudentsCourses() {
        return studentsCoursesServices.getAllStudentsCourses();
    }

    @GetMapping("/{id}")
    public StudentsCoursesDTO getStudentsCoursesById(@PathVariable Long id) {
        return studentsCoursesServices.getStudentsCoursesById(id);
    }

    @PostMapping
    public StudentsCoursesDTO createStudentsCourses(@RequestBody StudentsCoursesDTO studentsCoursesDTO) {
        return studentsCoursesServices.createStudentsCourses(studentsCoursesDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentsCourses(@PathVariable Long id) {
        studentsCoursesServices.deleteStudentsCourses(id);
        return ResponseEntity.ok("Student-course relation deleted successfully");
    }
}