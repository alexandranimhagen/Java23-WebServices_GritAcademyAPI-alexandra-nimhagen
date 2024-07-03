package com.example.GritAcademyAPI.DataTransfers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCoursesDTO {
    private Long id;
    private Long studentId;
    private String studentName;
    private Long courseId;
    private String courseName;
}
