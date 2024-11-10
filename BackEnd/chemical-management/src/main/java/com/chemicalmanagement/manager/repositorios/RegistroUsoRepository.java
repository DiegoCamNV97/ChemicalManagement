package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroUsoRepository extends JpaRepository<RegistroUso, Long> {
    // Métodos personalizados para búsqueda por ID de Reactivo o Nombre del Reactivo
    List<RegistroUso> findByReactivoId(Long reactivoId);
    List<RegistroUso> findByReactivoNombreReactivoContainingIgnoreCase(String nombreReactivo);
}
