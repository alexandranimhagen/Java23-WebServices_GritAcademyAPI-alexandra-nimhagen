package com.example.GritAcademyAPI.mappers;

import com.example.GritAcademyAPI.DataTransfers.CoursesDTO;
import com.example.GritAcademyAPI.DataTransfers.StudentsDTO;
import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.model.Students;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

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

    public static StudentsDTO toStudentsDTO(Students student) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(student.getId());
        dto.setFname(student.getFname());
        dto.setLname(student.getLname());
        dto.setTown(student.getTown());

        List<Long> courseIds = student.getCourses().stream()
                .map(Courses::getId)
                .collect(Collectors.toList());
        dto.setCourseIds(courseIds);
        return dto;
    }
}
