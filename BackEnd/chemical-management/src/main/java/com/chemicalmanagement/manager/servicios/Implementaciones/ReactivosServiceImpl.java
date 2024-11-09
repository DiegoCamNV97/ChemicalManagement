package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Reactivos;
import com.chemicalmanagement.manager.repositorios.ReactivosRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReactivosServiceImpl implements ReactivosService {

    @Autowired
    private ReactivosRepository reactivosRepository;

    @Override
    public List<Reactivos> listarReactivos() {
        return reactivosRepository.findAll();
    }

    @Override
    public Optional<Reactivos> buscarPorId(int id) {
        return reactivosRepository.findById(id);
    }

    @Override
    public Reactivos guardarReactivo(Reactivos reactivo) {
        return reactivosRepository.save(reactivo);
    }

    @Override
    public void eliminarReactivo(int id) {
        reactivosRepository.deleteById(id);
    }

    @Override
    public Optional<Reactivos> buscarPorNombre(String nombre) {
        return reactivosRepository.findByNombreReactivo(nombre);
    }
    @Override
    public List<Reactivos> listarTodos() {
        return reactivosRepository.findAll();
    }

    @Override
    public List<Reactivos> buscarPorParametros(Integer id, String nombre, String cas) {
        return reactivosRepository.buscarPorParametros(id, nombre, cas);
    }
}
