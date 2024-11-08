package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Reactivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReactivosRepository extends JpaRepository<Reactivos, Integer> {

    // Consulta personalizada para buscar reactivos por nombre
    Optional<List<Reactivos>> findByNombreReactivoContainingIgnoreCase(String nombreReactivo);

    // Consulta personalizada para obtener reactivos por CAS
    Optional<Reactivos> findByCas(String cas);

    // Consulta personalizada para buscar reactivos por ubicación
    List<Reactivos> findByUbicacion(String ubicacion);

    // Consulta personalizada para buscar reactivos con existencia menor a un valor específico
    List<Reactivos> findByExistenciaLessThan(Double existencia);

    // Consulta personalizada para buscar reactivos por palabra de advertencia
    List<Reactivos> findByPalabraAdvertencia(String palabraAdvertencia);
    
    // Consulta personalizada para otener reactivos por nombre
    Optional<Reactivos> findByNombre(String nombre);
}
