package com.infoa.projetointegrador.organizasenai.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nota_primeiro_trimestre")
    private double notaPrimeiroTrimestre;

    @Column(name="nota_segundo_trimestre")
	private double notaSegundoTrimestre;

    @Column(name="nota_terceiro_trimestre")
	private double notaTerceiroTrimestre;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

public Notas () {} 

public Notas(double notaPrimeiroTrimestre, double notaSegundoTrimestre, double notaTerceiroTrimestre) {
    this.notaPrimeiroTrimestre = notaPrimeiroTrimestre;
    this.notaSegundoTrimestre = notaSegundoTrimestre;
    this.notaTerceiroTrimestre = notaTerceiroTrimestre;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public double getNotaPrimeiroTrimestre() {
    return notaPrimeiroTrimestre;
}

public void setNotaPrimeiroTrimestre(double notaPrimeiroTrimestre) {
    this.notaPrimeiroTrimestre = notaPrimeiroTrimestre;
}

public double getNotaSegundoTrimestre() {
    return notaSegundoTrimestre;
}

public void setNotaSegundoTrimestre(double notaSegundoTrimestre) {
    this.notaSegundoTrimestre = notaSegundoTrimestre;
}

public double getNotaTerceiroTrimestre() {
    return notaTerceiroTrimestre;
}

public void setNotaTerceiroTrimestre(double notaTerceiroTrimestre) {
    this.notaTerceiroTrimestre = notaTerceiroTrimestre;
}

public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}

}
