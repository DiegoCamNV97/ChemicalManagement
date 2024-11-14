package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.RegistroUso;

import java.util.List;
import java.util.Optional;

public interface RegistroUsoService {
    List<RegistroUso> obtenerTodos();
    Optional<RegistroUso> obtenerPorId(Integer id);
    RegistroUso crear(RegistroUso registroUso);
    Optional<RegistroUso> actualizar(Integer id, RegistroUso registroUso);
    boolean eliminar(Integer id);
    List<RegistroUso> buscarPorUsuarioId(Integer usuarioId);
    List<RegistroUso> buscarPorReactivoId(Integer reactivoId);
    List<RegistroUso> buscarPorUsuarioIdYReactivoId(Integer usuarioId, Integer reactivoId);
}
