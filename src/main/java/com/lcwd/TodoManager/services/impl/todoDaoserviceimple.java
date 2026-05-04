package com.lcwd.TodoManager.services.impl;

import com.lcwd.TodoManager.dao.TodoDao;
import com.lcwd.TodoManager.modle.Todo;
import com.lcwd.TodoManager.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
//@Primary
public class todoDaoserviceimple implements TodoService {

    @Autowired
    private TodoDao todoDao;
    @Override
    public Todo createtodo(Todo todo) {
        return todoDao.saveTodo(todo);
    }

    @Override
    public List<Todo> getAlltodo() {
        return todoDao.getAllTodo();
    }

    @Override
    public Todo getSingle(int todoId) throws ParseException {
        return todoDao.getSingletodo(todoId);
    }

    @Override
    public Todo getUpdatetodo(int todosId, Todo todo) {
        return todoDao.updateTodo(todosId, new Todo());
    }

    @Override
    public void deleteTodos(int todosId) {
        todoDao.deletTodo(todosId);

    }
}
