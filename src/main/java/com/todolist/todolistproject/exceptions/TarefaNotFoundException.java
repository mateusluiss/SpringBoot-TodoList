package com.todolist.todolistproject.exceptions;

public class TarefaNotFoundException extends RuntimeException {
    public TarefaNotFoundException(String mensagem){
        super(mensagem);
    }
}
