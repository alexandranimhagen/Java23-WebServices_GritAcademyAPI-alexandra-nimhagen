package com.example.GritAcademyAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "studentCourses")
@Table(name = "studentCourses")
@Data
public class StudentCourses {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    @Column(name = "course_id")
    private long courseId;
    @Column(name = "student_id")
    private long studentId;



}