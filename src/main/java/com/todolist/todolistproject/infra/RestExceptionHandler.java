package com.todolist.todolistproject.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.todolist.todolistproject.exceptions.TarefaNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(TarefaNotFoundException.class)
    private ResponseEntity<String> tarefaNotFound(TarefaNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não foi encontrada");
    }
}
