package com.infoa.projetointegrador.organizasenai.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="anotacoes")
public class Anotacoes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="anotacao")
    private String anotacao;

public Anotacoes() {}

public Anotacoes(String anotacao) {
    this.anotacao = anotacao;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getAnotacao() {
    return anotacao;
}

public void setAnotacao(String anotacao) {
    this.anotacao = anotacao;
}

    
}
