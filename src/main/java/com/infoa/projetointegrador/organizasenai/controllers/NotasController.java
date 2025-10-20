package com.infoa.projetointegrador.organizasenai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoa.projetointegrador.organizasenai.models.Notas;
import com.infoa.projetointegrador.organizasenai.services.NotasService;


@RestController
@RequestMapping("/notas")
public class NotasController {
        
    @Autowired
    private NotasService notasService;

    @GetMapping("/count")
    public Long contador() {
        return notasService.contador();
    }

    @PostMapping("salvar")
    public Notas salvar(@RequestBody Notas notas) {
        return notasService.salvar(notas);
    }
    
    

    @DeleteMapping("/delete/{id}")
    public String deletar (@PathVariable Integer id){
        boolean deletou = notasService.deletar(id);
        if (deletou) {
            return "nota removida com sucesso";
        }
        return "Falha ao remover nota";
    }

    @GetMapping("/buscar/{id}")
    public Notas  buscarPorId(@PathVariable Integer id) {
        return notasService.buscarPorId(id);
    }


    @GetMapping("/listar")
    public List<Notas>listarTodos() {
        return notasService.listarTodos();
    }

    @PutMapping("/atualizar/{id}")
    public Notas atualizar(@PathVariable Integer id, @RequestBody Notas notas ){
        return notasService.atualizar(notas, id);
    }
}