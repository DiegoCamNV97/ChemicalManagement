package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroUsoRepository extends JpaRepository<RegistroUso, Integer> {
    
    // Buscar por usuario
    List<RegistroUso> findByUsuarioId(Integer usuarioId);

    // Buscar por reactivo
    List<RegistroUso> findByReactivoId(Integer reactivoId);

    // Buscar por usuario y reactivo
    List<RegistroUso> findByUsuarioIdAndReactivoId(Integer usuarioId, Integer reactivoId);
}
