package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reactivos")
public class Reactivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "qr", nullable = false)
    private String qr;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "nombreReactivo", nullable = false)
    private String nombreReactivo;

    @Column(name = "presentacion", nullable = false)
    private Double presentacion;

    @Column(name = "unidadMedida", nullable = false)
    private String unidadMedida;

    @Column(name = "lote", nullable = false)
    private String lote;

    @Column(name = "fechaFabricacion", nullable = false)
    private java.sql.Date fechaFabricacion;

    @Column(name = "fechaVencimiento", nullable = false)
    private java.sql.Date fechaVencimiento;

    @Column(name = "existencia", nullable = false)
    private Double existencia;

    @Column(name = "cas", nullable = false)
    private String cas;

    @Column(name = "formula", nullable = false)
    private String formula;

    @Column(name = "palabraAdvertencia", nullable = false)
    private String palabraAdvertencia;

    @Column(name = "pictogramasSGA")
    private String pictogramasSGA;

    @Column(name = "frasesH")
    private String frasesH;

    @Column(name = "frasesP")
    private String frasesP;

    @Column(name = "fichaDatosSeguridad", nullable = false)
    private String fichaDatosSeguridad;

    @Column(name = "vigenciaFDS", nullable = false)
    @JsonIgnoreProperties("usuario")
    private java.sql.Date vigenciaFDS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id", nullable = false)
    @JsonIgnoreProperties("reactivos")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "reactivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("reactivo")
    private List<RegistroUso> registroUsos;


    //Constructor Vacío

    public Reactivo() {}

    //Constructor

    public Reactivo(Integer id, String qr, String ubicacion, String nombreReactivo, Double presentacion,
            String unidadMedida, String lote, Date fechaFabricacion, Date fechaVencimiento, Double existencia,
            String cas, String formula, String palabraAdvertencia, String pictogramasSGA, String frasesH,
            String frasesP, String fichaDatosSeguridad, Date vigenciaFDS, Fabricante fabricante,
            List<RegistroUso> registroUsos) {
        this.id = id;
        this.qr = qr;
        this.ubicacion = ubicacion;
        this.nombreReactivo = nombreReactivo;
        this.presentacion = presentacion;
        this.unidadMedida = unidadMedida;
        this.lote = lote;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.existencia = existencia;
        this.cas = cas;
        this.formula = formula;
        this.palabraAdvertencia = palabraAdvertencia;
        this.pictogramasSGA = pictogramasSGA;
        this.frasesH = frasesH;
        this.frasesP = frasesP;
        this.fichaDatosSeguridad = fichaDatosSeguridad;
        this.vigenciaFDS = vigenciaFDS;
        this.fabricante = fabricante;
        this.registroUsos = registroUsos;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreReactivo() {
        return nombreReactivo;
    }

    public void setNombreReactivo(String nombreReactivo) {
        this.nombreReactivo = nombreReactivo;
    }

    public Double getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Double presentacion) {
        this.presentacion = presentacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public java.sql.Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(java.sql.Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public java.sql.Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(java.sql.Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getExistencia() {
        return existencia;
    }

    public void setExistencia(Double existencia) {
        this.existencia = existencia;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getPalabraAdvertencia() {
        return palabraAdvertencia;
    }

    public void setPalabraAdvertencia(String palabraAdvertencia) {
        this.palabraAdvertencia = palabraAdvertencia;
    }

    public String getPictogramasSGA() {
        return pictogramasSGA;
    }

    public void setPictogramasSGA(String pictogramasSGA) {
        this.pictogramasSGA = pictogramasSGA;
    }

    public String getFrasesH() {
        return frasesH;
    }

    public void setFrasesH(String frasesH) {
        this.frasesH = frasesH;
    }

    public String getFrasesP() {
        return frasesP;
    }

    public void setFrasesP(String frasesP) {
        this.frasesP = frasesP;
    }

    public String getFichaDatosSeguridad() {
        return fichaDatosSeguridad;
    }

    public void setFichaDatosSeguridad(String fichaDatosSeguridad) {
        this.fichaDatosSeguridad = fichaDatosSeguridad;
    }

    public java.sql.Date getVigenciaFDS() {
        return vigenciaFDS;
    }

    public void setVigenciaFDS(java.sql.Date vigenciaFDS) {
        this.vigenciaFDS = vigenciaFDS;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public List<RegistroUso> getRegistroUsos() {
        return registroUsos;
    }

    public void setRegistroUsos(List<RegistroUso> registroUsos) {
        this.registroUsos = registroUsos;
    }
}
