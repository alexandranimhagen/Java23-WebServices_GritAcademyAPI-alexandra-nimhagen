package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.StudentCourses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoursesRepository extends CrudRepository<StudentCourses, Integer> {

}