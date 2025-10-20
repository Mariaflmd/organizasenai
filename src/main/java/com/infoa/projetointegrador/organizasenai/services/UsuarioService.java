package com.infoa.projetointegrador.organizasenai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoa.projetointegrador.organizasenai.models.Usuario;
import com.infoa.projetointegrador.organizasenai.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;
    
    public Long contador() {
        return usuarioRepository.count();
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean deletar(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        if(usuario != null) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).get(); 
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Usuario usuario, Integer id) { 
        Usuario e = buscarPorId(id);
        if (e != null) {
            usuario.setId(id); 
            return usuarioRepository.save(usuario); 
        }
        return null;
    }

}
