package com.example.GritAcademyAPI.DataTransfers;

public class CoursesDTO {
    private Long id;
    private String name;

    // Standardkonstruktorn
    public CoursesDTO() {
    }

    // Konstruktor med parametrar
    public CoursesDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter och Setter metoder
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
