package com.vamshi.learningspring.SpringAPIDevelopment.service.studentService.impl;

import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.StudentDto;
import com.vamshi.learningspring.SpringAPIDevelopment.entity.Students;
import com.vamshi.learningspring.SpringAPIDevelopment.repository.StudentRepository;
import com.vamshi.learningspring.SpringAPIDevelopment.service.studentService.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Vamshi Krishna Garige
 * Description: Learning purpose.
 * Date: 22-10-2025
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Students> students = studentRepository.findAll();

        return students
                .stream()
                .map(student ->
                    new StudentDto(student.getId(), student.getName())
                )
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Students students = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
        return modelMapper.map(students, StudentDto.class);
    }
}
