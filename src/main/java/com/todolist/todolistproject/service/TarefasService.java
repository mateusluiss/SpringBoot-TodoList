package com.todolist.todolistproject.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.todolist.todolistproject.exceptions.TarefaNotFoundException;
import com.todolist.todolistproject.models.Tarefas;
import com.todolist.todolistproject.repository.TarefasRepository;

@Service
public class TarefasService {
    private TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository){
        this.tarefasRepository = tarefasRepository;
    }

    public List<Tarefas> listarTarefas(){
        return tarefasRepository.findAll();
    }

    public Tarefas listarPorId(Long id){
        return tarefasRepository.findById(id)
            .orElseThrow(() -> new TarefaNotFoundException("Tarefa com ID "+id+" não foi encontrada."));
    }

    public Tarefas adicionarTarefa(Tarefas tarefa){
        return tarefasRepository.save(tarefa);
    }

    public void deletarTarefa(Long id){
        tarefasRepository.findById(id)
            .orElseThrow(() -> new TarefaNotFoundException("Tarefa com ID "+id+" não foi encontrada"));
        
        tarefasRepository.deleteById(id);
    }

    public Optional<Tarefas> atualizarTarefa(Long id, Tarefas tarefaAtualizada){
        return tarefasRepository.findById(id)
            .map(tarefa -> {
                tarefa.setTitulo(tarefaAtualizada.getTitulo());
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setConcluida(tarefaAtualizada.getConcluida());
                return tarefasRepository.save(tarefa);
            });

        

    }
}
