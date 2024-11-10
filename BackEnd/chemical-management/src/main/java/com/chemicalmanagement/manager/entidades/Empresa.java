package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "numContacto", nullable = false)
    private String numContacto;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "pais", nullable = false)
    private String pais;

    // Relación bidireccional con Usuario
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios;

    // Constructor sin parámetros
    public Empresa() {}

    // Constructor con parámetros
    public Empresa(String nombre, String numContacto, String direccion, String pais) {
        this.nombre = nombre;
        this.numContacto = numContacto;
        this.direccion = direccion;
        this.pais = pais;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numContacto='" + numContacto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
