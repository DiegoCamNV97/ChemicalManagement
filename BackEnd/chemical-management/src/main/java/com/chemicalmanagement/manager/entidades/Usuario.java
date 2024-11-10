package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "correoPersonal", nullable = false)
    private String correoPersonal;

    @Column(name = "correoInstitucional", nullable = false)
    private String correoInstitucional;

    @Column(name = "tipoUsuario", nullable = false)
    private String tipoUsuario;

    @Column(name = "user", nullable = false, unique = true)
    private String user;

    @Column(name = "password", nullable = false)
    private String password;

    // Relación con Empresa
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    // Constructor sin parámetros
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String dni, String nombres, String apellidos, Date fechaNacimiento,
                   String correoPersonal, String correoInstitucional, String tipoUsuario,
                   String user, String password, Empresa empresa) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoPersonal = correoPersonal;
        this.correoInstitucional = correoInstitucional;
        this.tipoUsuario = tipoUsuario;
        this.user = user;
        this.password = password;
        this.empresa = empresa;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correoPersonal='" + correoPersonal + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
