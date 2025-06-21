package com.avi.myFirstWebApp.service;

import com.avi.myFirstWebApp.entity.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1,"Avinash","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(1,"Avinash","Learn Java", LocalDate.now().plusMonths(1),false));
        todos.add(new Todo(1,"Avinash","Learn Microservice", LocalDate.now().plusWeeks(2),false));
    }

    public List<Todo> findByUserName(String name){
        return todos;
    }
}
