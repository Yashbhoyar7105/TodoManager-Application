package com.lcwd.TodoManager.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private String message;
    private HttpStatus status;
    private boolean sucess;

    public ExceptionResponse(String message, HttpStatus status, boolean sucess) {
        this.message = message;
        this.status = status;
        this.sucess = sucess;
    }

    public ExceptionResponse() {
    }

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

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
