package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Empresa;
import java.util.List;

public interface EmpresaService {
    Empresa guardarEmpresa(Empresa empresa);
    Empresa actualizarEmpresa(Empresa empresa);
    void eliminarEmpresa(Long id);
    Empresa obtenerEmpresaPorId(Long id);
    Empresa obtenerEmpresaPorNombre(String nombre);
    List<Empresa> listarEmpresas();
}
