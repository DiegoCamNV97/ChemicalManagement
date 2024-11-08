package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registrouso")
public class RegistroUso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double cantidadUtilizada;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaUso;

    @Column(nullable = false, length = 500)
    private String responsable;

    @Column(nullable = false, length = 90)
    private String unidadMedida;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "reactivos_id", nullable = false)
    private Reactivos reactivos;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(Double cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Reactivos getReactivos() {
        return reactivos;
    }

    public void setReactivos(Reactivos reactivos) {
        this.reactivos = reactivos;
    }
}
