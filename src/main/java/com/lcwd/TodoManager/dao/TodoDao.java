package com.lcwd.TodoManager.dao;


import com.lcwd.TodoManager.helper.Helper;
import com.lcwd.TodoManager.modle.Todo;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TodoDao  {

    Logger logger= LoggerFactory.getLogger(TodoDao.class);


    private JdbcTemplate template;

    public TodoDao(@Autowired JdbcTemplate template) {
        this.template = template;

        String createtable="create table if not exists todos(id int primary key,title varchar(50),content varchar(100),status varchar(10),addedDate datetime,todoDate datetime) ";
        int update = template.update(createtable);
        logger.info("create table {}",update);
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Todo saveTodo( Todo todo){
        String insertQuery="insert into todos(id,title,content,status,addedDate,todoDate) values(?,?,?,?,?,?)";

       int rows =template.update(insertQuery, todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(),todo.getTodoDate());

        logger.info("information todo: {} inserted", rows);

        return todo;
    }
    
    public Todo getSingletodo(int id) throws ParseException {
        String query="select * from todos where id=?";
        Todo todo = template.queryForObject(query, new TodoRowMapper(), id);

//        Map<String,  Object> tododata = template.queryForMap(query, id);
        logger.info("todo data {} ",todo);

//        Todo todo=new Todo();
//
//        todo.setId(((int)tododata.get("id")));
//        todo.setTitle(((String)tododata.get("title")));
//        todo.setContent(((String)tododata.get("content")));
//
//        todo.setAddedDate(Helper.parseDate((LocalDateTime) tododata.get("addedDate")));
//        todo.setTodoDate(Helper.parseDate((LocalDateTime) tododata.get("todoDate")));

        return todo;

    }

    public List<Todo> getAllTodo(){
        String query="select * from todos";
        List<Todo> todo = template.query(query, new TodoRowMapper());

        return todo;
//        List<Map<String,  Object>> maps = template.queryForList(query);
//
//        List<Todo> todos = maps.stream().map((map) -> {
//            Todo todo = new Todo();
//
//            todo.setId(((int) map.get("id")));
//            todo.setTitle(((String) map.get("title")));
//            todo.setContent(((String) map.get("content")));
//
//            try {
//                todo.setAddedDate(Helper.parseDate((LocalDateTime) map.get("addedDate")));
//                todo.setTodoDate(Helper.parseDate((LocalDateTime) map.get("todoDate")));
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//
//
//            return todo;
//        }).collect(Collectors.toList());

//        return todos;
    }

    public Todo updateTodo(int id, Todo newtodo){
        String query="update todos set title=?,content=?, status=?, addeddate=?, tododate=? where id=?";
        int update = template.update(query, newtodo.getTitle(), newtodo.getContent(), newtodo.getStatus(), newtodo.getAddedDate(), newtodo.getTodoDate(), id);
        logger.info("update data{}",update);

        return newtodo;
    }

    public void deletTodo(int id){
        String query="delete from todos where id=?";
        int update = template.update(query, id);
        logger.info("delete {}",update);

    }

    public void deleteMultiple(int ids[]){
        String query="delete from todos where id=?";
        int[] ints = template.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                int id = ids[i];
                ps.setInt(1, id);
            }

            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });
        for (int i :ints){
            logger.info("Delete {}",i);
        }
    }
}
