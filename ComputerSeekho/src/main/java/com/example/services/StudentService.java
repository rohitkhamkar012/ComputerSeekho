package com.example.services;

import com.example.dto.StudentDTO;
import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO dto);

    StudentDTO getStudentById(Integer id);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(Integer id, StudentDTO dto);

    void deleteStudent(Integer id);
}
