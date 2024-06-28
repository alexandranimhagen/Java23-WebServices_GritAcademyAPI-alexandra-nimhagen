package com.example.GritAcademyAPI.DataTransfers;

import com.example.GritAcademyAPI.DataTransfers.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {

    private Long id;
    private String name;
    private String description;
    private String title;
    List<StudentsDTO> students;

}