package com.lcwd.TodoManager.services.impl;

import com.lcwd.TodoManager.exceptions.ResorceNotFound;
import com.lcwd.TodoManager.modle.Todo;
import com.lcwd.TodoManager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoServicesimpl implements TodoService {

    List<Todo> todos= new ArrayList<>();

    Logger logger= LoggerFactory.getLogger(TodoServicesimpl.class);
    public Todo createtodo(Todo todo){
        todos.add(todo);
        logger.info("todos {}", todos);
        return todo;
    }

    public List<Todo> getAlltodo() {
        return todos;
    }

    public Todo getSingle(int todoId) {
        Todo todo = todos.stream().filter(t -> todoId == t.getId()).findAny().orElseThrow(()-> new ResorceNotFound("id is not found ", HttpStatus.NOT_FOUND));
        logger.info("todo {}", todo);
        return todo;

    }

    public Todo getUpdatetodo(int todosId, Todo todo) {

        List<Todo> newupdatelist=todos.stream().map(t->{
            if(t.getId()==todosId){

                t.setTitle(todo.getTitle());
                t.setContent(todo.getContent());
                t.setStatus(todo.getStatus());
                return t;
            }else{
                return t;
            }
        }).collect(Collectors.toList());

       todos= newupdatelist;
       todo.setId(todosId);
       return todo;

    }

    public void deleteTodos(int todosId) {
        logger.info("Deleting Todo");
        List<Todo> newList = todos.stream().filter(t -> t.getId() != todosId).collect(Collectors.toList());
        todos =newList;
    }
}
