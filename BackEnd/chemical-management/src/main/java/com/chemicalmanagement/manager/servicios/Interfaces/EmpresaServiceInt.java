package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Empresa;
import java.util.List;
import java.util.Optional;

public interface EmpresaServiceInt {
    List<Empresa> obtenerTodasLasEmpresas();
    Optional<Empresa> obtenerEmpresaPorId(Long id);
    Empresa guardarEmpresa(Empresa empresa);
    Empresa actualizarEmpresa(Long id, Empresa empresaActualizada);
    void eliminarEmpresa(Long id);
}
