package com.example.GritAcademyAPI.controllers;

import com.example.GritAcademyAPI.DataTransfers.StudentsDTO;
import com.example.GritAcademyAPI.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentsServices studentsServices;

    @Autowired
    public StudentsController(StudentsServices studentsServices) {
        this.studentsServices = studentsServices;
    }

    @GetMapping
    public List<StudentsDTO> getAllStudents() {
        return studentsServices.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentsDTO getStudentById(@PathVariable Long id) {
        return studentsServices.getStudentById(id);
    }

    @GetMapping("/fname/{fname}")
    public List<StudentsDTO> getStudentsByFname(@PathVariable String fname) {
        return studentsServices.getStudentsByFname(fname);
    }

    @GetMapping("/lname/{lname}")
    public ResponseEntity<?> getStudentsByLname(@PathVariable String lname) {
        List<StudentsDTO> students = studentsServices.getStudentsByLname(lname);
        if (students.isEmpty()) {
            return ResponseEntity.status(404).body("No students found with last name: " + lname);
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/town/{town}")
    public List<StudentsDTO> getStudentsByTown(@PathVariable String town) {
        return studentsServices.getStudentsByTown(town);
    }

    @PostMapping
    public StudentsDTO createStudent(@RequestBody StudentsDTO studentsDTO) {
        return studentsServices.createStudent(studentsDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentsServices.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}