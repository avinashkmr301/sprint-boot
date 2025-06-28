package com.avi.persisting_an_entity.repository;

import com.avi.persisting_an_entity.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
