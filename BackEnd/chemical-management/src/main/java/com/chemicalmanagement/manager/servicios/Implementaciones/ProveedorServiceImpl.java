package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Proveedor;
import com.chemicalmanagement.manager.repositorios.ProveedorRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.ProveedorServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorServiceInt {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor actualizarProveedor(Long id, Proveedor proveedorActualizado) {
        return proveedorRepository.findById(id).map(proveedor -> {
            proveedor.setNombre(proveedorActualizado.getNombre());
            proveedor.setEmpresa(proveedorActualizado.getEmpresa());
            return proveedorRepository.save(proveedor);
        }).orElse(null);
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
