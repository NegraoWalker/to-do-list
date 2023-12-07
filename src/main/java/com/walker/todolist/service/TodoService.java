package com.walker.todolist.service;

import com.walker.todolist.entity.Todo;
import com.walker.todolist.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo create(Todo todo){
        return todoRepository.save(todo);
    }
    public Todo findById(Long id){
        return todoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Tarefa de id = [%s] não encontrada!")));
    }
}
