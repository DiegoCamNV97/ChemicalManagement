package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    // Método personalizado para buscar una empresa por nombre
    Optional<Empresa> findByNombre(String nombre);
}
