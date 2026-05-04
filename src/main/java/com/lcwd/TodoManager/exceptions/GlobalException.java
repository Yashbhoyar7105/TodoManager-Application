package com.lcwd.TodoManager.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    Logger logger= LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> bullpointerException(NullPointerException ex){
        logger.info("it is handfling null pointer exception " );
        logger.info("error", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResorceNotFound.class)
    public ResponseEntity<ExceptionResponse> ResponseNotFoundException(ResorceNotFound ex){
        logger.info("Error {}", ex.getMessage());
        ExceptionResponse response=new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
