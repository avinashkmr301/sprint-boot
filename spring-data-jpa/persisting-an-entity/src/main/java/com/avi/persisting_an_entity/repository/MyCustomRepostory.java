package com.avi.persisting_an_entity.repository;

import com.avi.persisting_an_entity.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MyCustomRepostory extends Repository {
    Student save(Student student);

    Optional<Object> findById(long l);

    List<Student> findAll();

}
