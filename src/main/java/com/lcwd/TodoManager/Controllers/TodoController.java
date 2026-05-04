package com.lcwd.TodoManager.Controllers;


import com.lcwd.TodoManager.modle.Todo;
import com.lcwd.TodoManager.services.TodoService;
import com.lcwd.TodoManager.services.impl.TodoServicesimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoServices;
    Random random= new Random();

    Logger logger= LoggerFactory.getLogger(TodoController.class);

    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
//        int id= random.nextInt(99999);
//        todo.setId(id);

//        String str=null;
//        logger.info(" {}",str.length());

//        Integer.parseInt("12yrtddyg2");

        Date currentDate= new Date();
        todo.setAddedDate(currentDate);
        logger.info("current date{}", currentDate);
        logger.info("todo date{}", todo.getTodoDate());
        logger.info("create todo");
        Todo todo1 = todoServices.createtodo(todo);


        return new ResponseEntity<>(todo1, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> alltodo = todoServices.getAlltodo();
        return  new ResponseEntity<>(alltodo, OK);
    }

    @GetMapping("/{todosId}")
    public ResponseEntity<Todo> getTodo(@PathVariable int todosId) throws ParseException {
        Todo singletodo = todoServices.getSingle(todosId);
        return new ResponseEntity<>(singletodo, OK);
    }

    @PutMapping("/{todosId}")
    public ResponseEntity<Todo> getUpdateTodo(@RequestBody Todo todowithnewdetails, @PathVariable int todosId ){

        Todo newtodo=todoServices.getUpdatetodo(todosId, todowithnewdetails);
        return ResponseEntity.ok(newtodo);
    }

    @DeleteMapping("/{todosId}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todosId){
        todoServices.deleteTodos(todosId);
        return ResponseEntity.ok("delete Succesfully");
    }

//    @ExceptionHandler(value={NullPointerException.class, NumberFormatException.class})
//    public ResponseEntity<String> nullPointer(Exception ex){
//        System.out.println(ex.getMessage());
//        System.out.println("null pointer exception generated"+ ex.getMessage());
//
//        return new ResponseEntity<>("exception is"+ ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
