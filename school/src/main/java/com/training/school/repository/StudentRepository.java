package com.training.school.repository;

import com.training.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByCourse(String course);

    List<Student> findByStudentNameContaining(String studentName);


}
