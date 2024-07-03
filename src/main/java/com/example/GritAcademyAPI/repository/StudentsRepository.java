package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students> findByFnameContainingIgnoreCase(String fname);
    List<Students> findByLnameContainingIgnoreCase(String lname);
    List<Students> findByTownContainingIgnoreCase(String town);
}
