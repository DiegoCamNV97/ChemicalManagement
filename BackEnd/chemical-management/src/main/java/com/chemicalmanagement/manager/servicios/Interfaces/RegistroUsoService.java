package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import java.util.List;
import java.util.Optional;

public interface RegistroUsoService {
    List<RegistroUso> listarTodos();
    Optional<RegistroUso> buscarPorId(int id);
    RegistroUso guardarRegistro(RegistroUso registroUso);
    void eliminarRegistro(int id);
}
