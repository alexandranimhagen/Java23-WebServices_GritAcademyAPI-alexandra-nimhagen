package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses, Long> {
}
