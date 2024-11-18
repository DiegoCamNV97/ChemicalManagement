package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "numContacto", nullable = false, unique = true)
    private String numContacto;

    @Column(name = "direccion", nullable = false, unique = true)
    private String direccion;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "numeroEmergencia", nullable = false)
    private String numeroEmergencia;

    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("fabricante")
    private List<Reactivo> reactivos;


    //Constructor Vacío

    public Fabricante() {}

    //Constructor

    public Fabricante(Integer id, String nombre, String numContacto, String direccion, String pais,
    String numeroEmergencia, List<Reactivo> reactivos) {
    this.id = id;
    this.nombre = nombre;
    this.numContacto = numContacto;
    this.direccion = direccion;
    this.pais = pais;
    this.numeroEmergencia = numeroEmergencia;
    this.reactivos = reactivos;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public List<Reactivo> getReactivos() {
        return reactivos;
    }

    public void setReactivos(List<Reactivo> reactivos) {
        this.reactivos = reactivos;
    }
}