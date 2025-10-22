package com.vamshi.learningspring.SpringAPIDevelopment.service.studentService;

import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.StudentDto;

import java.util.List;

/**
 * Author: Vamshi Krishna Garige
 * Description: Learning purpose.
 * Date: 12-10-2025
 */
public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
}
