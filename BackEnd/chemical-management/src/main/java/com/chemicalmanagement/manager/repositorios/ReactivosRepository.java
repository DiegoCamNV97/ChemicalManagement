package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Reactivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;



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
    Optional<Reactivos> findByNombreReactivo(String nombreReactivo);

    @Query("SELECT r FROM Reactivos r WHERE " +
           "(COALESCE(:id, null) IS NULL OR r.id = :id) AND " +
           "(COALESCE(:nombre, '') = '' OR r.nombreReactivo LIKE %:nombre%) AND " +
           "(COALESCE(:cas, '') = '' OR r.cas = :cas)")
    List<Reactivos> buscarPorParametros(@Param("id") Integer id,
                                        @Param("nombre") String nombre,
                                        @Param("cas") String cas);
}