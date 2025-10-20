package com.infoa.projetointegrador.organizasenai.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nomeCompleto")
    private String nomeCompleto;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    @Column(name="matricula")
    private String matricula;

    @Column(name="tipoUsuario")
    private String tipoUsuario;

public Usuario() {}

public Usuario(String nomeCompleto, String email, String senha, String matricula, String tipoUsuario) {
    this.nomeCompleto = nomeCompleto;
    this.email = email;
    this.senha = senha;
    this.matricula = matricula;
    this.tipoUsuario = tipoUsuario;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNomeCompleto() {
    return nomeCompleto;
}

public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getSenha() {
    return senha;
}

public void setSenha(String senha) {
    this.senha = senha;
}

public String getMatricula() {
    return matricula;
}

public void setMatricula(String matricula) {
    this.matricula = matricula;
}

public String getTipoUsuario() {
    return tipoUsuario;
}

public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
}


}
