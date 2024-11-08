package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Empresa;
import com.chemicalmanagement.manager.repositorios.EmpresaRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> buscarPorId(int id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void eliminarEmpresa(int id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Optional<Empresa> buscarPorNombre(String nombre) {
        return empresaRepository.findByNombre(nombre);
    }
}
