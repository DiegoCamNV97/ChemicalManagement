package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dni", nullable = false, length = 100)
    private String dni;

    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 80)
    private String apellidos;

    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "correoPersonal", nullable = false, length = 200)
    private String correoPersonal;

    @Column(name = "correoInstitucional", nullable = false, unique = true, length = 200)
    private String correoInstitucional;

    @Column(name = "tipoUsuario", nullable = false, length = 90)
    private String tipoUsuario;

    @Column(name = "usuario", nullable = false, unique = true, length = 500)
    private String usuario;

    @Column(name = "password", nullable = false, length = 500)
    private String password;

    // Relación con Empresa
    @ManyToOne
    @JoinColumn(name = "Empresa_id", nullable = false)
    @JsonBackReference
    private Empresa empresa;

    // Relación con RegistroUso
    @OneToMany(mappedBy = "usuarios")
    @JsonBackReference
    private List<RegistroUso> registroUsos;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<RegistroUso> getRegistroUsos() {
        return registroUsos;
    }

    public void setRegistroUsos(List<RegistroUso> registroUsos) {
        this.registroUsos = registroUsos;
    }
}
