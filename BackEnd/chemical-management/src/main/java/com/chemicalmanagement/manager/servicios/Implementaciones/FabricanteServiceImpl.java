package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Fabricante;
import com.chemicalmanagement.manager.repositorios.FabricanteRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.FabricanteServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteServiceImpl implements FabricanteServiceInt {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> obtenerTodosLosFabricantes() {
        return fabricanteRepository.findAll();
    }

    @Override
    public Optional<Fabricante> obtenerFabricantePorId(Long id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public Fabricante guardarFabricante(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public Fabricante actualizarFabricante(Long id, Fabricante fabricanteActualizado) {
        return fabricanteRepository.findById(id).map(fabricante -> {
            fabricante.setNombre(fabricanteActualizado.getNombre());
            return fabricanteRepository.save(fabricante);
        }).orElse(null);
    }

    @Override
    public void eliminarFabricante(Long id) {
        fabricanteRepository.deleteById(id);
    }
}
