package com.avi.persisting_an_entity.client;

import com.avi.persisting_an_entity.entity.Student;
import com.avi.persisting_an_entity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentClient implements ApplicationRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student student = new Student("Thanuja","THANU1234");
        studentRepository.save(student);
    }
}
