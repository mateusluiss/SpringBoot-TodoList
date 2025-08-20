package com.todolist.todolistproject.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.todolist.todolistproject.exceptions.TarefaNotFoundException;

@ControllerAdvice
public class RestExceptionHandler{

    @ExceptionHandler(TarefaNotFoundException.class)
    public ResponseEntity<String> handleTarefaNotFound(TarefaNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
