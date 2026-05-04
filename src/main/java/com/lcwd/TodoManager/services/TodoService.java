package com.lcwd.TodoManager.services;

import com.lcwd.TodoManager.modle.Todo;

import java.text.ParseException;
import java.util.List;

public interface TodoService {

    public Todo createtodo(Todo todo);

    public List<Todo> getAlltodo();

    public Todo getSingle(int todoId) throws ParseException;

    public Todo getUpdatetodo(int todosId, Todo todo);

    public void deleteTodos(int todosId);
}
