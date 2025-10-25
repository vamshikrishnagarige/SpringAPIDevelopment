package com.vamshi.learningspring.SpringAPIDevelopment.controller;

import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.AddStudentRequestDto;
import com.vamshi.learningspring.SpringAPIDevelopment.dto.student.StudentDto;
import com.vamshi.learningspring.SpringAPIDevelopment.service.studentService.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Vamshi Krishna Garige
 * Description: Learning purpose.
 * Date: 12-10-2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;

//    public StudentController(StudentServiceImpl studentService) {
//        this.studentService = studentService;
//    }

//    @GetMapping("/student")
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
//        return studentService.getAllStudents()
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

//    @PostMapping("/addStudent")
    @PostMapping
    public ResponseEntity<StudentDto> addNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addNewStudent(addStudentRequestDto));
    }
}
