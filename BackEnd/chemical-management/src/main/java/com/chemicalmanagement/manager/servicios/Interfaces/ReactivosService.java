package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Reactivos;
import java.util.List;
import java.util.Optional;

public interface ReactivosService {
    List<Reactivos> listarReactivos();
    Optional<Reactivos> buscarPorId(int id);
    Reactivos guardarReactivo(Reactivos reactivo);
    void eliminarReactivo(int id);
    Optional<Reactivos> buscarPorNombre(String nombre);
    
}
