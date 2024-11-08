package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Empresa;
import com.chemicalmanagement.manager.repositorios.EmpresaRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.EmpresaServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaServiceInt {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> obtenerTodasLasEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> obtenerEmpresaPorId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa actualizarEmpresa(Long id, Empresa empresaActualizada) {
        return empresaRepository.findById(id).map(empresa -> {
            empresa.setNombre(empresaActualizada.getNombre());
            return empresaRepository.save(empresa);
        }).orElse(null);
    }

    @Override
    public void eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
