package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Fabricante;

import java.util.List;
import java.util.Optional;

public interface FabricanteService {
    List<Fabricante> obtenerTodos();
    Optional<Fabricante> obtenerPorId(Integer id);
    Fabricante crear(Fabricante fabricante);
    Optional<Fabricante> actualizar(Integer id, Fabricante fabricante);
    boolean eliminar(Integer id);
}
