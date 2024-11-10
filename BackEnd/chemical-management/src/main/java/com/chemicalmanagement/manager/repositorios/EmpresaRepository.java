package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Métodos personalizados de ser necesario, por ejemplo:
    Empresa findByNombre(String nombre);
}
