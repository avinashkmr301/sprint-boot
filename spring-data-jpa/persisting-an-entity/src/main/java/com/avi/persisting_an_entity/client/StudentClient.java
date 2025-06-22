package com.avi.persisting_an_entity.client;

import com.avi.persisting_an_entity.entity.Student;
import com.avi.persisting_an_entity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentClient implements ApplicationRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //persisting a student
        Student student = new Student("Thanuja","THANU1234"); // transient-state
        Student returnedStudent = studentRepository.save(student);// persistent-state and once obj will get saved to DB => come to detached-state

        //Updating a student
        returnedStudent.setName("Thanuja P");
        Student updatedStudent = studentRepository.save(returnedStudent);

        //findById
        Optional<Student> studentOptional = studentRepository.findById(1L);
        System.out.println(studentOptional.get());

        //delete
        System.out.println("deleting...");
        studentRepository.delete(studentOptional.get());
    }
}
