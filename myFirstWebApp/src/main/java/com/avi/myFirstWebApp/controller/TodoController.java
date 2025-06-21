package com.avi.myFirstWebApp.controller;

import com.avi.myFirstWebApp.entity.Todo;
import com.avi.myFirstWebApp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //todo-list
    @RequestMapping("todo-list")
    public String getUserByName(ModelMap modelMap){
        List<Todo> todoList = todoService.findByUserName("Avinash");

        modelMap.addAttribute("todos", todoList);
        return "todoList";
    }
}
