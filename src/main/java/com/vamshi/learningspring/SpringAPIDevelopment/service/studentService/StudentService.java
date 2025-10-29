package com.vamshi.learningspring.SpringAPIDevelopment.service.studentService;

import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.AddStudentRequestDto;
import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.StudentDto;

import java.util.List;
import java.util.Map;

/**
 * Author: Vamshi Krishna Garige
 * Description: Learning purpose.
 * Date: 12-10-2025
 */
public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto addNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto updateStudentRequestDto);

    StudentDto partiallyUpdateStudent(Long id, Map<String, Object> updates);
}
