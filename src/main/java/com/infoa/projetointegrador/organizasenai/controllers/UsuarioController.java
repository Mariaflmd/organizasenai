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

import com.infoa.projetointegrador.organizasenai.models.Usuario;
import com.infoa.projetointegrador.organizasenai.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
        
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/count")
    public Long contador() {
        return usuarioService.contador();
    }

    @PostMapping("salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }
    
    

    @DeleteMapping("/delete/{id}")
    public String deletar (@PathVariable Integer id){
        boolean deletou = usuarioService.deletar(id);
        if (deletou) {
            return "usuario removido com sucesso";
        }
        return "Falha ao remover usuario";
    }

    @GetMapping("/buscar/{id}")
    public Usuario  buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }


    @GetMapping("/listar")
    public List<Usuario>listarTodos() {
        return usuarioService.listarTodos();
    }

    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario ){
        return usuarioService.atualizar(usuario, id);
    }
}