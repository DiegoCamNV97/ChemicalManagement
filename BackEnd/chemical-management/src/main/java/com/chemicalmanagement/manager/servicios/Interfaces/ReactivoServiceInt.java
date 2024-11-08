package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Reactivo;
import java.util.List;
import java.util.Optional;

public interface ReactivoServiceInt {
    List<Reactivo> obtenerTodosLosReactivos();
    Optional<Reactivo> obtenerReactivoPorId(Long id);
    Reactivo guardarReactivo(Reactivo reactivo);
    Reactivo actualizarReactivo(Long id, Reactivo reactivoActualizado);
    void eliminarReactivo(Long id);
}
