package com.avi.learn_spring_boot.controller;

import com.avi.learn_spring_boot.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    // API: /courses
    // Course: id, name, author

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1,"AWS","Munna"),
                new Course(2,"Spring-boot","Munna"),
                new Course(3,"Learn GCP","John"),
                new Course(4,"Learn-Java","John"),
                new Course(5,"Learn-Hibernate","in28minute")
        );
    }
}
