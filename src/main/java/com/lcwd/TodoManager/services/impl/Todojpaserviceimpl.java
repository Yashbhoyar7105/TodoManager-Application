package com.lcwd.TodoManager.services.impl;

import com.lcwd.TodoManager.dao.TodoRepository;
import com.lcwd.TodoManager.exceptions.ResorceNotFound;
import com.lcwd.TodoManager.modle.Todo;
import com.lcwd.TodoManager.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
@Primary
public class Todojpaserviceimpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createtodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAlltodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getSingle(int todoId) throws ParseException {
        return todoRepository.findById(todoId).orElseThrow(()->new ResorceNotFound("given todo is not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Todo getUpdatetodo(int todoId, Todo todo) {

        Todo todo1 = todoRepository.findById(todoId).orElseThrow(() -> new ResorceNotFound("given todo is not found", HttpStatus.NOT_FOUND));
       todo1.setTitle(todo.getTitle());
       todo1.setContent(todo.getContent());
       todo1.setStatus(todo.getStatus());
       todo1.setTodoDate(todo.getTodoDate());
        return todoRepository.save(todo1);
    }

    @Override
    public void deleteTodos(int todosId) {
        todoRepository.deleteById(todosId);

    }
}
