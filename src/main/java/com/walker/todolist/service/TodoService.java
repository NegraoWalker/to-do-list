package com.walker.todolist.service;

import com.walker.todolist.entity.Todo;
import com.walker.todolist.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Todo> findByAll(){
        return todoRepository.findAll();
    }
    public Todo update(Long id, String newDescricao, String newNome, String newRealizado, String newPrioridade ){
        Todo findTodo = findById(id);
        findTodo.setDescricao(newDescricao);
        findTodo.setNome(newNome);
        findTodo.setRealizado(newRealizado);
        findTodo.setPrioridade(newPrioridade);
        return todoRepository.save(findTodo);
    }

    public void delete(Long id){
        Todo findTodo = findById(id);
        todoRepository.delete(findTodo);
        System.out.println("DEBUG: FINALIZOU O MÉTODO DELETE DO SERVICE");
    }
}
