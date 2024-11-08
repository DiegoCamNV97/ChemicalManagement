package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Proveedor;
import com.chemicalmanagement.manager.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // Método personalizado para buscar proveedores por nombre
    List<Proveedor> findByNombre(String nombre);

    // Método personalizado para buscar proveedores por empresa
    List<Proveedor> findByEmpresa(Empresa empresa);
}
