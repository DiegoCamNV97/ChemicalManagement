package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    // Método personalizado para buscar un fabricante por nombre
    Optional<Fabricante> findByNombre(String nombre);
}
