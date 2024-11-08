package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.repositorios.ReactivoRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivoServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReactivoServiceImpl implements ReactivoServiceInt {

    @Autowired
    private ReactivoRepository reactivoRepository;

    @Override
    public List<Reactivo> obtenerTodosLosReactivos() {
        return reactivoRepository.findAll();
    }

    @Override
    public Optional<Reactivo> obtenerReactivoPorId(Long id) {
        return reactivoRepository.findById(id);
    }

    @Override
    public Reactivo guardarReactivo(Reactivo reactivo) {
        return reactivoRepository.save(reactivo);
    }

    @Override
    public Reactivo actualizarReactivo(Long id, Reactivo reactivoActualizado) {
        return reactivoRepository.findById(id).map(reactivo -> {
            reactivo.setNombre(reactivoActualizado.getNombre());
            reactivo.setCodigo(reactivoActualizado.getCodigo());
            reactivo.setUnidad(reactivoActualizado.getUnidad());
            reactivo.setCantidad(reactivoActualizado.getCantidad());
            reactivo.setFabricante(reactivoActualizado.getFabricante());
            reactivo.setProveedor(reactivoActualizado.getProveedor());
            return reactivoRepository.save(reactivo);
        }).orElse(null);
    }

    @Override
    public void eliminarReactivo(Long id) {
        reactivoRepository.deleteById(id);
    }
}
