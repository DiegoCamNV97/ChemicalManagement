package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import java.util.List;

public interface RegistroUsoService {
    RegistroUso guardarRegistroUso(RegistroUso registroUso);
    RegistroUso actualizarRegistroUso(RegistroUso registroUso);
    void eliminarRegistroUso(Long id);
    RegistroUso obtenerRegistroUsoPorId(Long id);
    List<RegistroUso> buscarRegistrosPorReactivoId(Long reactivoId);
    List<RegistroUso> buscarRegistrosPorNombreReactivo(String nombreReactivo);
    List<RegistroUso> listarRegistrosUso();
}
