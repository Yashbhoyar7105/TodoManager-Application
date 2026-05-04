package com.lcwd.TodoManager;

import com.lcwd.TodoManager.dao.TodoDao;
import com.lcwd.TodoManager.modle.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

    Logger logger= LoggerFactory.getLogger(TodoManagerApplication.class);

    @Autowired
    private TodoDao todoDao;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
//        System.out.println("application start");
//        JdbcTemplate template = todoDao.getTemplate();
//        logger.info("template obj {}",template);

//        Todo todo=new Todo();
//        todo.setId(2);
//        todo.setTitle("python  cource");
//        todo.setContent("this is for begineer who can learn python ");
//        todo.setStatus("pending");
//        todo.setAddedDate(new Date());
//        todo.setTodoDate(new Date());
//
//        todoDao.saveTodo(todo);

//        Todo singletodo = todoDao.getSingletodo(1);
//        logger.info("todo {}",singletodo);
//        singletodo.setTitle("web dev for beginner");
//        singletodo.setContent("ha ha ha we are reaching 1 million students ");
//        singletodo.setStatus("done");
//        singletodo.setAddedDate(new Date());
//        singletodo.setTodoDate(new Date());
//
//
//        todoDao.updateTodo(2, singletodo);


//        List<Todo> allTodo = todoDao.getAllTodo();
//        logger.info("All todos {}", allTodo);

//        todoDao.deletTodo(2);

//        todoDao.deleteMultiple(new int[]{2,3});

    }
}
