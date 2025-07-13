package com.avi.persisting_an_entity.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
/*@NamedQuery(name = "Student.findByName",
            query = "select s from Student s where s.name = :name")
@NamedNativeQuery(name = "Student.findByNameEndingWith",
                  query = "select * from student where name like %?0")*/
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "enrollment_id",nullable = false,unique = true)
    private String enrollmentId;

    public Student() {
    }

    public Student(String name, String enrollmentId) {
        this.name = name;
        this.enrollmentId = enrollmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrollmentId='" + enrollmentId + '\'' +
                '}';
    }
}
