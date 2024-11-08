package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Fabricante;
import java.util.List;
import java.util.Optional;

public interface FabricanteServiceInt {
    List<Fabricante> obtenerTodosLosFabricantes();
    Optional<Fabricante> obtenerFabricantePorId(Long id);
    Fabricante guardarFabricante(Fabricante fabricante);
    Fabricante actualizarFabricante(Long id, Fabricante fabricanteActualizado);
    void eliminarFabricante(Long id);
}
