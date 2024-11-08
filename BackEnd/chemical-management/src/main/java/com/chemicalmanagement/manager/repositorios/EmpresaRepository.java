package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    // Consulta personalizada para encontrar una empresa por nombre
    Optional<Empresa> findByNombre(String nombre);

    // Consulta personalizada para encontrar una empresa por su contacto único
    Optional<Empresa> findByNumContacto(String numContacto);
}
