package com.vamshi.learningspring.SpringAPIDevelopment.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

/**
 * Author: Vamshi Krishna Garige
 * Description: Learning purpose.
 * Date: 12-10-2025
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
//    private String email;
//    private Long departmentId;
//    private Long subjectId;
}

