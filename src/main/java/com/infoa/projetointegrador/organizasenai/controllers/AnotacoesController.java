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

import com.infoa.projetointegrador.organizasenai.models.Anotacoes;
import com.infoa.projetointegrador.organizasenai.services.AnotacoesService;


@RestController
@RequestMapping("/anotacoes")
public class AnotacoesController {

            
    @Autowired
    private AnotacoesService anotacoesService;

    @GetMapping("/count")
    public Long contador() {
        return anotacoesService.contador();
    }

    @PostMapping("salvar")
    public Anotacoes salvar(@RequestBody Anotacoes anotacoes) {
        return anotacoesService.salvar(anotacoes);
    }
    
    

    @DeleteMapping("/delete/{id}")
    public String deletar (@PathVariable Integer id){
        boolean deletou = anotacoesService.deletar(id);
        if (deletou) {
            return "nota removida com sucesso";
        }
        return "Falha ao remover nota";
    }

    @GetMapping("/buscar/{id}")
    public Anotacoes  buscarPorId(@PathVariable Integer id) {
        return anotacoesService.buscarPorId(id);
    }


    @GetMapping("/listar")
    public List<Anotacoes>listarTodos() {
        return anotacoesService.listarTodos();
    }

    @PutMapping("/atualizar/{id}")
    public Anotacoes atualizar(@PathVariable Integer id, @RequestBody Anotacoes anotacoes ){
        return anotacoesService.atualizar(anotacoes, id);
    }
}
    



