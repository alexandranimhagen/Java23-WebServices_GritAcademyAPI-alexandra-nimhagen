package com.example.GritAcademyAPI.DataTransfers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentsDTO {
    private Long id;
    private String fname;
    private String lname;
    private String town;
    private List<Long> courseIds;
}
