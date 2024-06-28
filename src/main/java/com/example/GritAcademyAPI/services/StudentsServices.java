package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.DataTransfers.StudentsDTO;
import com.example.GritAcademyAPI.model.Students;
import com.example.GritAcademyAPI.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServices {
    @Autowired
    private StudentsRepository studentsRepository;

    public List<Students> getAllStudents() {
        return (List<Students>) studentsRepository.findAll();
    }

    public Students createStudent(Students students) {
        return studentsRepository.save(students);
    }

    public List<StudentsDTO> getStudents() {
        return List.of();
    }

    public List<StudentsDTO> getStudentById(Long id) {
        return List.of();
    }

    public List<StudentsDTO> getStudentByLname(String lname) {
        return List.of();
    }

    public List<StudentsDTO> getStudentByFname(String fname) {
        return List.of();
    }

    public List<StudentsDTO> getStudentByTown(String town) {
        return List.of();
    }
}
