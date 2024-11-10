package com.chemicalmanagement.manager.entidades;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "databasereactivos")
public class Reactivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreReactivo", nullable = false)
    private String nombreReactivo;

    @Column(name = "qr", nullable = false, unique = true)
    private String qr;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "presentacion", nullable = false, precision = 10, scale = 4)
    private Double presentacion;

    @Column(name = "unidadMedida", nullable = false)
    private String unidadMedida;

    @Column(name = "lote", nullable = false)
    private String lote;

    @Column(name = "fechaFabricacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFabricacion;

    @Column(name = "fechaVencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "palabraAdvertencia", nullable = false)
    private String palabraAdvertencia;

    @Column(name = "pictogramasSGA")
    private String pictogramasSGA;

    @Column(name = "frasesH")
    private String frasesH;

    @Column(name = "frasesP")
    private String frasesP;

    @Column(name = "fabricante", nullable = false)
    private String fabricante;

    @Column(name = "formula", nullable = false)
    private String formula;

    @Column(name = "fichaDatosSeguridad", nullable = false)
    private String fichaDatosSeguridad;

    @Column(name = "vigenciaFDS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vigenciaFDS;

    // Relación con RegistroUso
    @OneToMany(mappedBy = "reactivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroUso> registrosUso;

    // Constructor sin parámetros
    public Reactivo() {}

    // Constructor con parámetros
    public Reactivo(String nombreReactivo, String qr, String ubicacion, Double presentacion, String unidadMedida,
                    String lote, Date fechaFabricacion, Date fechaVencimiento, String palabraAdvertencia,
                    String pictogramasSGA, String frasesH, String frasesP, String fabricante, String formula,
                    String fichaDatosSeguridad, Date vigenciaFDS) {
        this.nombreReactivo = nombreReactivo;
        this.qr = qr;
        this.ubicacion = ubicacion;
        this.presentacion = presentacion;
        this.unidadMedida = unidadMedida;
        this.lote = lote;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.palabraAdvertencia = palabraAdvertencia;
        this.pictogramasSGA = pictogramasSGA;
        this.frasesH = frasesH;
        this.frasesP = frasesP;
        this.fabricante = fabricante;
        this.formula = formula;
        this.fichaDatosSeguridad = fichaDatosSeguridad;
        this.vigenciaFDS = vigenciaFDS;
    }

    // Getters y Setters
    // Incluye getters y setters para todos los atributos

    // Ejemplo de un getter y setter:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreReactivo() {
        return nombreReactivo;
    }

    public void setNombreReactivo(String nombreReactivo) {
        this.nombreReactivo = nombreReactivo;
    }

    // Métodos restantes...

    public List<RegistroUso> getRegistrosUso() {
        return registrosUso;
    }

    public void setRegistrosUso(List<RegistroUso> registrosUso) {
        this.registrosUso = registrosUso;
    }

    @Override
    public String toString() {
        return "Reactivo{" +
                "id=" + id +
                ", nombreReactivo='" + nombreReactivo + '\'' +
                ", qr='" + qr + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", presentacion=" + presentacion +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", lote='" + lote + '\'' +
                ", fechaFabricacion=" + fechaFabricacion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", palabraAdvertencia='" + palabraAdvertencia + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", formula='" + formula + '\'' +
                ", vigenciaFDS=" + vigenciaFDS +
                '}';
    }
}
