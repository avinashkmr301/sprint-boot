package com.avi.persisting_an_entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.avi.persisting_an_entity.entity.Student;

public interface MyCustomRepostory extends Repository<Student, Long> {

    // Custom method to save a student
    Student save(Student student);

    // Custom method to find a student by their ID
    Optional<Student> findById(Long id);

    // Custom method to find all students
    List<Student> findAll();

    // Custom method to find a student by their enrollment ID
    Student findByEnrollmentId(String enrollmentId);

    // Custom method to delete a student by their enrollment ID
    void deleteByEnrollmentId(String enrollmentId);
    
}
