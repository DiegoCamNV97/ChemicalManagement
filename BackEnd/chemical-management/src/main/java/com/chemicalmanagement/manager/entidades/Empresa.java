package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String numContacto;

    @Column(length = 45)
    private String direccion;

    @Column(length = 100)
    private String numEmergencias;

    @Column(length = 45)
    private String tipo;

    @OneToMany(mappedBy = "empresa")
    @JsonManagedReference("empresa-usuarios")
    private List<Usuarios> usuarios;

    @OneToMany(mappedBy = "empresa")
    @JsonManagedReference("empresa-reactivos")
    private List<Reactivos> reactivos;

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

    public String getNumEmergencias() {
        return numEmergencias;
    }

    public void setNumEmergencias(String numEmergencias) {
        this.numEmergencias = numEmergencias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Reactivos> getReactivos() {
        return reactivos;
    }

    public void setReactivos(List<Reactivos> reactivos) {
        this.reactivos = reactivos;
    }
}
