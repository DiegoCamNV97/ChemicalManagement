package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "registroUso")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "usuario", "reactivo"})
public class RegistroUso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidadUtilizada", nullable = false)
    private Double cantidadUtilizada;

    @Column(name = "fechaUso", nullable = false)
    private Date fechaUso;

    @Column(name = "unidadMedida", nullable = false)
    private String unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "reactivos_id", referencedColumnName = "id", nullable = false),
        @JoinColumn(name = "reactivos_fabricante_id", referencedColumnName = "fabricante_id", nullable = false)
    })
    @JsonIgnoreProperties("registroUso")
    private Reactivo reactivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_id", nullable = false)
    @JsonIgnoreProperties("registroUso")
    private Usuario usuario;


    //Constructor Vacío

    public RegistroUso() {}

    //Contrsuctor

    public RegistroUso(Integer id, Double cantidadUtilizada, Date fechaUso, String unidadMedida, Reactivo reactivo,
            Usuario usuario) {
        this.id = id;
        this.cantidadUtilizada = cantidadUtilizada;
        this.fechaUso = fechaUso;
        this.unidadMedida = unidadMedida;
        this.reactivo = reactivo;
        this.usuario = usuario;
    }

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
}
