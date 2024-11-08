package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "reactivos")
public class Reactivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "unidad", nullable = false)
    private String unidad;

    @Column(name = "cantidad", nullable = false)
    private Double cantidad;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    // Constructores
    public Reactivo() {
    }

    public Reactivo(String nombre, String codigo, String unidad, Double cantidad, Fabricante fabricante, Proveedor proveedor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.fabricante = fabricante;
        this.proveedor = proveedor;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
