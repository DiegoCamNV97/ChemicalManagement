package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registrouso")
public class RegistroUso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaUso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaUso;

    @Column(name = "cantidadUsada", nullable = false)
    private Double cantidadUsada;

    @Column(name = "observaciones")
    private String observaciones;

    // Relación con Reactivo
    @ManyToOne
    @JoinColumn(name = "reactivo_id", nullable = false)
    private Reactivo reactivo;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Constructor sin parámetros
    public RegistroUso() {}

    // Constructor con parámetros
    public RegistroUso(Date fechaUso, Double cantidadUsada, String observaciones, Reactivo reactivo, Usuario usuario) {
        this.fechaUso = fechaUso;
        this.cantidadUsada = cantidadUsada;
        this.observaciones = observaciones;
        this.reactivo = reactivo;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    public Double getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(Double cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Reactivo getReactivo() {
        return reactivo;
    }

    public void setReactivo(Reactivo reactivo) {
        this.reactivo = reactivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "RegistroUso{" +
                "id=" + id +
                ", fechaUso=" + fechaUso +
                ", cantidadUsada=" + cantidadUsada +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
