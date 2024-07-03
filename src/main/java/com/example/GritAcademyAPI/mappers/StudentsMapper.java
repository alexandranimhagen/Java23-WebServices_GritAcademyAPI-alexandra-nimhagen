package com.example.GritAcademyAPI.mappers;

import com.example.GritAcademyAPI.DataTransfers.StudentsDTO;
import com.example.GritAcademyAPI.model.Students;

import java.util.stream.Collectors;

public class StudentsMapper {
    public static StudentsDTO toStudentDTO(Students student) {
        StudentsDTO studentDTO = new StudentsDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFname(student.getFname());
        studentDTO.setLname(student.getLname());
        studentDTO.setTown(student.getTown());

        studentDTO.setCourseIds(student.getCourses().stream()
                .map(course -> course.getId())
                .collect(Collectors.toList()));

        return studentDTO;
    }
}
