package com.avi.learn_spring_boot.controller;

import com.avi.learn_spring_boot.config.CurrencyServiceConfiguration;
import com.avi.learn_spring_boot.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyServiceController {

    // API: /courses
    // Course: id, name, author

    @Autowired
    CurrencyServiceConfiguration serviceConfiguration;

    @RequestMapping("/currency-service")
    public CurrencyServiceConfiguration retrieveAllCourses(){
       return serviceConfiguration;
    }
}
