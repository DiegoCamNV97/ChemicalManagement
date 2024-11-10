package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Reactivo;
import java.util.List;

public interface ReactivosService {
    Reactivo guardarReactivo(Reactivo reactivo);
    Reactivo actualizarReactivo(Reactivo reactivo);
    void eliminarReactivo(Long id);
    Reactivo obtenerReactivoPorId(Long id);
    List<Reactivo> buscarReactivosPorNombre(String nombreReactivo);
    List<Reactivo> buscarReactivosPorCodigo(String qr);
    List<Reactivo> buscarReactivosPorNombreCodigoOCas(String nombreReactivo, String qr, String cas);
    List<Reactivo> listarReactivos();
}
