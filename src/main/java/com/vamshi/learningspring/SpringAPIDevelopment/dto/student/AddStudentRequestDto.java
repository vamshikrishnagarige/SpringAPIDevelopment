package com.vamshi.learningspring.SpringAPIDevelopment.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Author: Vamshi Krishna Garige
 * Description: Learning purpose.
 * Date: 25-10-2025
 */
@Data
public class AddStudentRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
