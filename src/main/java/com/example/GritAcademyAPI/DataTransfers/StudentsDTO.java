package com.example.GritAcademyAPI.DataTransfers;

import com.example.GritAcademyAPI.DataTransfers.CoursesDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentsDTO {

    private Long id;
    private String fname;
    private String lname;
    private String town;
    List<CoursesDTO> courses;

}