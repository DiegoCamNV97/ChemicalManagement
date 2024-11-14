package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    
    // Método para buscar por nombre de fabricante
    List<Fabricante> findByNombreContaining(String nombre);
}
