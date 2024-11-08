package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Empresa;
import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<Empresa> listarEmpresas();
    Optional<Empresa> buscarPorId(int id);
    Empresa guardarEmpresa(Empresa empresa);
    void eliminarEmpresa(int id);
    Optional<Empresa> buscarPorNombre(String nombre);
}
