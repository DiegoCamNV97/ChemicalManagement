package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dni", nullable = false, length = 100)
    private String dni;

    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 80)
    private String apellidos;

    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "correoPersonal", nullable = false, length = 200)
    private String correoPersonal;

    @Column(name = "correoInstitucional", nullable = false, length = 200, unique = true)
    private String correoInstitucional;

    @Column(name = "tipoUsuario", nullable = false, length = 90)
    private String tipoUsuario;

    @Column(name = "user", nullable = false, length = 100, unique = true)
    private String user;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RegistroUso> registroUso;

    //Constructor sin argumentos
    public Usuario(){

    }

    //Constructor

    public Usuario(Integer id, String dni, String nombres, String apellidos, Date fechaNacimiento,
            String correoPersonal, String correoInstitucional, String tipoUsuario, String user, String password,
            List<RegistroUso> registroUso) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoPersonal = correoPersonal;
        this.correoInstitucional = correoInstitucional;
        this.tipoUsuario = tipoUsuario;
        this.user = user;
        this.password = password;
        this.registroUso = registroUso;
    }

    //Getters y Setters
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
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<RegistroUso> getRegistroUso() {
        return registroUso;
    }

    public void setRegistroUso(List<RegistroUso> registroUso) {
        this.registroUso = registroUso;
    }
}
