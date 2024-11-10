package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Reactivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactivosRepository extends JpaRepository<Reactivo, Long> {
    List<Reactivo> findByNombreReactivoContainingIgnoreCase(String nombreReactivo);
    List<Reactivo> findByQr(String qr);
    List<Reactivo> findByNombreReactivoOrQrOrCas(String nombreReactivo, String qr, String cas);
}
