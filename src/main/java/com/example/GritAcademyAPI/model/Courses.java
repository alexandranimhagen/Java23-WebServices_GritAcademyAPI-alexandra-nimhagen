package com.example.GritAcademyAPI.model;

import com.example.GritAcademyAPI.model.Students;
import jakarta.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "courses")
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Courses {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;


    @ManyToMany(mappedBy = "courses")

    private Set<Students> students = new HashSet<>();
}