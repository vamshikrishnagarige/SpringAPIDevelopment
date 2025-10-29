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
import java.util.Map;

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

    @Override
    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exist by Id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto updateStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id"));

        modelMapper.map(updateStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto partiallyUpdateStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is invalid");
            }
        });

        Student savedStudent = studentRepository.save(student);

        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
