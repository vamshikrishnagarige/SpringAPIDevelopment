package com.vamshi.learningspring.SpringAPIDevelopment.repository;

import com.vamshi.learningspring.SpringAPIDevelopment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
