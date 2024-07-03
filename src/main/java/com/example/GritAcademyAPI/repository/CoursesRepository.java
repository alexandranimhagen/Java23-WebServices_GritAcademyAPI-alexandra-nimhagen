package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
    List<Courses> findByNameContainingIgnoreCase(String name);
    List<Courses> findByDescriptionContainingIgnoreCase(String description);
}
