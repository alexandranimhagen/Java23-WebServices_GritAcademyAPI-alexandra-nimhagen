package com.example.GritAcademyAPI.DataTransfers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CoursesDTO {
    private Long id;
    private String name;
    private String description;
    private List<String> studentNames;
}
