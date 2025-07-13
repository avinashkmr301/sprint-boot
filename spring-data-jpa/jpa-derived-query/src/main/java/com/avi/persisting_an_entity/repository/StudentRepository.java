package com.avi.persisting_an_entity.repository;

import com.avi.persisting_an_entity.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    // derived query
    Student findByEnrollmentId(String enrollmentId);

    List<Student> findByEnrollmentIdStartingWithAndNameLike(String enrollId, String name);

    List<Student> findFirst2ByEnrollmentIdStartingWithAndNameLike(String enrollId, String name);

    //JPQL below one OR same we can write as namedQuery in Entity
    @Query("select s from Student s where s.name = :name") // jpql use for long query
    List<Student> findByName(String name);

    //native query
    @Query(value = "select * from student where name like %?", nativeQuery = true)
    List<Student> findByNameEndingWith(String name);

}
