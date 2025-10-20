package com.infoa.projetointegrador.organizasenai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoa.projetointegrador.organizasenai.models.Notas;
import com.infoa.projetointegrador.organizasenai.repositories.NotasRepository;

@Service
public class NotasService {
    
    @Autowired
    private NotasRepository notasRepository;
    
    public Long contador() {
        return notasRepository.count();
    }

    public Notas salvar(Notas notas) {
        return notasRepository.save(notas);
    }

    public boolean deletar(Integer id) {
        Notas n = notasRepository.findById(id).get();
        if(n != null) {
            notasRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Notas buscarPorId(Integer id) {
        return notasRepository.findById(id).get(); 
    }

    public List<Notas> listarTodos() {
        return notasRepository.findAll();
    }

    public Notas atualizar(Notas notas, Integer id) {
        Notas n = buscarPorId(id);
        if (n != null) { 
            notas.setId(id); 
            return notasRepository.save(notas);
        }
        return null;
    }

}