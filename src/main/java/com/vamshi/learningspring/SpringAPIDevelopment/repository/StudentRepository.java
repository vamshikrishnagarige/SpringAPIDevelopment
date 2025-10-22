package com.vamshi.learningspring.SpringAPIDevelopment.repository;

import com.vamshi.learningspring.SpringAPIDevelopment.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
}
