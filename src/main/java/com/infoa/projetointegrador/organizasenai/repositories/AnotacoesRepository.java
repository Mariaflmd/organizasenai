package com.infoa.projetointegrador.organizasenai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoa.projetointegrador.organizasenai.models.Anotacoes;

@Repository
public interface AnotacoesRepository extends JpaRepository<Anotacoes, Integer>{
    
}
