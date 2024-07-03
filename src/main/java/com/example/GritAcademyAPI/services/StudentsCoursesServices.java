package com.example.GritAcademyAPI.services;

import com.example.GritAcademyAPI.DataTransfers.StudentsCoursesDTO;
import com.example.GritAcademyAPI.exception.ResourceNotFoundException;
import com.example.GritAcademyAPI.model.Students;
import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.model.StudentsCourses;
import com.example.GritAcademyAPI.repository.StudentsRepository;
import com.example.GritAcademyAPI.repository.CoursesRepository;
import com.example.GritAcademyAPI.repository.StudentsCoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsCoursesServices {

    private final StudentsCoursesRepository studentsCoursesRepository;
    private final StudentsRepository studentsRepository;
    private final CoursesRepository coursesRepository;

    public StudentsCoursesServices(StudentsCoursesRepository studentsCoursesRepository, StudentsRepository studentsRepository, CoursesRepository coursesRepository) {
        this.studentsCoursesRepository = studentsCoursesRepository;
        this.studentsRepository = studentsRepository;
        this.coursesRepository = coursesRepository;
    }

    public List<StudentsCoursesDTO> getAllStudentsCourses() {
        return studentsCoursesRepository.findAll().stream()
                .map(sc -> {
                    StudentsCoursesDTO dto = new StudentsCoursesDTO();
                    dto.setId(sc.getId());
                    dto.setStudentId(sc.getStudent().getId());
                    dto.setStudentName(sc.getStudent().getFname() + " " + sc.getStudent().getLname());
                    dto.setCourseId(sc.getCourse().getId());
                    dto.setCourseName(sc.getCourse().getName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public StudentsCoursesDTO getStudentsCoursesById(Long id) {
        StudentsCourses sc = studentsCoursesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentsCourses not found with id " + id));
        StudentsCoursesDTO dto = new StudentsCoursesDTO();
        dto.setId(sc.getId());
        dto.setStudentId(sc.getStudent().getId());
        dto.setStudentName(sc.getStudent().getFname() + " " + sc.getStudent().getLname());
        dto.setCourseId(sc.getCourse().getId());
        dto.setCourseName(sc.getCourse().getName());
        return dto;
    }

    public StudentsCoursesDTO createStudentsCourses(StudentsCoursesDTO studentsCoursesDTO) {
        Students student = studentsRepository.findById(studentsCoursesDTO.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentsCoursesDTO.getStudentId()));
        Courses course = coursesRepository.findById(studentsCoursesDTO.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + studentsCoursesDTO.getCourseId()));

        StudentsCourses sc = new StudentsCourses();
        sc.setStudent(student);
        sc.setCourse(course);

        StudentsCourses savedSc = studentsCoursesRepository.save(sc);
        studentsCoursesDTO.setId(savedSc.getId());
        return studentsCoursesDTO;
    }

    public StudentsCoursesDTO updateStudentsCourses(Long id, StudentsCoursesDTO studentsCoursesDTO) {
        StudentsCourses sc = studentsCoursesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentsCourses not found with id " + id));

        Students student = studentsRepository.findById(studentsCoursesDTO.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentsCoursesDTO.getStudentId()));
        Courses course = coursesRepository.findById(studentsCoursesDTO.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + studentsCoursesDTO.getCourseId()));

        sc.setStudent(student);
        sc.setCourse(course);
        StudentsCourses updatedSc = studentsCoursesRepository.save(sc);

        studentsCoursesDTO.setId(updatedSc.getId());
        return studentsCoursesDTO;
    }

    public void deleteStudentsCourses(Long id) {
        StudentsCourses studentsCourses = studentsCoursesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentsCourses not found with id " + id));
        studentsCoursesRepository.delete(studentsCourses);
    }
}
