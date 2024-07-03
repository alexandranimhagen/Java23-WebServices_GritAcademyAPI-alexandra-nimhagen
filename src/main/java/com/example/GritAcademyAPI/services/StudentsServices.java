package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.DataTransfers.StudentsDTO;
import com.example.GritAcademyAPI.exception.ResourceNotFoundException;
import com.example.GritAcademyAPI.mappers.Mapper;
import com.example.GritAcademyAPI.model.Students;
import com.example.GritAcademyAPI.repository.StudentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsServices {

    private static final Logger logger = LoggerFactory.getLogger(StudentsServices.class);

    private final StudentsRepository studentsRepository;

    public StudentsServices(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<StudentsDTO> getAllStudents() {
        List<Students> students = studentsRepository.findAll();
        logger.info("Fetched {} students from database", students.size());
        return students.stream()
                .map(Mapper::toStudentsDTO)
                .collect(Collectors.toList());
    }

    public StudentsDTO getStudentById(Long id) {
        Students student = studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        return Mapper.toStudentsDTO(student);
    }

    public List<StudentsDTO> getStudentsByFname(String fname) {
        return studentsRepository.findByFnameContainingIgnoreCase(fname).stream()
                .map(Mapper::toStudentsDTO)
                .collect(Collectors.toList());
    }

    public List<StudentsDTO> getStudentsByLname(String lname) {
        return studentsRepository.findByLnameContainingIgnoreCase(lname).stream()
                .map(Mapper::toStudentsDTO)
                .collect(Collectors.toList());
    }

    public List<StudentsDTO> getStudentsByTown(String town) {
        return studentsRepository.findByTownContainingIgnoreCase(town).stream()
                .map(Mapper::toStudentsDTO)
                .collect(Collectors.toList());
    }

    public StudentsDTO createStudent(StudentsDTO studentsDTO) {
        Students student = new Students();
        student.setFname(studentsDTO.getFname());
        student.setLname(studentsDTO.getLname());
        student.setTown(studentsDTO.getTown());
        Students savedStudent = studentsRepository.save(student);
        return Mapper.toStudentsDTO(savedStudent);
    }

    public void deleteStudent(Long id) {
        Students student = studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        studentsRepository.delete(student);
    }
}
