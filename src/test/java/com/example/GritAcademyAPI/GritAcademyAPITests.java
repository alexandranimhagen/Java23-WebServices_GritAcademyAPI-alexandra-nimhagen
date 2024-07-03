package com.example.GritAcademyAPI;

import com.example.GritAcademyAPI.DataTransfers.StudentsCoursesDTO;
import com.example.GritAcademyAPI.model.Courses;
import com.example.GritAcademyAPI.model.Students;
import com.example.GritAcademyAPI.model.StudentsCourses;
import com.example.GritAcademyAPI.repository.CoursesRepository;
import com.example.GritAcademyAPI.repository.StudentsRepository;
import com.example.GritAcademyAPI.repository.StudentsCoursesRepository;
import com.example.GritAcademyAPI.services.StudentsCoursesServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GritAcademyAPITests {

    @Mock
    private StudentsCoursesRepository studentsCoursesRepository;

    @Mock
    private StudentsRepository studentsRepository;

    @Mock
    private CoursesRepository coursesRepository;

    @InjectMocks
    private StudentsCoursesServices studentsCoursesServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup mock data
        Students student = new Students();
        student.setId(1L);
        student.setFname("Anna");
        student.setLname("Karlsson");
        student.setTown("Stockholm");

        Courses course = new Courses();
        course.setId(1L);
        course.setName("Java Programming");
        course.setDescription("An introductory course on Java programming");

        StudentsCourses studentsCourses = new StudentsCourses();
        studentsCourses.setId(1L);
        studentsCourses.setStudent(student);
        studentsCourses.setCourse(course);

        when(studentsRepository.findById(1L)).thenReturn(Optional.of(student));
        when(coursesRepository.findById(1L)).thenReturn(Optional.of(course));
        when(studentsCoursesRepository.findById(1L)).thenReturn(Optional.of(studentsCourses));
        when(studentsCoursesRepository.save(any(StudentsCourses.class))).thenReturn(studentsCourses);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAllStudentsCourses() {
        // Mock data and interactions
        // Add assertions and verify interactions
    }

    @Test
    void testGetStudentsCoursesById() {
        StudentsCoursesDTO result = studentsCoursesServices.getStudentsCoursesById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(1L, result.getStudentId());
        assertEquals("Anna Karlsson", result.getStudentName());
        assertEquals(1L, result.getCourseId());
        assertEquals("Java Programming", result.getCourseName());

        verify(studentsCoursesRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateStudentsCourses() {
        StudentsCoursesDTO dto = new StudentsCoursesDTO();
        dto.setStudentId(1L);
        dto.setCourseId(1L);

        StudentsCoursesDTO result = studentsCoursesServices.createStudentsCourses(dto);

        assertNotNull(result);
        assertEquals(1L, result.getStudentId());
        assertEquals(1L, result.getCourseId());

        verify(studentsRepository, times(1)).findById(1L);
        verify(coursesRepository, times(1)).findById(1L);
        verify(studentsCoursesRepository, times(1)).save(any(StudentsCourses.class));
    }

    @Test
    void testUpdateStudentsCourses() {
        StudentsCoursesDTO dto = new StudentsCoursesDTO();
        dto.setStudentId(1L);
        dto.setCourseId(1L);

        StudentsCoursesDTO result = studentsCoursesServices.updateStudentsCourses(1L, dto);

        assertNotNull(result);
        assertEquals(1L, result.getStudentId());
        assertEquals(1L, result.getCourseId());

        verify(studentsRepository, times(1)).findById(1L);
        verify(coursesRepository, times(1)).findById(1L);
        verify(studentsCoursesRepository, times(1)).findById(1L);
        verify(studentsCoursesRepository, times(1)).save(any(StudentsCourses.class));
    }

    @Test
    void testDeleteStudentsCourses() {
        studentsCoursesServices.deleteStudentsCourses(1L);

        verify(studentsCoursesRepository, times(1)).findById(1L);
        verify(studentsCoursesRepository, times(1)).delete(any(StudentsCourses.class));
    }
}
