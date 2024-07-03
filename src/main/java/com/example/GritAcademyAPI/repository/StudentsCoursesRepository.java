package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.StudentsCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsCoursesRepository extends JpaRepository<StudentsCourses, Long> {
}
