package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.model.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Long> {

    List<Students> findByFname(String fname);

    List<Students> findByLname(String lname);

    List<Students> findByTown(String town);




}