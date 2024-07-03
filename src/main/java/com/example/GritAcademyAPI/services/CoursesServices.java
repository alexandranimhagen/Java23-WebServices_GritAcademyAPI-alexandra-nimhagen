package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.DataTransfers.CoursesDTO;
import com.example.GritAcademyAPI.exception.ResourceNotFoundException;
import com.example.GritAcademyAPI.mappers.CoursesMapper;
import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesServices {

    private final CoursesRepository coursesRepository;

    public CoursesServices(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<CoursesDTO> getAllCourses() {
        return coursesRepository.findAll().stream()
                .map(CoursesMapper::toCoursesDTO)
                .collect(Collectors.toList());
    }

    public CoursesDTO getCourseById(Long id) {
        Courses course = coursesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        return CoursesMapper.toCoursesDTO(course);
    }

    public List<CoursesDTO> getCoursesByName(String name) {
        return coursesRepository.findByNameContainingIgnoreCase(name).stream()
                .map(CoursesMapper::toCoursesDTO)
                .collect(Collectors.toList());
    }

    public List<CoursesDTO> getCoursesByDescription(String description) {
        return coursesRepository.findByDescriptionContainingIgnoreCase(description).stream()
                .map(CoursesMapper::toCoursesDTO)
                .collect(Collectors.toList());
    }

    public CoursesDTO createCourse(CoursesDTO coursesDTO) {
        Courses course = new Courses();
        course.setName(coursesDTO.getName());
        course.setDescription(coursesDTO.getDescription());
        Courses savedCourse = coursesRepository.save(course);
        return CoursesMapper.toCoursesDTO(savedCourse);
    }

    public void deleteCourse(Long id) {
        Courses course = coursesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        coursesRepository.delete(course);
    }
}
