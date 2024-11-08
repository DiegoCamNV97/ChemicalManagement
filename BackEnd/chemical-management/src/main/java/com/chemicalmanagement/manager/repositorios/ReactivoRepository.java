package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.entidades.Fabricante;
import com.chemicalmanagement.manager.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReactivoRepository extends JpaRepository<Reactivo, Long> {

    // Método para buscar reactivos por nombre
    List<Reactivo> findByNombre(String nombre);

    // Método para buscar reactivos por código
    List<Reactivo> findByCodigo(String codigo);

    // Método para buscar reactivos por fabricante
    List<Reactivo> findByFabricante(Fabricante fabricante);

    // Método para buscar reactivos por proveedor
    List<Reactivo> findByProveedor(Proveedor proveedor);
}
