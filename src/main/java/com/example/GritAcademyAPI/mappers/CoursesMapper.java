package com.example.GritAcademyAPI.mappers;

import com.example.GritAcademyAPI.DataTransfers.CoursesDTO;
import com.example.GritAcademyAPI.model.Courses;

import java.util.List;
import java.util.stream.Collectors;

public class CoursesMapper {

    public static CoursesDTO toCoursesDTO(Courses course) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());

        List<String> studentNames = course.getStudents().stream()
                .map(student -> student.getFname() + " " + student.getLname())
                .collect(Collectors.toList());
        dto.setStudentNames(studentNames);

        return dto;
    }
}
