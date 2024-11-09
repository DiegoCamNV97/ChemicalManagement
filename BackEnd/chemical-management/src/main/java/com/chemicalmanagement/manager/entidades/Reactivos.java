package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "reactivos")
public class Reactivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "qr", length = 45)
    private String qr;

    @Column(name = "ubicacion", length = 45)
    private String ubicacion;

    @Column(name = "nombreReactivo", length = 45)
    private String nombreReactivo;

    @Column(name = "otrosNombres", length = 45)
    private String otrosNombres;

    @Column(name = "presentacion", length = 45)
    private String presentacion;

    @Column(name = "unidadMedida", length = 45)
    private String unidadMedida;

    @Column(name = "lote", length = 80)
    private String lote;

    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "existencia")
    private Double existencia;

    @Column(name = "cas", length = 45)
    private String cas;

    @Column(name = "formula", length = 80)
    private String formula;

    @Column(name = "palabraAdvertencia", length = 45)
    private String palabraAdvertencia;

    @Column(name = "pictogramasSGA", length = 45)
    private String pictogramasSGA;

    @Column(name = "frasesH", length = 1000)
    private String frasesH;

    @Column(name = "frasesP", length = 1000)
    private String frasesP;

    @Column(name = "fichaDatosSeguridad", length = 4)
    private String fichaDatosSeguridad;

    @Column(name = "vigenciaFDS")
    @Temporal(TemporalType.DATE)
    private Date vigenciaFDS;

    @ManyToOne
    @JoinColumn(name = "Empresa_id", nullable = false)
    @JsonBackReference("empresa-reactivos")
    private Empresa empresa;

    @OneToMany(mappedBy = "reactivos")
    @JsonManagedReference("reactivos-registroUso")
    private List<RegistroUso> registrosUso;

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

    public String getOtrosNombres() {
        return otrosNombres;
    }

    public void setOtrosNombres(String otrosNombres) {
        this.otrosNombres = otrosNombres;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
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

    public Date getVigenciaFDS() {
        return vigenciaFDS;
    }

    public void setVigenciaFDS(Date vigenciaFDS) {
        this.vigenciaFDS = vigenciaFDS;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public List<RegistroUso> getRegistrosUso() {
        return registrosUso;
    }

    public void setRegistrosUso(List<RegistroUso> registrosUso) {
        this.registrosUso = registrosUso;
    }
}
