package com.lcwd.TodoManager.exceptions;

import org.springframework.http.HttpStatus;

public class ResorceNotFound extends RuntimeException{

    private String message;
    private HttpStatus status;

    public ResorceNotFound(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public ResorceNotFound() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
