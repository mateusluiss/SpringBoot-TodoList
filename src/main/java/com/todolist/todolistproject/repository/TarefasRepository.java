package com.todolist.todolistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolistproject.models.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long>{
    
}
