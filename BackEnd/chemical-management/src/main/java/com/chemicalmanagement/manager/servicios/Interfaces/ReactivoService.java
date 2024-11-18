package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Reactivo;

import java.util.*;

public interface ReactivoService {
    List<Reactivo> obtenerTodos();
    Optional<Reactivo> obtenerPorId(Integer id); // Este método sigue igual
    Reactivo crear(Reactivo reactivo);
    Optional<Reactivo> actualizar(Integer id, Reactivo reactivo);
    boolean eliminar(Integer id);
    List<Reactivo> buscarPorNombre(String nombreReactivo);
    List<Reactivo> buscarPorCas(String cas);
    List<Reactivo> buscarPorFabricanteId(Integer fabricanteId);
    List<Reactivo> obtenerPorVencer();
    List<Reactivo> obtenerVencidos();
    List<Reactivo> obtenerConPocoStock();

}
