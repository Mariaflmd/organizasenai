package com.infoa.projetointegrador.organizasenai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoa.projetointegrador.organizasenai.models.Anotacoes;
import com.infoa.projetointegrador.organizasenai.repositories.AnotacoesRepository;

@Service
public class AnotacoesService {
    
    @Autowired
    private AnotacoesRepository anotacoesRepository;
    
    public Long contador() {
        return anotacoesRepository.count();
    }

    public Anotacoes salvar(Anotacoes anotacoes) {
        return anotacoesRepository.save(anotacoes);
    }

    public boolean deletar(Integer id) {
        Anotacoes anotacoes = anotacoesRepository.findById(id).get();
        if(anotacoes != null) {
            anotacoesRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Anotacoes buscarPorId(Integer id) {
        return anotacoesRepository.findById(id).get();
    }

    public List<Anotacoes> listarTodos() {
        return anotacoesRepository.findAll();
    }

    public Anotacoes atualizar(Anotacoes anotacoes, Integer id) { 
        Anotacoes e = buscarPorId(id);
        if (e != null) {
            anotacoes.setId(id); 
            return anotacoesRepository.save(anotacoes); 
        }
        return null;
    }
}