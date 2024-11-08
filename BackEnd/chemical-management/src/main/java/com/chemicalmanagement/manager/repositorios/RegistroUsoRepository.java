package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegistroUsoRepository extends JpaRepository<RegistroUso, Integer> {

    // Consulta personalizada para buscar registros de uso por una fecha específica
    List<RegistroUso> findByFechaUso(Date fechaUso);

    // Consulta personalizada para buscar registros de uso entre dos fechas
    List<RegistroUso> findByFechaUsoBetween(Date startDate, Date endDate);

    // Consulta personalizada para buscar registros de un usuario específico
    List<RegistroUso> findByUsuariosId(Integer usuarioId);

    // Consulta personalizada para obtener registros de un reactivo específico
    List<RegistroUso> findByReactivosId(Integer reactivoId);

}
