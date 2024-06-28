package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.model.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends CrudRepository<Courses, Long> {

    List<Courses> findByName(String name);
    List<Courses> findByNameContaining(String title);
    List<Courses> findByDescriptionContaining(String description);


}