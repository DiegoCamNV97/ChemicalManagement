package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Reactivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReactivoRepository extends JpaRepository<Reactivo, Integer> {
    
    // Buscar por CAS
    List<Reactivo> findByCas(String cas);

    // Buscar por nombre de reactivo
    List<Reactivo> findByNombreReactivoContaining(String nombreReactivo);

    // Buscar por fabricante
    List<Reactivo> findByFabricanteId(Integer fabricanteId);

    // Método para cargar un reactivo con su fabricante asociado usando JOIN FETCH
    @Query("SELECT r FROM Reactivo r JOIN FETCH r.fabricante WHERE r.id = :id")
    Optional<Reactivo> findByIdWithFabricante(@Param("id") Integer id);

    @Query("SELECT r FROM Reactivo r JOIN FETCH r.fabricante")
    List<Reactivo> findAllWithFabricante();

    @Query("SELECT r FROM Reactivo r WHERE r.fechaVencimiento BETWEEN :hoy AND :limite")
    List<Reactivo> findPorVencer(@Param("hoy") LocalDate hoy, @Param("limite") LocalDate limite);

    @Query("SELECT r FROM Reactivo r WHERE r.fechaVencimiento < :hoy")
    List<Reactivo> findVencidos(@Param("hoy") LocalDate hoy);

    @Query("SELECT r FROM Reactivo r WHERE r.existencia < :limite")
    List<Reactivo> findConPocoStock(@Param("limite") Double limite);

}
