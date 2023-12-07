package com.walker.todolist.controller;

import com.walker.todolist.entity.Todo;
import com.walker.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createToDo(@RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> findByIdToDo(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<Todo>> findByAllToDo(){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findByAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateToDo(@PathVariable Long id, @RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(todoService.update(id,todo.getDescricao(),todo.getNome(),todo.getRealizado(),todo.getPrioridade()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id){
        todoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
