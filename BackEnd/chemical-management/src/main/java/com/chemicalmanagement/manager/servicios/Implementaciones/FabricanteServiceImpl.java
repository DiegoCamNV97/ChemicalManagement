package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Fabricante;
import com.chemicalmanagement.manager.repositorios.FabricanteRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteServiceImpl implements FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> obtenerTodos() {
        return fabricanteRepository.findAll();
    }

    @Override
    public Optional<Fabricante> obtenerPorId(Integer id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public Fabricante crear(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public Optional<Fabricante> actualizar(Integer id, Fabricante fabricante) {
        return fabricanteRepository.findById(id).map(f -> {
            f.setNombre(fabricante.getNombre());
            f.setNumContacto(fabricante.getNumContacto());
            f.setDireccion(fabricante.getDireccion());
            f.setPais(fabricante.getPais());
            f.setNumeroEmergencia(fabricante.getNumeroEmergencia());
            return fabricanteRepository.save(f);
        });
    }

    @Override
    public boolean eliminar(Integer id) {
        if (fabricanteRepository.existsById(id)) {
            fabricanteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
