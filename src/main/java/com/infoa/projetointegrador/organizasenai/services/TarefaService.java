package com.infoa.projetointegrador.organizasenai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoa.projetointegrador.organizasenai.models.Tarefa;
import com.infoa.projetointegrador.organizasenai.repositories.TarefaRepository;

@Service
public class TarefaService {

    @Autowired 
    private TarefaRepository tarefaRepository;
    

    public Long contador() {
        return tarefaRepository.count();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public boolean deletar(Integer id) {
        Tarefa tarefa = tarefaRepository.findById(id).get();
        if(tarefa != null) {
            tarefaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    

    public Tarefa buscarPorId(Integer id) {
        return tarefaRepository.findById(id).get();
    }

   
    public List<Tarefa> listarTodos() {
        return tarefaRepository.findAll();
    }

    public Tarefa atualizar(Tarefa tarefa, Integer id ){
    Tarefa t = buscarPorId(id);
        if (t != null) {
            tarefa.setId(id);
            return tarefaRepository.save(tarefa); 
        }
        return null;
    }

   
    public boolean atualizarBoolean(Tarefa tarefa, Integer id) {
        if (tarefaRepository.existsById(id)) {
            tarefa.setId(id);
            tarefaRepository.save(tarefa);
            return true;
        }
        return false;
    }
}
