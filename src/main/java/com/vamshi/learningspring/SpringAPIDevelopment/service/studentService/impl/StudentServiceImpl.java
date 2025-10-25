package com.vamshi.learningspring.SpringAPIDevelopment.service.studentService.impl;

import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.AddStudentRequestDto;
import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.StudentDto;
import com.vamshi.learningspring.SpringAPIDevelopment.entity.Student;
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
        List<Student> students = studentRepository.findAll();

        return students
                .stream()
                .map(student ->
                    new StudentDto(student.getId(), student.getName(), student.getEmail())
                )
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto addNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
//        Student newStudent = StudentMapper.INSTANCE.addStudentDtoToStudentEntity(addStudentRequestDto);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }
}
