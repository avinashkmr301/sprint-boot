package com.avi.persisting_an_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.avi.persisting_an_entity.entity.Student;
import com.avi.persisting_an_entity.repository.MyCustomRepostory;

@SpringBootTest
class MainApplicationTest {

	@Autowired
	private MyCustomRepostory myCustomRepostory;

	@Test
	void testMyCustomRepository() {

		// Save
		// Create a new student
		 Student student = new Student("John Doe", "JD1234");
		 Student returnedStudent = myCustomRepostory.save(student);
		 assertNotNull(returnedStudent.getId());

		// Find a student by ID
		// Student foundStudent = myCustomRepostory.findById(1L).get();
		// assertEquals(1L, foundStudent.getId());
		myCustomRepostory.findById(1L).ifPresent(foundStudent -> {
			assertEquals(1L, foundStudent.getId());
			System.out.println(foundStudent);
		});

		// Find all students
		 List<Student> allStudents = myCustomRepostory.findAll();
		 assertEquals(1, allStudents.size());
		// allStudents.forEach(System.out::println);

		// Find a student by enrollment ID
		// Student studentByEnrollmentId = myCustomRepostory.findByEnrollmentId("JD1234");
		// System.out.println(studentByEnrollmentId);

		// Delete a student by enrollment ID
		// myCustomRepostory.deleteByEnrollmentId("JD1234");
	}

}
