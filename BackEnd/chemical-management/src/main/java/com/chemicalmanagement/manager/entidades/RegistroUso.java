package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "registrouso")
public class RegistroUso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidadUtilizada")
    private Double cantidadUtilizada;

    @Column(name = "fechaUso")
    @Temporal(TemporalType.DATE)
    private Date fechaUso;

    @Column(name = "unidadMedida", length = 90)
    private String unidadMedida;

    @ManyToOne
    @JoinColumn(name = "Usuarios_id")
    @JsonBackReference("usuarios-registroUso")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "Reactivos_id")
    @JsonBackReference("reactivos-registroUso")
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
