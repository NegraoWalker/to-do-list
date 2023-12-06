package com.walker.todolist.controller;

import com.walker.todolist.entity.Todo;
import com.walker.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createToDo(@RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }
}
