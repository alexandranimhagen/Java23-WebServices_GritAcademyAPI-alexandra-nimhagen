package com.example.GritAcademyAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_courses")
@Data
public class StudentCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_id")
    private long courseId;

    @Column(name = "student_id")
    private long studentId;
}
