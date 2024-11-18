package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    
    // Método para buscar por nombre de fabricante
    List<Fabricante> findByNombreContaining(String nombre);
     @Query("SELECT f FROM Fabricante f WHERE LOWER(f.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Fabricante> buscarPorNombre(@Param("nombre") String nombre);
}

