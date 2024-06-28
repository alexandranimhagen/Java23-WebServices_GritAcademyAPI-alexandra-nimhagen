package com.example.GritAcademyAPI.repository;

import com.example.GritAcademyAPI.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Long> {
}
