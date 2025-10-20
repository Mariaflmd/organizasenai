package com.infoa.projetointegrador.organizasenai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infoa.projetointegrador.organizasenai.models.Tarefa;
import com.infoa.projetointegrador.organizasenai.services.TarefaService;


@RestController
public class Tarefacontroller {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/count")
    public Long contador() {
        return tarefaService.contador();
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id){
        boolean deletou = tarefaService.deletar(id);
        if(deletou){
            return "tarefa removida com sucesso";
        }
        return "Falha ao remover a tarefa";
    }

    @PostMapping("/salvar")
    public Tarefa salvar(@RequestBody Tarefa tarefa) {
        return tarefaService.salvar(tarefa);
    }
    
    @GetMapping("/buscar/{id}")
    public Tarefa buscarPorId(@PathVariable Integer id) {
        return tarefaService.buscarPorId(id);
    }
    
    @PutMapping("/atualizar/{id}")
    public Tarefa atualizar(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(tarefa, id);
    }

    @GetMapping("/listar")
    public List<Tarefa> listarTodos() {
        return tarefaService.listarTodos();
    }
}