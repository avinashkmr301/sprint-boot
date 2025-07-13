package com.avi.persisting_an_entity;

import com.avi.persisting_an_entity.entity.Student;
import com.avi.persisting_an_entity.repository.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainApplicationTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeAll
    void populateDB(){
        Student student1 = new Student("Avinash kumar","AVI1234JAVA");
        Student student2 = new Student("Thanuja P","TAN1234AUTOMATION");
        Student student3 = new Student("Jayant Chaube","JAY1234TELECOM");
        Student student4 = new Student("Prabal Singh","PRA1234CPROGRAM");
        Student student5 = new Student("Kala","EEEKALA1234SAP");
        Student student6 = new Student("KBhudha singh","EEEBHU1234EEE");
        Student student7 = new Student("Kambal kumar","EEEKAM1234EEE");

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);
    }

    @AfterAll
    void dePopulateDB(){
        studentRepository.deleteAll();
    }

    @Test
    void testFindByEnrollmentId(){
        Student student = studentRepository.findByEnrollmentId("AVI1234JAVA");
        assertEquals("AVI1234JAVA", student.getEnrollmentId());
        System.out.println(student);
    }

    @Test
    void testFindByEnrolmentIdStartsWithAndNameLike(){
        List<Student> withAndNameLike = studentRepository.findByEnrollmentIdStartingWithAndNameLike("EEE", "K%");
        assertEquals(3,withAndNameLike.size());
    }

    @Test
    void testFindFirst2ByEnrollmentIdStartingWithAndNameLike(){
        List<Student> students = studentRepository.findFirst2ByEnrollmentIdStartingWithAndNameLike("EEE", "K%");
        assertTrue(students.size()==2);
        System.out.println(students);
    }

    //using JPQL query
    @Test
    void testFindByName(){
        List<Student> students = studentRepository.findByName("Prabal Singh");
        assertEquals("Prabal Singh",students.get(0).getName());
        System.out.println(students);
    }

    //using native query (sql)
    @Test
    void testFindByNameEndingWith(){
        List<Student> studentList = studentRepository.findByNameEndingWith("kumar");
        assertEquals("Avinash kumar",studentList.get(0).getName());
        System.out.println(studentList);
    }

}
