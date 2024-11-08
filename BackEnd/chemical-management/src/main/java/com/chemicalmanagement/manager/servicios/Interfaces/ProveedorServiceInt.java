package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Proveedor;
import java.util.List;
import java.util.Optional;

public interface ProveedorServiceInt {
    List<Proveedor> obtenerTodosLosProveedores();
    Optional<Proveedor> obtenerProveedorPorId(Long id);
    Proveedor guardarProveedor(Proveedor proveedor);
    Proveedor actualizarProveedor(Long id, Proveedor proveedorActualizado);
    void eliminarProveedor(Long id);
}
