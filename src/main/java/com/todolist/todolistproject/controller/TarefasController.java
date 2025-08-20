package com.todolist.todolistproject.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolistproject.models.Tarefas;
import com.todolist.todolistproject.service.TarefasService;

@RestController
@RequestMapping("/api/tarefas")
public class TarefasController {
    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService){
        this.tarefasService = tarefasService;
    }

    @GetMapping //GET
    public List<Tarefas> listarTarefas(){
        return tarefasService.listarTarefas();
    }

    @GetMapping("/{id}") //GET por id
    public Tarefas listarTarefaPorId(@PathVariable Long id){
        return tarefasService.listarPorId(id);
    }

    @PostMapping //POST
    public Tarefas adicionarTarefa(@RequestBody Tarefas tarefa){
        return tarefasService.adicionarTarefa(tarefa);
    }

    @DeleteMapping("/{id}") //DELETE
    public void deletarTarefaPorId(@PathVariable Long id){
        tarefasService.deletarTarefa(id);

    }

    @PutMapping("/{id}") //PUT
    public ResponseEntity<Tarefas> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefas tarefaAtualizada){
        Tarefas tarefa = tarefasService.atualizarTarefa(id, tarefaAtualizada);
        return ResponseEntity.ok(tarefa);
    }



}
